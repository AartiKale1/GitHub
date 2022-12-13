package neoStoxBase;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;

public class Listener extends BaseNew implements ITestListener
{
	public void onTestFailure(ITestResult result) 
	{
		String methodName = result.getName();
		Reporter.log("TC "+methodName+" is failed please try again...", true);
		try {
			UtilityNew.screenshot(driver, methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log("TC "+result.getName()+" is sucess..", true);	
		
	}
  public void onTestSkipped(ITestResult result) 
    {
	  Reporter.log("TC "+result.getName()+" is skipped please check...", true);
	  
	}
}
