package ADemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.PageTooltips;
import resources.base;

import java.io.IOException;

public class TestCase3 extends base {

    public static Logger log = LogManager.getLogger(base.class.getName());
    @BeforeTest
    public void intializeDriver() throws IOException {

        driver=initializeDriver();
    }

    @Test
    public void HoverButton() throws InterruptedException {

        driver.get(prop.getProperty("hoverURL"));
        PageTooltips tl= new PageTooltips(driver);
        Actions act=new Actions(driver);
        act.moveToElement(tl.getHoverButton()).build().perform();
        act.moveToElement(tl.getHoverField()).build().perform();
        log.info("Test passed -Validating functionality of hover over on button and input field.");
    }

    @AfterTest
    public void teardown(){
        driver.close();
    }
}
