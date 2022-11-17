package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class Dashboard extends BaseClass{
	
	@FindBy(xpath="//div[@class='avatar']")private WebElement avtarIcon;
	@FindBy(xpath="//h4[@class='username']")private WebElement username;
	@FindBy(xpath="//div[@class='email']") private WebElement emailId;
	
	public Dashboard()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyUsername() throws InterruptedException
	{
		avtarIcon.click();
		Thread.sleep(2000);
		return username.getText();
	}

}
