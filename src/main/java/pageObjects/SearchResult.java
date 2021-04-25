package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResult {

	public WebDriver driver;

	private By searchResult=By.cssSelector("a[class='a-link-normal a-text-normal']");

	public SearchResult(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void clickOnSearchResult() {
		driver.findElement(searchResult).click();
	}
}
