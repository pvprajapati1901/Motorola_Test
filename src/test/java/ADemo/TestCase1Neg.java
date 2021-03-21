package ADemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.PagePracticeForm;
import resources.base;

import java.io.IOException;

public class TestCase1Neg extends base {

    public static Logger log = LogManager.getLogger(base.class.getName());
    @BeforeTest
    public void intializeDriver() throws IOException {

        driver=initializeDriver();
    }

    @Test
    public void practiceForm() throws IOException, InterruptedException {

        WebDriverWait wait= new WebDriverWait(driver, 10);
        driver.get(prop.getProperty("practiceFormURL"));
        PagePracticeForm pf=new PagePracticeForm(driver);
        pf.getFirstName().sendKeys("Pankaj");
        pf.getMobile().sendKeys("01234567891");
        pf.getSubject().sendKeys("Accounting");
        pf.getSubject().sendKeys(Keys.ENTER);
        pf.getCurrentAddress().sendKeys("Harrow London UK");
        pf.getState().sendKeys("Rajasthan");
        pf.getState().sendKeys(Keys.ENTER,Keys.TAB);
        WebElement city=wait.until(ExpectedConditions.visibilityOf(pf.getCity()));
        city.sendKeys("Jaipur");
        city.sendKeys(Keys.ENTER, Keys.TAB);
        pf.getSubmitButton().click();
        Assert.assertEquals(pf.getRegFormText(), "Student Registration Form");
        log.info("Testcase pass -Verify validation message for incomplete Student registration.");
    }
    @AfterTest
    public void teardown(){
        driver.close();
    }
}
