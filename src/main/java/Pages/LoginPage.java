package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(xpath="//input[@type = 'text']") private WebElement loginTestBox;
	@FindBy(xpath="//input[@type = 'password']") private WebElement passwordTextBox;
	@FindBy(xpath="//button[@type = 'submit']") private WebElement loginBtn;
	@FindBy(xpath="//input[@id='pin']") private WebElement pinTextBox;
	@FindBy(xpath="//button[@type='submit']") private WebElement continueBtn;
	@FindBy(xpath="//span[@class='nickname']") private WebElement nickName;
	@FindBy(xpath="//img[@alt='Kite']") private WebElement kiteLogo;
	@FindBy(xpath="//img[@alt='Zerodha']") private WebElement zerodhaLogo;
	@FindBy(xpath="") private WebElement var;
	@FindBy(xpath="") private WebElement var1;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String loginVerify() throws IOException
	{                     
		loginTestBox.sendKeys(readPropertyFile("username"));
		passwordTextBox.sendKeys(readPropertyFile("password"));
		loginBtn.click();
		pinTextBox.sendKeys(readPropertyFile("pin"));
		continueBtn.click();
		return nickName.getText();
	}
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyKiteLogo()
	{
		return kiteLogo.isDisplayed();
	}
	
	public boolean verifyZerodhaLogo()
	{
		return zerodhaLogo.isDisplayed();
	}

}
