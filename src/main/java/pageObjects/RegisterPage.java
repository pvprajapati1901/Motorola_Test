package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    public WebDriver driver;
    private By name = By.id("ap_customer_name");
    private By email = By.id("ap_email");
    private By password = By.id("ap_password");
    private By passwordCheck = By.id("ap_password_check");
    private By submit=By.xpath("//input[@type='submit']");

    public RegisterPage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
    }

    public void enterName(String arg1) {
        driver.findElement(name).sendKeys(arg1);
    }
    public void enterEmail(String arg1) {
        driver.findElement(email).sendKeys(arg1);
    }
    public void enterPassword(String arg1) {
        driver.findElement(password).sendKeys(arg1);
    }
    public void enterPasswordCheck(String arg1) {
        driver.findElement(passwordCheck).sendKeys(arg1);
    }
    public void clickOnSubmit() {
        driver.findElement(submit).click();
    }

}
