package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
public WebDriver driver;
public Properties prop;
public String projectPath= System.getProperty("user.dir");
public WebDriver initializeDriver() throws IOException
{
	prop= new Properties();
	FileInputStream fis=new FileInputStream(projectPath+"/src/main/java/resources/data.properties");
	prop.load(fis);
	//mvn test -Dbrowser=chrome

	//String browserName=System.getProperty("browser");
	String browserName=prop.getProperty("browser");
	System.out.println(browserName);

if(browserName.equals("chrome"))
{
	System.setProperty("webdriver.chrome.driver",projectPath+"/src/main/java/resources/driversFolder/chromedriver.exe");
	driver= new ChromeDriver();
}
else if (browserName.equals("firefox"))
{
	System.setProperty("webdriver.gecko.driver",projectPath+"/src/main/java/resources/driversFolder/geckodriver.exe");
	driver= new FirefoxDriver();

}
else if (browserName.equals("ie"))
{
	System.setProperty("webdriver.ie.driver",projectPath+"/src/main/java/resources/driversFolder/IEDriverServer.exe");
	driver= new InternetExplorerDriver();
}

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
return driver;


}

public void getScreenshot(String result) throws IOException
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
	
}


}
