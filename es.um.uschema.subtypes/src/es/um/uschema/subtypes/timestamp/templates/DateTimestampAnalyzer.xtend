package es.um.uschema.subtypes.timestamp.templates

class DateTimestampAnalyzer extends TimestampAnalyzer
{
  String[] attrNames;

  new()
  {
    this(#["timestamp"]);
  }

  new(String attrName)
  {
    this(#[attrName]);
  }

  new(String[] attrNames)
  {
    this.attrNames = attrNames;
  }

  override toString()
  '''
  // This Date TimestampAnalyzer looks for an attribute with a given name, or an array of attributes by name, finds the first occurrence and
  // and translates it to nanoseconds according to the given format. Expected format: yyyy-MM-ddTHH:mm:ss
  var TimestampAnalyzer =
  {
    _attrName: [«attrNames.map[attr | "\"" + attr + "\""].join(", ")»],
    _value: "",

    getAttrValue: function()
    {
      if (this._value === "")
        return 0;
      else
        return this._value;
    },
    analyzeAttribute: function(attrName, attrValue)
    {
      if (this._attrName.indexOf(attrName) > -1 && this._value === "")
        this._value = Date.parse(attrValue);
    }
  };
  '''
}
