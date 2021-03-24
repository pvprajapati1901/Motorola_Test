package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.PagePracticeForm;
import resources.base;

@RunWith(Cucumber.class)
public class StepDefinition extends base {

   @Given("^User is on registration page$")
    public void user_is_on_registration_page() throws Throwable {
        driver=initializeDriver();
        driver.get(prop.getProperty("practiceFormURL"));
    }

    @When("^User input all valid details$")
    public void user_input_all_valid_details() throws Throwable {
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
        WebDriverWait wait= new WebDriverWait(driver, 10);
        WebElement city=wait.until(ExpectedConditions.visibilityOf(pf.getCity()));
        city.sendKeys("Jaipur");
        city.sendKeys(Keys.ENTER, Keys.TAB);
        pf.getSubmitButton().click();

    }
    @Then("^User should get valid submition message$")
    public void user_should_get_valid_submition_message() throws Throwable {
        PagePracticeForm pf=new PagePracticeForm(driver);
        Assert.assertEquals(pf.getSubmitText(),"Thanks for submitting the form");
        driver.close();
   }

}