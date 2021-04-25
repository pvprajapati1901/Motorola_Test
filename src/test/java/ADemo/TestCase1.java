package ADemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
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
        SoftAssert softAssert= new SoftAssert();
        driver.get(prop.getProperty("practiceFormURL"));
        HomePage hp=new HomePage(driver);
        hp.clickOnAlert();
        hp.clickOnBooks();
        BooksPage bk=new BooksPage(driver);
        bk.clickOnSearchBox("Harry Potter and the Philosopher's Stone");
        SearchResult sr=new SearchResult(driver);
        sr.clickOnSearchResult();
        SearchPage sp= new SearchPage(driver);
       /* sp.clickOnFormats();
        sp.verifykindleEdition();
        sp.verifyBookSeller();
        sp.verifyBookDetails(); */
        sp.clickOnBuyNow();
        SignInPage sip=new SignInPage(driver);
        sip.clickOnCreateAccount();
        RegisterPage reg= new RegisterPage(driver);
        reg.enterName("P Prajapati");
        reg.enterEmail("abc@rediffmail.com");
        reg.enterPassword("abcd123");
        reg.enterPasswordCheck("abcd123");
        reg.clickOnSubmit();
        log.info("Testcase pass - Validating End to End scenario.");

    }

    @AfterTest
    public void teardown(){
       //driver.close();
    }

}
