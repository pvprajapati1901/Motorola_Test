package ADemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.PagePracticeForm;
import resources.base;

import java.io.IOException;

public class TestCase1 extends base {

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
        pf.getLastName().sendKeys("Prajapati");
        pf.getEmail().sendKeys("pvpraj1901@gmail.com");
        pf.getGender().click();
        pf.getMobile().sendKeys("01234567891");
        pf.getDOB().click();
        Select mth=new Select(pf.getMonth());
        mth.selectByVisibleText("August");
        Select yr=new Select(pf.getYear());
        yr.selectByVisibleText("2000");
        int count=pf.getMonthDates().size();
        for(int i=0;i<count;i++)
        {
            String text=pf.getMonthDates().get(i).getText();
            if(text.equalsIgnoreCase("19")){
                pf.getMonthDates().get(i).click();
                break;
            }
        }
        pf.getSubject().sendKeys("Accounting");
        pf.getSubject().sendKeys(Keys.ENTER);
        pf.getSubject().sendKeys("Maths");
        pf.getSubject().sendKeys(Keys.ENTER , Keys.TAB);
        pf.getSportsHobby().click();
        pf.getReadingHobby().click();
        pf.getMusicHobby().click();
        pf.getuploadPicture().click();
        Thread.sleep(3000);
        Runtime.getRuntime().exec("C:\\work\\PictureUpload\\pictureUpload.exe");
        pf.getCurrentAddress().sendKeys("Harrow London UK");
        pf.getState().sendKeys("Rajasthan");
        pf.getState().sendKeys(Keys.ENTER,Keys.TAB);
        WebElement city=wait.until(ExpectedConditions.visibilityOf(pf.getCity()));
        city.sendKeys("Jaipur");
        city.sendKeys(Keys.ENTER, Keys.TAB);
        pf.getSubmitButton().click();
        log.info("Testcase pass - Validating Student registration.");
        Assert.assertEquals(pf.getSubmitText(),"Thanks for submitting the form");

    }

    @AfterTest
    public void teardown(){
        driver.close();
    }

}
