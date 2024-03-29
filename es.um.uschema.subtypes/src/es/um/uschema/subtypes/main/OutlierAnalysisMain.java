package es.um.uschema.subtypes.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

import es.um.uschema.USchema.USchema;
import es.um.uschema.subtypes.outliers.OutlierDetector;
import es.um.uschema.subtypes.outliers.OutlierTransformer;
import es.um.uschema.subtypes.timestamp.output.TimestampCSVWriter;
import es.um.uschema.subtypes.util.SubtypeSerializer;
import es.um.uschema.subtypes.util.configuration.OutlierAnalysisConfig;
import es.um.uschema.utils.EcoreModelIO;

public class OutlierAnalysisMain
{
  /**
   * This main function is used to create, for each model, four files:
   *   - A CSV file with entityTypes, variations, counts and timestamps.
   *   - A CSV "live" file with the same as before but only storing non-outlier variations.
   *   - A CSV "outlier" file with the same as before but only storing outlier variations.
   *   - A TXT file proposing migrations for each outlier variation to become a non-outlier variation.
   *   - And a lot of charts representing the CSV information.
   usage: <Outlier analysis>
     -cov,--coverage <value>   Apply coverage outlier detection
     -ep,--epsilon <value>     Apply epsilon outlier detection
     -h,--help                 Prints help
     -i,--input <model>        Path to the input U-Schema model
     -o,--output <folder>      Path to an output folder
   */
  public static void main(String[] args)
  {
    // String[] args_facebook = { "-i", "../es.um.uschema.models/facebook/facebook.xmi", "-cov", "99", "-o", "output" };
    // String[] args_harvard = { "-i", "../es.um.uschema.models/harvard/harvard.xmi", "-cov", "99", "-o", "output" };
    // String[] args_links = { "-i", "../es.um.uschema.models/links/links.xmi", "-cov", "99", "-o", "output" };
    // String[] args_opensanctions = { "-i", "../es.um.uschema.models/opensanctions/opensanctions.xmi", "-cov", "99", "-o", "output" };
    // String[] args_stackoverflow = { "-i", "../es.um.uschema.models/stackoverflow/stackoverflow.xmi", "-cov", "99", "-o", "output" };
    String[] args_reddit = { "-i", "../es.um.uschema.xtext.models/thesis/subtypes/reddit.xmi", "-cov", "99", "-o", "output" };
    // String[] args_webclicks = { "-i", "../es.um.uschema.models/webclicks/webclicks.xmi", "-cov", "99", "-o", "output" };

    OutlierAnalysisConfig config = new OutlierAnalysisConfig(args_reddit);

    runOutlierAnalysis(config);
  }

  private static void runOutlierAnalysis(OutlierAnalysisConfig config)
  {
    Path inputPath = config.getInputPath();
    OutlierDetector oDetector = config.getOutlierDetector();
    Path outputPath = config.getOutputPath();

    EcoreModelIO loader = new EcoreModelIO();
    USchema schema = loader.load(USchema.class, inputPath);
    TimestampCSVWriter writer = new TimestampCSVWriter();
    String schemaName = schema.getName();

    outputPath.toFile().mkdirs();

    // First, save the CSV schema files as is (live and outlier variations)
    writer.generateOutput(outputPath, schema);

    oDetector.removeOutliers(schema);
    // Now, save the CSV schema files with only its live variations
    schema.setName(schemaName + "_livevars");
    writer.generateOutput(outputPath, schema);

    // Now, save the CSV schema files with only its outliers
    schema.setName(schemaName);
    OutlierTransformer transformer = new OutlierTransformer(schema, oDetector.getOutliers());
    writer.generateOutput(outputPath, transformer.getOutlierSchema());

    transformer.analyzeAlternativeVariations(1);
    // Now, save the relation of outliers and their most similar live variations
    SubtypeSerializer printer = new SubtypeSerializer();
    Path outputFilePath = outputPath.resolve(schemaName + "_transform.txt");

    try
    {
        PrintWriter pWriter = new PrintWriter(outputFilePath.toString(), "UTF-8");
        pWriter.print(printer.printPretty(transformer));
        pWriter.close();
    } catch (IOException e)
    {
        e.printStackTrace();
    }
  }
}
