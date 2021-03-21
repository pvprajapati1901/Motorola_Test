package ADemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.PageModalDialogs;
import resources.base;

import java.io.IOException;

public class TestCase5 extends base{

    public static Logger log = LogManager.getLogger(base.class.getName());
    @BeforeTest
    public void intializeDriver() throws IOException {

        driver=initializeDriver();
    }

    @Test
    public void modalDialogs() throws InterruptedException {

        driver.get(prop.getProperty("modelDialogsURL"));
        PageModalDialogs md= new PageModalDialogs(driver);
        md.getsmallModelButton().click();
        md.getCloseSmallModel().click();
        log.info("Test passed -Validate user can selct and close small modal.");
    }

    @AfterTest
    public void teardown(){
        driver.close();
    }
}