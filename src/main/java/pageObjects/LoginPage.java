package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(id="username")
	WebElement userName;

	@FindBy(id="password")
	WebElement userPassword;

	@FindBy(className="btn")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[contains(text(),'User Logged In Successfully')]")
	WebElement toasterMessage;
			
	public void goTo()
	{
		driver.get("http://172.16.29.172:4200/#/login");
	}
	
	public void landingPage(String UserName,String Password )
	{
		userName.sendKeys(UserName);
		userPassword.sendKeys(Password);
		loginBtn.click();	
	}

	public String verfySuccessfulMsg()
	{

		String successfulMsg = toasterMessage.getText();
		return successfulMsg;
				
	}






}