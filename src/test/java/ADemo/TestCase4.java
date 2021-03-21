package ADemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.PageDragandDrop;
import resources.base;

import java.io.IOException;

public class TestCase4 extends base{

    public static Logger log = LogManager.getLogger(base.class.getName());
    @BeforeTest
    public void intializeDriver() throws IOException {

        driver=initializeDriver();
    }

    @Test
    public void hoverButton() throws InterruptedException {

        driver.get(prop.getProperty("dragDropURL"));
        PageDragandDrop pd= new PageDragandDrop(driver);
        Actions act=new Actions(driver);
        act.dragAndDrop(pd.getDragItem(),pd.getDropField()).build().perform();
        log.info("Test passed -Validating functionality of Drag and drop element.");
    }

    @AfterTest
    public void teardown(){
        driver.close();
    }
}