package neoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;



public class NeoStoxHomePage
{
	@FindBy(xpath = "(//span[text()='×'])[19]") private WebElement close;
	@FindBy(xpath = "(//a[@class='neobutton'])[25]")private WebElement close2;
	@FindBy(id="lbl_username")private WebElement userName;
	@FindBy(id="lbl_curbalancetop") private WebElement accBalance;
	@FindBy(xpath="//span[text()='Logout']") private WebElement logout;
	
	
	public NeoStoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
    public void handlePopUp(WebDriver driver)
    {   
    	if(close.isDisplayed())
    	{
    	UtilityNew.wait(driver, 1000);
    	close.click();
    	Reporter.log("Clicking on close Button", true);
    	
    	UtilityNew.wait(driver, 1000);
    	close2.click();
    	Reporter.log("Clicking on close Button", true);
        }
    	
    	else
    	{
    		Reporter.log("There is no Popup", true);
    	}
    }
    
    public String getActualUserName(WebDriver driver)
    {
    	UtilityNew.wait(driver, 1000);
    	String actualUserName = userName.getText();
    	Reporter.log("Getting actual user name", true);
    	String realUserName = actualUserName.substring(3);
    	Reporter.log("Actual User Name is "+realUserName, true);
		return actualUserName;
    }
    
    public String getAccBalance(WebDriver driver)
    {
    	UtilityNew.wait(driver, 1000);
		String getAccBalance = accBalance.getText();
    	Reporter.log("Getting acc balance", true);
    	Reporter.log("Account Balance is "+getAccBalance, true);
    	return getAccBalance;
    }
    
    public void logOut(WebDriver driver)
    {
    	UtilityNew.wait(driver, 1000);
    	userName.click();
    	UtilityNew.wait(driver, 1000);
        logout.click();
        Reporter.log("Logging Out", true);
    }
    
}
