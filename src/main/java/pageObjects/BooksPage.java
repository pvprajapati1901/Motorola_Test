package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BooksPage {


	public WebDriver driver;

	private By searchBox= By.id("twotabsearchtextbox");

	public BooksPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void clickOnSearchBox(String arg1) {
		driver.findElement(searchBox).sendKeys(arg1);
		driver.findElement(searchBox).sendKeys(Keys.ENTER);
	}

}
