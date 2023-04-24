package es.um.uschema.xtext.orion.m2m;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import es.um.uschema.xtext.athena.athena.AthenaSchema;
import es.um.uschema.xtext.athena.utils.io.AthenaIO;
import es.um.uschema.xtext.orion.utils.io.OrionIO;
import es.um.uschema.xtext.orion.orion.OrionOperations;

class ReferenceOpTest
{
  private Path testPath_1 = Path.of("models/tests/m2m/reference_ops/ImportReference_Ops.orion");
  private Path testPath_2 = Path.of("models/tests/m2m/reference_ops/ScriptReference_Ops.orion");
  private OrionIO orionIO          = new OrionIO();
  private AthenaIO athenaIO        = new AthenaIO();

  @Test
  void testReferenceOperations_Import()
  {
    OrionOperations orion = orionIO.load(testPath_1);
    AthenaSchema schema = new Orion2Athena().m2m(orion, false).get(0);

    assertEquals("Schema ReferenceSchema:2\r\n"
        + "\r\n"
        + "root entity EntityDummy\r\n"
        + "{\r\n"
        + "  +id: Identifier\r\n"
        + "}\r\n"
        + "\r\n"
        + "root entity EntityAddRef1\r\n"
        + "{\r\n"
        + "  +id: Identifier,\r\n"
        + "  ref1: ref<EntityDummy as String>&,\r\n"
        + "  ref2: ref<EntityDummy as Integer>+\r\n"
        + "}\r\n"
        + "\r\n"
        + "root entity EntityAddRef2\r\n"
        + "{\r\n"
        + "  common\r\n"
        + "  {\r\n"
        + "    +id: Identifier,\r\n"
        + "    ref1: ref<EntityDummy as String>&,\r\n"
        + "    ref2: ref<EntityDummy as Integer>+\r\n"
        + "  }\r\n"
        + "  variation 1\r\n"
        + "  {\r\n"
        + "    attr1\r\n"
        + "  }\r\n"
        + "  variation 2\r\n"
        + "  {\r\n"
        + "    attr2\r\n"
        + "  }\r\n"
        + "}\r\n"
        + "\r\n"
        + "root entity EntityAddRef3\r\n"
        + "{\r\n"
        + "  common\r\n"
        + "  {\r\n"
        + "    +id: Identifier\r\n"
        + "  }\r\n"
        + "  variation 1\r\n"
        + "  {\r\n"
        + "    attr1,\r\n"
        + "    ref1: ref<EntityDummy as String>&\r\n"
        + "  }\r\n"
        + "  variation 2\r\n"
        + "  {\r\n"
        + "    attr2,\r\n"
        + "    ref2: ref<EntityDummy as Integer>+\r\n"
        + "  }\r\n"
        + "}\r\n"
        + "\r\n"
        + "root entity EntityCastRef1\r\n"
        + "{\r\n"
        + "  +id: Identifier,\r\n"
        + "  ref1: ref<EntityDummy as String>&,\r\n"
        + "  ref2: ref<EntityDummy as String>+\r\n"
        + "}\r\n"
        + "\r\n"
        + "root entity EntityCastRef2\r\n"
        + "{\r\n"
        + "  common\r\n"
        + "  {\r\n"
        + "    +id: Identifier,\r\n"
        + "    ref1: ref<EntityDummy as String>&\r\n"
        + "  }\r\n"
        + "  variation 1\r\n"
        + "  {\r\n"
        + "    ref2: ref<EntityDummy as Identifier>&\r\n"
        + "  }\r\n"
        + "  variation 2\r\n"
        + "  {\r\n"
        + "    ref3: ref<EntityDummy as String>+\r\n"
        + "  }\r\n"
        + "}\r\n"
        + "\r\n"
        + "root entity EntityCastRef3\r\n"
        + "{\r\n"
        + "  common\r\n"
        + "  {\r\n"
        + "    +id: Identifier\r\n"
        + "  }\r\n"
        + "  variation 1\r\n"
        + "  {\r\n"
        + "    ref1: ref<EntityDummy as String>&,\r\n"
        + "    attr1\r\n"
        + "  }\r\n"
        + "  variation 2\r\n"
        + "  {\r\n"
        + "    ref1: ref<EntityDummy as Identifier>&\r\n"
        + "  }\r\n"
        + "  variation 3\r\n"
        + "  {\r\n"
        + "    attr3\r\n"
        + "  }\r\n"
        + "}\r\n"
        + "\r\n"
        + "root entity EntityMultRef1\r\n"
        + "{\r\n"
        + "  +id: Identifier,\r\n"
        + "  ref1: ref<EntityDummy as Identifier>&,\r\n"
        + "  ref2: ref<EntityDummy as Identifier>&\r\n"
        + "}\r\n"
        + "\r\n"
        + "root entity EntityMultRef2\r\n"
        + "{\r\n"
        + "  common\r\n"
        + "  {\r\n"
        + "    +id: Identifier,\r\n"
        + "    ref1: ref<EntityDummy as Identifier>&\r\n"
        + "  }\r\n"
        + "  variation 1\r\n"
        + "  {\r\n"
        + "    ref2: ref<EntityDummy as Identifier>&\r\n"
        + "  }\r\n"
        + "  variation 2\r\n"
        + "  {\r\n"
        + "    ref3: ref<EntityDummy as Identifier>+\r\n"
        + "  }\r\n"
        + "}\r\n"
        + "\r\n"
        + "root entity EntityMultRef3\r\n"
        + "{\r\n"
        + "  common\r\n"
        + "  {\r\n"
        + "    +id: Identifier\r\n"
        + "  }\r\n"
        + "  variation 1\r\n"
        + "  {\r\n"
        + "    ref1: ref<EntityDummy as Identifier>&,\r\n"
        + "    attr1\r\n"
        + "  }\r\n"
        + "  variation 2\r\n"
        + "  {\r\n"
        + "    ref1: ref<EntityDummy as Identifier>&\r\n"
        + "  }\r\n"
        + "  variation 3\r\n"
        + "  {\r\n"
        + "    attr3\r\n"
        + "  }\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityRef1\r\n"
        + "{\r\n"
        + "  +id: String,\r\n"
        + "  attr1\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityRef2\r\n"
        + "{\r\n"
        + "  id: String,\r\n"
        + "  attr1\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityRef3\r\n"
        + "{\r\n"
        + "  +id: String,\r\n"
        + "  attr1\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityRef4\r\n"
        + "{\r\n"
        + "  +id: String,\r\n"
        + "  attr1\r\n"
        + "}\r\n"
        + "root entity EntityRef5\r\n"
        + "{\r\n"
        + "  +id: String,\r\n"
        + "  attr1\r\n"
        + "}\r\n"
        + "\r\n"
        + "root entity EntityMorphRef1\r\n"
        + "{\r\n"
        + "  +id: Identifier,\r\n"
        + "  aggrEntity1: aggr<EntityRef1>&\r\n"
        + "}\r\n"
        + "\r\n"
        + "root entity EntityMorphRef2\r\n"
        + "{\r\n"
        + "  common\r\n"
        + "  {\r\n"
        + "    +id: Identifier,\r\n"
        + "    ref1: ref<EntityDummy as Identifier>&\r\n"
        + "  }\r\n"
        + "  variation 1\r\n"
        + "  {\r\n"
        + "    aggrEntity2: aggr<EntityRef2>&\r\n"
        + "  }\r\n"
        + "  variation 2\r\n"
        + "  {\r\n"
        + "    aggrEntity3: aggr<EntityRef3>+\r\n"
        + "  }\r\n"
        + "}\r\n"
        + "\r\n"
        + "root entity EntityMorphRef3\r\n"
        + "{\r\n"
        + "  common\r\n"
        + "  {\r\n"
        + "    +id: Identifier\r\n"
        + "  }\r\n"
        + "  variation 1\r\n"
        + "  {\r\n"
        + "    aggrEntity4: aggr<EntityRef4>&,\r\n"
        + "    attr1\r\n"
        + "  }\r\n"
        + "  variation 2\r\n"
        + "  {\r\n"
        + "    ref4: ref<EntityRef4 as String>&\r\n"
        + "  }\r\n"
        + "  variation 3\r\n"
        + "  {\r\n"
        + "    attr3\r\n"
        + "  }\r\n"
        + "}\r\n", athenaIO.serialize(schema));
  }

