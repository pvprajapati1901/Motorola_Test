package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//rahulonlinetutor@gmail.com
public class PageDragandDrop {


	public WebDriver driver;

	By dragItem = By.id("draggable");
	By dropField = By.id("droppable");


	public PageDragandDrop(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getDragItem() {
		return driver.findElement(dragItem);
	}
	public WebElement getDropField() {
		return driver.findElement(dropField);
	}
}