package es.um.uschema.xtext.athena.main

import es.um.uschema.xtext.athena.m2t.Athena2Cassandra
import es.um.uschema.xtext.athena.utils.config.Athena2CassandraConfig
import es.um.uschema.xtext.athena.utils.io.CodeWriter
import es.um.uschema.xtext.athena.utils.io.AthenaIO

class Athena2CassandraMain
{
  def static void main(String[] args)
  {
    // val customArgs = newArrayList("-i", "../../es.um.uschema.xtext.models/thesis/athena/SoftwareDev.athena", "-o", "../../es.um.uschema.xtext.models/thesis/athena/")

    val config = new Athena2CassandraConfig(args)

    runAthena2Cassandra(config)
  }

  private static def void runAthena2Cassandra(Athena2CassandraConfig config)
  {
    val inputModel = config.inputModel
    val inputPath = config.inputPath
    val outputPath = config.outputPath

    val athenaIO = new AthenaIO()
    val transformer = new Athena2Cassandra()
    val codeWriter = new CodeWriter()

    println("ATHENA> Generating Cassandra code...")

    outputPath.toFile.mkdirs

    val iterateModels = inputModel === null ? inputPath.toFile.listFiles[f | f.name.endsWith(".athena")].toSet : #{ inputModel.toFile }

    for (model : iterateModels)
    {
      println("ATHENA>> Model: " + model.name)
      val result = transformer.m2t(athenaIO.load(model.toPath))
      codeWriter.write(result, outputPath.resolve(model.name.replace(".athena", ".cql")))
    }

    println("ATHENA> Cassandra generation finished!")
  }
}
