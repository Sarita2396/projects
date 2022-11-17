package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.Dashboard;
import Pages.LoginPage;

public class DashboardTests extends BaseClass{
	public Dashboard dash;
	public LoginPage login;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		login = new LoginPage();
		dash = new Dashboard();
		login.loginVerify();
	}
	
	@Test (priority = 2)
	public void verifyUsernameTest() throws InterruptedException
	{
		  String user = dash.verifyUsername();
		  Assert.assertEquals("Sarita Dilip Machutre", user);
	}
	
	@AfterTest
	public void exit()
	{
		driver.close();
	}
	
	
}
