package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import pageObjects.Projects_ManageProjects;
import pageObjects.Projects_ProjectDeliverables;
import pageObjects.Resource;
import pageObjects.SOW_Manage_SOW;
import pageObjects.View_Client;

public class BaseTest {
	
	public WebDriver driver;
	public LoginPage loginPage;
	public View_Client viewClient;
	public Projects_ManageProjects manageProjects ;
	public Projects_ProjectDeliverables projectDeliverables;
	public Resource resource;
	public SOW_Manage_SOW manageSow;
	
	
	
	public WebDriver setUpDriver() throws IOException
	{
	Properties prop=new Properties();
	
	FileInputStream fis=new FileInputStream("Configuration.properties");
	prop.load(fis);
	
	 String browserName = prop.getProperty("Browser");
	
	if(browserName.equalsIgnoreCase("Edge"))
	{
		 driver=new EdgeDriver();
		WebDriverManager.edgedriver().setup();
	}
	else if(browserName.equalsIgnoreCase("Chrome"))
	{
		 driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
	}
	else if(browserName.equalsIgnoreCase("Firefox"))
	{
		 driver=new FirefoxDriver();
		WebDriverManager.firefoxdriver().setup();
	}
	else
	{
		System.out.println("Please Specify any Browser");
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
	
	
	}

}
