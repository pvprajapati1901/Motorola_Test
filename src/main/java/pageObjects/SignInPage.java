package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

    public WebDriver driver;
    private By createAccount = By.cssSelector("a[id*='createAccount']");

    public SignInPage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
    }

    public void clickOnCreateAccount() {
        driver.findElement(createAccount).click();
    }


}
