package LinkedIn;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	static WebDriver classDriver;
	static WebElement webElement;
	static WebDriverWait wait;

	public BasePage(WebDriver driver) {
		classDriver = driver;
		wait = new WebDriverWait(classDriver, 30);
	}

	public static void clickElement(By signIn) {

		classDriver.findElement(signIn).click();
	}

	public static void setFieldText(By username, String username2) {
		try {
			webElement = classDriver.findElement(username);
			webElement.sendKeys(username2);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static String findActualResult(By actualResult) {

		return classDriver.findElement(actualResult).getText();
	}

	public static void setSearchText(By searchKey, String searchValue) {

		webElement = classDriver.findElement(searchKey);
		webElement.sendKeys(searchValue);
		webElement.sendKeys(Keys.RETURN);
	}

	public static WebElement findElementByxpath(By xpath) {
		webElement = classDriver.findElement(xpath);
		return webElement;
	}

}
