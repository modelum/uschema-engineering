package es.um.uschema.subtypes.util.configuration.defaults;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DefaultTimestampFileGenerationConfig
{
  private static final String PROPERTIES_FILE_NAME = "config.properties";
  private static Properties properties = new Properties();

  static
  {
    InputStream inputStream = DefaultTimestampFileGenerationConfig.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);

    try
    {
      properties.load(inputStream);
    } catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public static Properties getDefaultConfig()
  {
    return properties;
  }
}
