package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.LoginPage;

public class LoginTests extends BaseClass{
	
	public LoginPage login;
	@BeforeMethod (groups= {"Sanity", "Regresstion"})
	public void setup() throws IOException
	{
		initialization();
		login = new LoginPage();
	}
	
	@Test (priority=1, invocationCount=3)
	
	public void veriftyLogin() throws IOException
	{
		String loggedIn = login.loginVerify();
		Assert.assertEquals("Sarita", loggedIn);
	}
	
	@Test (priority = 8, groups = "Regresstion")
	public void VerityTiltleTest()
	{
		String var = login.verifyTitle();
		Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform", var);
	}
	@Test (priority = -2, groups = "Sanity", invocationCount = 2, timeOut = 10, dependsOnMethods = {"veriftyLogin"})
	public void verifyKiteLogo()
	{
		boolean kiteLogo = login.verifyKiteLogo();
		Assert.assertEquals(kiteLogo, true);
	}
	
	@Test (priority = -3, groups = "Regresstion", dependsOnMethods = {"veriftyLogin"})
	public void verifyZerodhaLogo()
	{
		boolean zerodhaLogo =login.verifyZerodhaLogo();
		Assert.assertEquals(zerodhaLogo, true);
	}
	
	@AfterMethod (groups = {"sanity", "regresstion"})
	public void exit()
	{
		driver.close();
	  }	

	
}
