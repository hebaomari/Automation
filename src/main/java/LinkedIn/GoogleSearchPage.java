package LinkedIn;

import java.io.IOException;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

	WriteToFile write;
	ReadfromFile read;

	public GoogleSearchPage() {

		write = new WriteToFile();
	}

	public void getSearchResults(WebDriver driver) throws InterruptedException, InvalidFormatException, IOException {
		int count = 1;
		int desiredNumberOfElements = 5;
		String link;

		Thread.sleep(1000);
		WebElement resulstList = driver.findElement(Locators.googleList);
		// System.out.print(resulstList.getText() + "\n");
		List<WebElement> elements = resulstList.findElements(Locators.parentList);
		// System.out.print("Size = " + elements.size());
		for (WebElement element : elements) {
			if (count <= desiredNumberOfElements) {

				link = element.findElement(By.tagName("a")).getAttribute("href");

				System.out.print(link + "\n\n");
				// write on the file
				write.writeCsv(count, 1, link, ".\\recourses\\Lists.csv");
				count++;
			}
		}
	}
}
