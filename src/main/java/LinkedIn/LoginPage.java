package LinkedIn;

import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void loginWithUsernameAndPassword(String username, String password) {

		BasePage.setFieldText(Locators.username, username);
		BasePage.setFieldText(Locators.password, password);
		BasePage.clickElement(Locators.signinButton);
	}
}
