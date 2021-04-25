package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import resources.base;

import java.util.List;

public class SearchPage {
    public static Logger log = LogManager.getLogger(base.class.getName());
    public WebDriver driver;
    private By frmt = By.cssSelector("span[id*='FormatsPrompt']");
    private By format = By.id("formats");
    private By edition = By.cssSelector("span.a-size-small.a-color-base");
    private By badgefield = By.xpath("//a[@class='badge-link']");
    private By badge= By.tagName("i");
    private By detailsItem=By.cssSelector("div[id*='detailBullet']");
    private By itemDetail= By.cssSelector("span.a-list-item");
    private By buyButton= By.cssSelector("input#buy-now-button");

    public SearchPage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
    }

    public void clickOnFormats() {
        driver.findElement(frmt).click();
    }

    public void verifykindleEdition() {
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> editions = driver.findElement(format).findElements(edition);
        for (int i = 0; i < editions.size(); i++) {
            String ed = editions.get(i).getText();
            if (ed.contains("Kindle")) {
                softAssert.assertEquals(ed, "Kindle Edition");
                log.info("Kindle Edition available");
                break;
            }
        }
    }

    public void verifyBookSeller() {
        String t = driver.findElement(badgefield).findElement(badge).getText();
        if (t.contains("Best Seller"))
            log.info("Book is a Best Seller.");

        else
            log.info("Book is not a Best Seller.");
    }
    public void verifyBookDetails() {
        int t=driver.findElement(detailsItem).findElements(itemDetail).size();
        for (int i = 0; i < t; i++)
        {
            log.info(driver.findElement(detailsItem).findElements(itemDetail).get(i).getText());
        }
    }
    public void clickOnBuyNow(){
        driver.findElement(buyButton).click();
    }
}
