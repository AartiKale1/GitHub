package neoStoxTest;

import org.testng.annotations.Test;

import neoStoxBase.BaseNew;
import neoStoxPOM.NeoStoxHomePage;
import neoStoxPOM.NeoStoxLoginPage;
import neoStoxPOM.NeoStoxPasswordPage;
import neoStoxPOM.NeoStoxSignInPage;
import neoStoxUtility.UtilityNew;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

@Listeners(neoStoxBase.Listener.class)
public class ValidateNeoStoxAccBalance2 extends BaseNew
{
  NeoStoxLoginPage login;
  NeoStoxPasswordPage password;
  NeoStoxHomePage home;
  NeoStoxSignInPage signIn;

  @BeforeClass
  public void launchNeoBrowser() throws IOException 
  {
	  launchBrowser();
	  login=new NeoStoxLoginPage(driver);
	  password= new NeoStoxPasswordPage(driver);
	  home= new NeoStoxHomePage(driver);
	  signIn= new NeoStoxSignInPage(driver);
  }

  @BeforeMethod
  public void loginNeoStox() throws InterruptedException, EncryptedDocumentException, IOException 
  {
	  signIn.clickOnSignInButton(driver);
	  Thread.sleep(1000);
	  login.sendMobileNum(driver, UtilityNew.readDataFromPropertyFile("MobileNum") );
	  UtilityNew.wait(driver, 2000);
	  login.clickOnSignInButton(driver);
	  UtilityNew.wait(driver, 1000);
	  password.enterPassword(driver, UtilityNew.readDataFromPropertyFile("Password"));
	  Thread.sleep(1000);
	  password.clickOnSubmitButton(driver);
	  Thread.sleep(1000);
	  home.handlePopUp(driver);
  }
  
  @Test
  public void validateAccBalance() throws IOException
  {
	  Assert.assertNotNull(home.getAccBalance(driver),"TC is failed unable to fetch account balance");
	  Assert.fail();
  }

  @Test(priority = -1)
  public void validateUserID() throws EncryptedDocumentException, IOException
  {
	 
	  Assert.assertEquals(home.getActualUserName(driver), UtilityNew.readDataFromPropertyFile("UserName"),"Tc is failed Actual and expected user name are not matching");
	  
  }

  @AfterMethod
  public void logOut()
  {
	  UtilityNew.wait(driver, 1000);
	  home.logOut(driver);
  }
  @AfterClass
  public void closeBrowser() 
  {
	  UtilityNew.wait(driver, 1000);
	  driver.close();
  }

}
