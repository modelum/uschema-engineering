package es.um.uschema.subtypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.client.MongoCollection;

import es.um.uschema.documents.injectors.adapters.mongodb.MongoDbAdapter;
import es.um.uschema.documents.injectors.adapters.mongodb.MongoDbClient;
import es.um.uschema.USchema.Feature;
import es.um.uschema.USchema.SchemaType;
import es.um.uschema.USchema.USchema;
import es.um.uschema.utils.EcoreModelIO;
import es.um.uschema.subtypes.discovery.DependencyAnalyzer;
import es.um.uschema.subtypes.discovery.discriminator.MongoDBSeeker;
import es.um.uschema.subtypes.outliers.OutlierDetector;
import es.um.uschema.subtypes.outliers.impl.CoverageOutlierDetector;
import es.um.uschema.subtypes.util.types.EntitySubtype;

public class ProductsTest
{
    private MongoDbClient client;
    private String dbName;
    private String inputModel;
    private USchema schema;

    @Before
    public void setUp() throws Exception
    {
        client = MongoDbAdapter.getMongoDbClient("localhost");
        dbName = "products";
        inputModel = "../es.um.uschema.models/" + dbName + "/" + dbName + ".xmi";

        EcoreModelIO loader = new EcoreModelIO();
        schema = loader.load(USchema.class, Path.of(inputModel));
    }

    @After
    public void tearDown() throws Exception
    {
        client.shutdown();
    }

    @Test
    public void testSubtypes()
    {
        String collName = "Products";
        // Detect and remove outliers given Coverage = 99.9%
        OutlierDetector oDetector = new CoverageOutlierDetector(99);
        oDetector.removeOutliers(schema);

        // Analyze each feature
        for (SchemaType sType : schema.getEntities().stream().filter(ent -> ent.getName().equals(collName))
                .collect(Collectors.toList()))
        {
            DependencyAnalyzer depDetector = new DependencyAnalyzer(sType, new MongoDBSeeker(dbName));
            depDetector.doDependencyAnalysis();
            assertEquals(4, depDetector.getSubtypes().size());

            EntitySubtype subtype0 = depDetector.getSubtypes().get(0);
            assertEquals(2, subtype0.getSubtypeRequiredFeatures().size());
            assertEquals(2, subtype0.getSubtypeOptionalFeatures().size());

            EntitySubtype subtype1 = depDetector.getSubtypes().get(1);
            assertEquals(2, subtype1.getSubtypeRequiredFeatures().size());
            assertEquals(0, subtype1.getSubtypeOptionalFeatures().size());

            EntitySubtype subtype2 = depDetector.getSubtypes().get(2);
            assertEquals(1, subtype2.getSubtypeRequiredFeatures().size());
            assertEquals(1, subtype2.getSubtypeOptionalFeatures().size());

            EntitySubtype subtype3 = depDetector.getSubtypes().get(3);
            assertEquals(1, subtype3.getSubtypeRequiredFeatures().size());
            assertEquals(0, subtype3.getSubtypeOptionalFeatures().size());

            Feature discriminator = depDetector.getDiscriminatorSeeker().getDiscriminator();
            assertEquals("product_type", discriminator.getName());
            List<String> discriminatorValues = depDetector.getDiscriminatorSeeker().getDiscriminatorValues().values()
                    .stream().map(obj -> (String) obj).collect(Collectors.toList());
            Collections.sort(discriminatorValues);
            assertEquals(Arrays.asList("clothing", "laptops", "printed media", "toys"), discriminatorValues);

            MongoCollection<Document> documents = client.getDatabase(dbName).getCollection(collName);
            List<EntitySubtype> filteredSubtypes = depDetector.getSubtypes().stream()
                    .filter(subtype -> !subtype.getSubtypeRequiredFeatures().isEmpty()).collect(Collectors.toList());

            for (Document doc : documents.find())
            {
                EntitySubtype theSubtype = detectSubtype(filteredSubtypes, doc);
                assertNotNull(theSubtype);
                assertEquals(depDetector.getDiscriminatorSeeker().getDiscriminatorValues().get(theSubtype),
                        doc.get("product_type"));
            }
        }
    }

    private EntitySubtype detectSubtype(List<EntitySubtype> subtypes, Document doc)
    {
        Optional<EntitySubtype> optional = subtypes.stream()
                .filter(subtype -> {
                    // Check each subtype identifying feature appears on the document, regardless of its value.
                    return subtype.getSubtypeRequiredFeatures().stream()
                            .allMatch(feat -> doc.containsKey(feat.getName()));
                    // Apparently we only have to check features by name, not by type value, so...
                })
                .findAny();

        if (optional.isPresent())
            return optional.get();
        return null;
    }
}