  @Test
  void testReferenceOperations_Script()
  {
    OrionOperations orion = orionIO.load(testPath_2);
    AthenaSchema schema = new Orion2Athena().m2m(orion).get(0);

    assertEquals("Schema ScriptReference_Ops:1\r\n"
        + "\r\n"
        + "root entity EntityDummy\r\n"
        + "{\r\n"
        + "  +id: String\r\n"
        + "}\r\n"
        + "\r\n"
        + "root entity EntityRefs\r\n"
        + "{\r\n"
        + "  +id: Identifier,\r\n"
        + "  ref1: ref<EntityDummy as Boolean>&,\r\n"
        + "  ref2: ref<EntityDummy as Boolean>+,\r\n"
        + "  ref3: ref<EntityDummy as Number>&,\r\n"
        + "  ref4: ref<EntityDummy as Number>+,\r\n"
        + "  ref5: ref<EntityDummy as String>&,\r\n"
        + "  ref6: ref<EntityDummy as String>+,\r\n"
        + "  ref7: ref<EntityDummy as String>+,\r\n"
        + "  ref8: ref<EntityDummy as String>&,\r\n"
        + "  ref9: ref<EntityDummy as Number>+,\r\n"
        + "  ref10: ref<EntityDummy as Number>&\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityRef1\r\n"
        + "{\r\n"
        + "  +id: String,\r\n"
        + "  value1: String,\r\n"
        + "  value2: String\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityRef2\r\n"
        + "{\r\n"
        + "  id: String,\r\n"
        + "  value3: String,\r\n"
        + "  value4: String\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityRef3\r\n"
        + "{\r\n"
        + "  +id: String,\r\n"
        + "  value5: String,\r\n"
        + "  value6: String\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityRef4\r\n"
        + "{\r\n"
        + "  +id: String,\r\n"
        + "  value7: String,\r\n"
        + "  value8: String\r\n"
        + "}\r\n"
        + "\r\n"
        + "entity EntityRef5\r\n"
        + "{\r\n"
        + "  id: String,\r\n"
        + "  value9: String,\r\n"
        + "  value10: String\r\n"
        + "}\r\n"
        + "\r\n"
        + "root entity EntityMorphRef\r\n"
        + "{\r\n"
        + "  +id,\r\n"
        + "  aggrEntity1: aggr<EntityRef1>&,\r\n"
        + "  aggrEntity2: aggr<EntityRef2>&,\r\n"
        + "  aggrEntity3: aggr<EntityRef3>&,\r\n"
        + "  aggrEntity4: aggr<EntityRef4>+,\r\n"
        + "  aggrEntity5: aggr<EntityRef5>+\r\n"
        + "}\r\n", athenaIO.serialize(schema));
  }
}
