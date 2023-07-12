package LinkedIn;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;

public class LoginTest extends BaseTest {

	static LoginPage loginPage;

	@BeforeClass
	public void setupClass() {

		loginPage = new LoginPage(basePageDriver);
	}

	@Test
	public static void Login_with_Valid_Phone_Number_and_Password() throws IOException {

		loginPage.loginWithUsernameAndPassword(PropertiesClass.getPropertyValue("validUsername"),
				PropertiesClass.getPropertyValue("validPassword"));
		Assert.assertEquals(BasePage.findActualResult(Locators.actualResult), "Messaging");
	}
}