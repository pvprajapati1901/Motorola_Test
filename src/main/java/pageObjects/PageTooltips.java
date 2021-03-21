package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//rahulonlinetutor@gmail.com
public class PageTooltips {


	public WebDriver driver;

	By hoverButton = By.id("toolTipButton");
	By hoverField = By.id("toolTipTextField");


	public PageTooltips(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getHoverButton() {
		return driver.findElement(hoverButton);
	}
	public WebElement getHoverField() {
		return driver.findElement(hoverField);
	}
}