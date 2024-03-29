package es.um.uschema.subtypes.util.types.changes;

import es.um.uschema.USchema.Feature;
import es.um.uschema.USchema.StructuralVariation;

public class SchemaRemove extends AbstractSchemaChange
{
  private Feature featRemove;

  private StructuralVariation variation;

  private long timestamp;

  public SchemaRemove(Feature featRemove, StructuralVariation variation)
  {
    this.featRemove = featRemove;
    this.variation = variation;
    this.timestamp = variation.getFirstTimestamp();
  }

  public Feature getRemovedFeature()
  {
    return featRemove;
  }

  public StructuralVariation getLastVariation()
  {
    return variation;
  }

  public long getLastTimestamp()
  {
    return timestamp;
  }
}
