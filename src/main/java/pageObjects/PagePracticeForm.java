package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

//rahulonlinetutor@gmail.com
public class PagePracticeForm {


	public WebDriver driver;

	By firstName = By.id("firstName");
	By lastName = By.id("lastName");
	By email= By.id("userEmail");
	By gender= By.cssSelector("label[for='gender-radio-1']");
	By mobile= By.cssSelector("input[placeholder='Mobile Number']");
	By dob=By.cssSelector("input#dateOfBirthInput");
	By month=By.cssSelector("select[class*='month-select']");
	By year=By.cssSelector("select[class*='year-select']");
	//By today=By.cssSelector("div[class*='react-datepicker__day--today']");
	By monthdates=By.xpath("//div[contains(@class,'react-datepicker')]");
	By subject= By.cssSelector("input#subjectsInput");
	By sportHobby= By.cssSelector("label[for='hobbies-checkbox-1']");
	By readingHobby= By.cssSelector("label[for='hobbies-checkbox-2']");
	By musicHobby= By.cssSelector("label[for='hobbies-checkbox-3']");
	By uploadPicture=By.cssSelector("label[for='uploadPicture");
	By currentAddress= By.cssSelector("textarea[placeholder='Current Address']");
	By state= By.cssSelector("input#react-select-3-input");
	By city= By.cssSelector("input#react-select-4-input");
	By submit= By.xpath("//button[@id='submit']");
	By submitText=By.id("example-modal-sizes-title-lg");
	By regForm=By.xpath("//div[@class='practice-form-wrapper']/h5");

	public PagePracticeForm(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getFirstName() {
		return driver.findElement(firstName);
	}
	public WebElement getLastName() {
		return driver.findElement(lastName);
	}
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getGender() {
		return driver.findElement(gender);
	}
	public WebElement getMobile() {
		return driver.findElement(mobile);
	}
	public WebElement getDOB() {
		return driver.findElement(dob);
	}
	public WebElement getMonth(){
		return driver.findElement(month);
	}
	public WebElement getYear(){
		return driver.findElement(year);
	}
	public List<WebElement> getMonthDates(){
		return driver.findElements(monthdates);
	}
	public WebElement getSubject() {
		return driver.findElement(subject);
	}
	public WebElement getSportsHobby() {
		return driver.findElement(sportHobby);
	}
	public WebElement getReadingHobby() {
		return driver.findElement(readingHobby);
	}
	public WebElement getMusicHobby() {
		return driver.findElement(musicHobby);
	}
	public WebElement getuploadPicture() {
		return driver.findElement(uploadPicture);
	}
	public WebElement getCurrentAddress() {
		return driver.findElement(currentAddress);
	}
	public WebElement getState() {
		return driver.findElement(state);
	}
	public WebElement getCity() {
		return driver.findElement(city);
	}
	public WebElement getSubmitButton() {
		return driver.findElement(submit);
	}
	public String getSubmitText(){
		return driver.findElement(submitText).getText();
	}
	public String getRegFormText(){
		return driver.findElement(regForm).getText();
	}
}