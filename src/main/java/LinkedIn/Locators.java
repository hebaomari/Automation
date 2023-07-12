package LinkedIn;

import org.openqa.selenium.By;

public class Locators {

	public static final By username = By.id("username");
	public static final By password = By.id("password");
	public static final By signinButton = By.xpath("//*[@id=\"organic-div\"]/form/div[3]/button");
	public static final By actualResult = By.xpath("//*[@id=\"msg-overlay\"]/div[1]/header/div[2]/button/span/span[1]");
	public static final By searchBar = By.xpath("//*[@id=\"global-nav-typeahead\"]/input");
	public static final By searchFiltersBar = By.xpath("//*[@id=\"search-reusables__filters-bar\"]/ul");
	public static final By searchFiltersOption = By.tagName("li");
	public static final By resultsList = By.cssSelector("ul[class='reusable-search__entity-result-list list-style-none']");
	public static final By profileLink = By.tagName("a");
	public static final By profileName = By.cssSelector("a[class='app-aware-link ']");
	public static final By position = By.cssSelector("div[class='entity-result__primary-subtitle t-14 t-black t-normal']");
	public static final By location = By.cssSelector("div[class='entity-result__secondary-subtitle t-14 t-normal']");
	public static final By googleSearchBar = By.className("gLFyf");
	public static final By googleList =  By.id("search"); 
	public static final By parentList = By.cssSelector("div[class='MjjYud']");
	public static final By linkfromGoogle = By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/a");
}
