package neoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;



public class NeoStoxPasswordPage 
{
	@FindBy(xpath = "//input[@type='password']") private WebElement passwordField;
	@FindBy(xpath = "//a[text()='Submit']") private WebElement submitButton;
	
	public NeoStoxPasswordPage (WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}
	
	public void enterPassword(WebDriver driver,String pass)
	{
		UtilityNew.wait(driver, 1000);
		passwordField.sendKeys(pass);
		Reporter.log("Entering Password", true);
	}
	
	public void clickOnSubmitButton(WebDriver driver)
	{
		UtilityNew.wait(driver, 1000);
		submitButton.click();
		Reporter.log("Clicking on submit Button", true);
	}

}
