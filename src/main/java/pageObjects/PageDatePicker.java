package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

//rahulonlinetutor@gmail.com
public class PageDatePicker {


	public WebDriver driver;

	//By datePicker = By.id("datePickerMonthYearInput");
	By datePicker = By.cssSelector("div[class='react-datepicker__input-container']");
	By month = By.cssSelector("select.react-datepicker__month-select");
	By year=By.cssSelector("select.react-datepicker__year-select");
	By date=By.cssSelector("div[class*='react-datepicker__day']");

	public PageDatePicker(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getDatePicker() {
		return driver.findElement(datePicker);
	}
	public WebElement getMonth() {
		return driver.findElement(month);
	}
	public WebElement getYear() {
		return driver.findElement(year);
	}
	public List<WebElement> getdates(){
		return driver.findElements(date);
	}
}