package LinkedIn;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

	public static WebDriver basePageDriver;

	@BeforeClass
	@Parameters({ "browser" })
	public void Open_Browser(String browser) throws IOException {
		if (browser.equals(PropertiesClass.getPropertyValue("chrome"))) {
			System.setProperty(PropertiesClass.getPropertyValue("chromeBrowser"),PropertiesClass.getPropertyValue("chromePath"));
			basePageDriver = new ChromeDriver();
			basePageDriver.get(PropertiesClass.getPropertyValue("webUrl"));
		} else if (browser.equals(PropertiesClass.getPropertyValue("firefox"))) {
			System.setProperty(PropertiesClass.getPropertyValue("geckoBrowser"),PropertiesClass.getPropertyValue("geckoPath"));
			basePageDriver = new FirefoxDriver();
			basePageDriver.get(PropertiesClass.getPropertyValue("webUrl"));
		}
	}
}