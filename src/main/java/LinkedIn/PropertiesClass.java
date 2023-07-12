package LinkedIn;

import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import org.testng.annotations.BeforeClass;

public class PropertiesClass {

	public static String propertyValue = "";

	@BeforeClass
	public static String getPropertyValue(String propertyKey) throws IOException {
		FileReader reader = new FileReader(".\\recourses\\config.properties");
		Properties propertyObject = new Properties();
		propertyObject.load(reader);
		propertyValue = propertyObject.getProperty(propertyKey);

		return propertyValue;
	}
}