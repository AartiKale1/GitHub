package neoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;



public class NeoStoxLoginPage 
{
	//1.Data member should be declared globally with access level private using @findBy Annotation
	
		@FindBy(xpath = "(//input[@type='number'])[1]")private WebElement mobileNumField;
		@FindBy(xpath="(//a[text()='Sign In'])[2]")private WebElement signInButton;
		
	//2.Initialize within a constructor with access level public using pagefactory 
		
			public NeoStoxLoginPage (WebDriver driver)
			{
			PageFactory.initElements(driver, this);	
			}
	
	//3.Utilize within a method with access level public
			
			public void sendMobileNum(WebDriver driver, String mobNum)
			{
                UtilityNew.wait(driver, 1000);
				mobileNumField.sendKeys(mobNum);
				Reporter.log("Entering mobile", true);
			}
			
			public void clickOnSignInButton(WebDriver driver)
			{
				UtilityNew.wait(driver, 1000);
				signInButton.click();
				Reporter.log("Clicking on Sign in Button ", true);
			}
			
}
