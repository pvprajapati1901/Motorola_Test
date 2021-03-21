package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//rahulonlinetutor@gmail.com
public class PageAlert {


	public WebDriver driver;

	By alertButton = By.id("timerAlertButton");



	public PageAlert(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getAlertButton() {
		return driver.findElement(alertButton);
	}

}