package LinkedIn;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.Assert;

public class searchTest extends BaseTest {

	static SearchPage searchPage;
	static GoogleSearchPage googleSearch;
	static boolean flag = true;
	static LoginPage loginPage;
	static ReadfromFile readfromFile;
	boolean haveEqualContents;
	List<String> googleLinks = new ArrayList<>();
	List<String> linkedinLinks = new ArrayList<>();

	@BeforeClass
	public void setupClass() throws IOException {
		loginPage = new LoginPage(basePageDriver);
		searchPage = new SearchPage(basePageDriver);
		loginPage.loginWithUsernameAndPassword(PropertiesClass.getPropertyValue("validUsername"),
				PropertiesClass.getPropertyValue("validPassword"));
		readfromFile = new ReadfromFile();
		googleSearch = new GoogleSearchPage();
	}

	@Test(dataProvider = "Data Provider1", priority = 1)
	public void Search_for_People(String Name, String Type)
			throws IOException, InterruptedException, InvalidFormatException {

		searchPage.searchforPeople(Name, Type);
		searchPage.getPeopleDetails();

	}

	@Test(dataProvider = "Data Provider2")
	public void Compare_Links(String linkedin, String google)throws InvalidFormatException, InterruptedException, IOException {
		linkedinLinks.add(linkedin);
		googleLinks.add(google);

		flag = searchPage.equals(linkedinLinks, googleLinks);
		Assert.assertTrue(flag, "The Links are matching");

	}

	@DataProvider(name = "Data Provider1")
	public String[][] searchData() throws InvalidFormatException, IOException {
		return readfromFile.readCsv(".\\recourses\\searchData.csv");
	}

	@DataProvider(name = "Data Provider2")
	public String[][] readLinkedin() throws InvalidFormatException, IOException {
		return readfromFile.readCsv(".\\recourses\\Lists.csv");
	}

}
