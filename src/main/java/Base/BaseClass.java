package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public static WebDriver driver;
	
	public String readPropertyFile(String value) throws IOException
	{
		Properties p = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Final_Project\\src\\main\\java\\Config\\Config.properties");
		p.load(file);
		return p.getProperty(value);
		
	}
	public void initialization() throws IOException
	{
		String browserName = readPropertyFile("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Final_Project\\Drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\eclipse-workspace\\Final_Project\\Drivers\\geckodriver.exe");
		    driver = new FirefoxDriver();
		}
	    
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\eclipse-workspace\\Final_Project\\Drivers\\msedgedriver.exe");
		    driver = new EdgeDriver();
		}
	    
	    driver.manage().window().maximize();
	    driver.get(readPropertyFile("url"));
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	}

}
