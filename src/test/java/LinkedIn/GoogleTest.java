package LinkedIn;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest{
	
	public static WebDriver googledriver;
	public static ReadfromFile readfromFile;
	public static GoogleSearchPage google;

	public GoogleTest() {
		readfromFile = new ReadfromFile();
		google = new GoogleSearchPage();
	}

	@Test (dataProvider = "Google")

	public static void Open_Google_and_Search(String Name,String Type) throws IOException, InvalidFormatException, InterruptedException {
		System.setProperty(PropertiesClass.getPropertyValue("chromeBrowser"),PropertiesClass.getPropertyValue("chromePath"));
		googledriver = new ChromeDriver();
		googledriver.get(PropertiesClass.getPropertyValue("googleUrl"));
		WebElement element = googledriver.findElement(Locators.googleSearchBar);
		element.sendKeys(Name+" "+Type+" "+"Linkedin.com");
        element.sendKeys(Keys.ENTER);
        google.getSearchResults(googledriver); 
	}

	@DataProvider(name = "Google")
	public String[][] searchbyGoogle() throws InvalidFormatException, IOException {
		return readfromFile.readCsv(".\\recourses\\searchData.csv");
	}

}
