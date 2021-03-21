package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//rahulonlinetutor@gmail.com
public class PageModalDialogs {


	public WebDriver driver;

	By smallModelButton = By.id("showSmallModal");
	By closeSmallModel = By.id("closeSmallModal");


	public PageModalDialogs(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getsmallModelButton() {
		return driver.findElement(smallModelButton);
	}
	public WebElement getCloseSmallModel() {
		return driver.findElement(closeSmallModel);
	}
}