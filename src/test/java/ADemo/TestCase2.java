package ADemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.PageAlert;
import resources.base;

import java.io.IOException;

public class TestCase2 extends base {

    public static Logger log = LogManager.getLogger(base.class.getName());
    @BeforeTest
    public void intializeDriver() throws IOException {

        driver=initializeDriver();
    }
    @Test
    public void closeAlert() throws IOException, InterruptedException {
        driver.get(prop.getProperty("alertURL"));
        PageAlert alert= new PageAlert(driver);
        alert.getAlertButton().click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        log.info("Testcase passed -Validating functionality of Alert popup.");
    }

    @AfterTest
    public void teardown(){
        driver.close();
    }
}
