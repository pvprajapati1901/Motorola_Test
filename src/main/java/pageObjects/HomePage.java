package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {


	public WebDriver driver;

	private By alertCookie=By.cssSelector("input[id='sp-cc-accept']");
	private By books= By.cssSelector("a[href*='books-used-books']");
	private By selectDropdown= By.id("searchDropdownBox");

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void clickOnAlert() {
		driver.findElement(alertCookie).click();
	}
	public void clickOnBooks() {
		driver.findElement(books).click();
	}
	public void dropDownBook() {
		Select bk= new Select(driver.findElement(selectDropdown));
		bk.selectByVisibleText("Books");
	}

}
