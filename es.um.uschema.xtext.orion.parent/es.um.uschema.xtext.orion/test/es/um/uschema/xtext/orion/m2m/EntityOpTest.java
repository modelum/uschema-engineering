package es.um.uschema.xtext.orion.m2m;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import es.um.uschema.xtext.athena.athena.AthenaSchema;
import es.um.uschema.xtext.athena.utils.io.AthenaIO;
import es.um.uschema.xtext.orion.utils.io.OrionIO;
import es.um.uschema.xtext.orion.orion.OrionOperations;

class EntityOpTest
{
  private Path testPath_1 = Path.of("models/tests/m2m/entity_ops/ImportEntity_Ops.orion");
  private Path testPath_2 = Path.of("models/tests/m2m/entity_ops/ScriptEntity_Ops.orion");
  private OrionIO orionIO       = new OrionIO();
  private AthenaIO athenaIO     = new AthenaIO();

  @Test
  void testEntityOperations_Import()
  {
    OrionOperations orion = orionIO.load(testPath_1);
    AthenaSchema schema = new Orion2Athena().m2m(orion, false).get(0);

    assertEquals("Schema EntitySchema:2\r\n"
        + "\r\n"
        + "entity EntityToAdd_1\r\n"
        + "{\r\n"
        + "  +key: String\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityToRename_1\r\n"
        + "{\r\n"
        + "  +key: String,\r\n"
        + "  attr1: Number\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityRenamed_1\r\n"
        + "{\r\n"
        + "  +key: String,\r\n"
        + "  attr3: Boolean\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityRenamed_2\r\n"
        + "{\r\n"
        + "  +key: String,\r\n"
        + "  attr2: String\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityToExtract_1\r\n"
        + "{\r\n"
        + "  +key: String,\r\n"
        + "  attr1: Number,\r\n"
        + "  attr2: String,\r\n"
        + "  attr3: List<Option < String , Boolean >>\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityToExtract_2\r\n"
        + "{\r\n"
        + "  common\r\n"
        + "  {\r\n"
        + "    +key: String,\r\n"
        + "    attr1: Number\r\n"
        + "  }\r\n"
        + "  variation 1\r\n"
        + "  {\r\n"
        + "    attr2: String\r\n"
        + "  }\r\n"
        + "  variation 2\r\n"
        + "  {\r\n"
        + "    attr3: List<Option < String , Boolean >>\r\n"
        + "  }\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityToDelVar_1\r\n"
        + "{\r\n"
        + "  +key: String,\r\n"
        + "  attr1: Number\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityToDelVar_2\r\n"
        + "{\r\n"
        + "  common\r\n"
        + "  {\r\n"
        + "    +key: String,\r\n"
        + "    attr: Number\r\n"
        + "  }\r\n"
        + "  variation 1\r\n"
        + "  {\r\n"
        + "    attr1: String\r\n"
        + "  }\r\n"
        + "  variation 2\r\n"
        + "  {\r\n"
        + "    attr3: List<Option < String , Boolean >>\r\n"
        + "  }\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityToAdapt_1\r\n"
        + "{\r\n"
        + "  +key: String,\r\n"
        + "  attr1: Number\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityToAdapt_2\r\n"
        + "{\r\n"
        + "  common\r\n"
        + "  {\r\n"
        + "    +key: String,\r\n"
        + "    attr: Number\r\n"
        + "  }\r\n"
        + "  variation 1\r\n"
        + "  {\r\n"
        + "    attr1: String\r\n"
        + "  }\r\n"
        + "  variation 2\r\n"
        + "  {\r\n"
        + "    attr3: List<Option < String , Boolean >>\r\n"
        + "  }\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityToUnion_1\r\n"
        + "{\r\n"
        + "  +key: String,\r\n"
        + "  attr1: Number\r\n"
        + "}\r\n"
        + "\r\n"
        + "root entity EntityToAdd_2\r\n"
        + "{\r\n"
        + "  +id: Identifier,\r\n"
        + "  attr: String\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityExtracted_1\r\n"
        + "{\r\n"
        + "  +key: String,\r\n"
        + "  attr1: Number,\r\n"
        + "  attr3: List<Option < String , Boolean >>\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityExtracted_2\r\n"
        + "{\r\n"
        + "  +key: String,\r\n"
        + "  attr1: Number,\r\n"
        + "  ?attr3: List<Option < String , Boolean >>\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntitySplit11\r\n"
        + "{\r\n"
        + "  +key: String,\r\n"
        + "  attr1: Number,\r\n"
        + "  attr3: List<Option < String , Boolean >>\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntitySplit12\r\n"
        + "{\r\n"
        + "  +key: String,\r\n"
        + "  attr1: Number,\r\n"
        + "  attr2: String\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntitySplit21\r\n"
        + "{\r\n"
        + "  +key: String,\r\n"
        + "  attr1: Number,\r\n"
        + "  ?attr3: List<Option < String , Boolean >>\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntitySplit22\r\n"
        + "{\r\n"
        + "  +key: String,\r\n"
        + "  attr1: Number,\r\n"
        + "  ?attr2: String\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityMerged\r\n"
        + "{\r\n"
        + "  +key: String,\r\n"
        + "  attr1: List<Option < String , Boolean >>,\r\n"
        + "  attr2: Number,\r\n"
        + "  ?attr3: String,\r\n"
        + "  ?attr4: List<Option < String , Boolean >>\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityToUnion_2\r\n"
        + "{\r\n"
        + "  common\r\n"
        + "  {\r\n"
        + "    +key: String,\r\n"
        + "    attr: Number,\r\n"
        + "    attr1: String,\r\n"
        + "    attr2: Boolean,\r\n"
        + "    attr3: List<Option < String , Boolean >>\r\n"
        + "  }\r\n"
        + "  variation 1\r\n"
        + "}\r\n", athenaIO.serialize(schema));
  }

