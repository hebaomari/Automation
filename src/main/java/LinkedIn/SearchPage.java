package LinkedIn;

import java.io.IOException;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage {

	WriteToFile write;

	public SearchPage(WebDriver driver) {
		super(driver);
		write = new WriteToFile();
	}

	public void searchforPeople(String name, String type) throws InterruptedException {
		BasePage.setSearchText(Locators.searchBar, name);
		Thread.sleep(3000);
		WebElement ul = BasePage.findElementByxpath(Locators.searchFiltersBar);
		List<WebElement> options = ul.findElements(Locators.searchFiltersOption);
		for (WebElement option : options) {
			if (option.getText().equals(type)) {
				System.out.print(option);
				option.click(); // click the desired option
				break;
			}
		}
	}

	public void getPeopleDetails() throws InterruptedException, InvalidFormatException, IOException {
		int count = 1;
		int desiredNumberOfElements = 5;
		Thread.sleep(3000);
		WebElement resulstList = BasePage.findElementByxpath(Locators.resultsList);
		List<WebElement> elements = resulstList.findElements(By.tagName("li"));
		for (WebElement element : elements) {
			if (count <= desiredNumberOfElements) {
				String name = element.findElement(Locators.profileName).getText();
				String link = element.findElement(Locators.profileLink).getAttribute("href");
				String position = element.findElement(Locators.position).getText();
				String location = element.findElement(Locators.location).getText();
				// write on the results file
				write.writeCsv(count, 0, name, PropertiesClass.getPropertyValue("searchResult"));
				write.writeCsv(count, 1, link, PropertiesClass.getPropertyValue("searchResult"));
				write.writeCsv(count, 2, position, PropertiesClass.getPropertyValue("searchResult"));
				write.writeCsv(count, 3, location, PropertiesClass.getPropertyValue("searchResult"));
				// write on separated file to compare
				write.writeCsv(count, 0, link, ".\\recourses\\Lists.csv");

				count++;
			}
		}
	}

	public boolean equals(List<String> list1, List<String> list2) {
		int size = list1.size();
		boolean Flag = true;
		for (int i = 0; i < size; i++) {
			if (!list1.get(i).equals(list2.get(i))) {
				Flag = false;
				System.out.print("The lists are not equal in index: " + i + "\n");

			}
		}
		return Flag;
	}
}
