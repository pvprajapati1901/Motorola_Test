package ADemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.PageDatePicker;
import resources.base;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestCase6 extends base {

    public static Logger log = LogManager.getLogger(base.class.getName());
    @BeforeTest
    public void intializeDriver() throws IOException {
        driver=initializeDriver();
    }
    @Test
    public void datePicker(){
        PageDatePicker dp= new PageDatePicker(driver);
        driver.get(prop.getProperty("datePickerURL"));
        dp.getDatePicker().click();
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat simpleformat=new SimpleDateFormat("dd/MM/yyyy");
        //System.out.println(simpleformat.format(cal.getTime()));
        String day=new SimpleDateFormat("dd").format(cal.getTime());
        int mth=Integer.parseInt(new SimpleDateFormat("MM").format(cal.getTime()));
        //int mth=12;
        int year=Integer.parseInt(new SimpleDateFormat("yyyy").format(cal.getTime()));
        //System.out.println(mth +"||"+year );
        int newyear=year+1;
        Select mnt=new Select(dp.getMonth());
        Select yr=new Select(dp.getYear());
        if(mth<12){
            dp.getMonth().click();
            dp.getMonth().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

        }else{
            mnt.selectByVisibleText("January");
            dp.getYear().click();
            dp.getYear().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        }
        int count=dp.getdates().size();
        for(int i=0;i<count;i++)
        {
            String text=dp.getdates().get(i).getText();
            if(text.equalsIgnoreCase(day)){
                dp.getdates().get(i).click();
                break;
            }
        }
        log.info("Test passed -Validate user can select future date.");
    }
    @AfterTest
    public void teardown(){
       driver.close();
    }
}