  @Test
  void testEntityOperations_Script()
  {
    OrionOperations orion = orionIO.load(testPath_2);
    AthenaSchema schema = new Orion2Athena().m2m(orion).get(0);

    assertEquals("Schema ScriptEntity_Ops:1\r\n"
        + "\r\n"
        + "root entity EntityAdded1\r\n"
        + "{\r\n"
        + "  +id: Identifier\r\n"
        + "}\r\n"
        + "\r\n"
        + "root entity EntityRenamed\r\n"
        + "{\r\n"
        + "  +id: Identifier\r\n"
        + "}\r\n"
        + "\r\n"
        + "root entity EntitySplit1\r\n"
        + "{\r\n"
        + "  +id: Identifier,\r\n"
        + "  attr1: String,\r\n"
        + "  attr2: String,\r\n"
        + "  attr3: String\r\n"
        + "}\r\n"
        + "\r\n"
        + "root entity EntitySplit2\r\n"
        + "{\r\n"
        + "  +id: Identifier,\r\n"
        + "  attr1: String,\r\n"
        + "  attr5: String,\r\n"
        + "  attr6: String\r\n"
        + "}\r\n"
        + "\r\n"
        + "root entity EntityMerged\r\n"
        + "{\r\n"
        + "  +id: String,\r\n"
        + "  a: String,\r\n"
        + "  b: Number,\r\n"
        + "  c: List\r\n"
        + "}\r\n"
        + "\r\n"
        + "root entity EntityToExtract\r\n"
        + "{\r\n"
        + "  +id: Identifier,\r\n"
        + "  feat1,\r\n"
        + "  feat2,\r\n"
        + "  feat3,\r\n"
        + "  feat4\r\n"
        + "}\r\n"
        + "\r\n"
        + "root entity EntityExtracted\r\n"
        + "{\r\n"
        + "  +id: Identifier,\r\n"
        + "  feat2,\r\n"
        + "  feat4\r\n"
        + "}\r\n", athenaIO.serialize(schema));
  }
}
