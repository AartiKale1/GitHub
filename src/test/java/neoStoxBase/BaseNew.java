package neoStoxBase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;

public class BaseNew 
{
	protected static WebDriver driver;
	
	public void launchBrowser() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\AARTI\\chromedriver_win32\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(UtilityNew.readDataFromPropertyFile("Url"));
		Reporter.log("Launching Browser", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	}

}
