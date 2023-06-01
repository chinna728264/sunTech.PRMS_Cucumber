package pageObjects;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.AbstractComponents;

public class SOW_Manage_SOW extends AbstractComponents{

	public SOW_Manage_SOW(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	WebDriver driver;

	

	
	By resourceModule=By.xpath("(//a[@data-toggle='dropdown'])[4]");
	By manageSOWScreen=By.cssSelector("a[routerlink='/manageSOW']");
	By manageSOWScreenHeader=By.cssSelector("h4[id='page-heading'] span");
	By addButton=By.cssSelector("button[routerlink='/addSOW']");
	By addSOWScreenHeader=By.cssSelector("h4[id='page-heading'] span");


	By sowName=By.id("name");
	By clientName=By.id("clientId");
	By sowValue=By.id("amount");
	By sowType=By.id("type");
	By sowStatus=By.id("status");
	By sowBasis=By.id("basis");
	By startDateIcon=By.xpath("(//button[@type='button'])[1]");
	By selectStartMonth=By.xpath("//select[@title='Select month']");
	By selectStartYear=By.xpath("//select[@title='Select year']");
	By selectStartDate=By.xpath("//div[@class='btn-light ng-star-inserted']");
	By endDateIcon=By.xpath("(//button[@type='button'])[2]");
	By selectEndMonth=By.xpath("//select[@title='Select month']");
	By selectEndYear=By.xpath("//select[@title='Select year']");
	By selectEndDate=By.xpath("//div[@class='btn-light ng-star-inserted']");
	By sowDetails=By.id("description");
	By sowFileUpload=By.id("sowFileUpload");
	By saveBtn=By.cssSelector("button[type='submit']");
	By oKbtn=By.xpath("//button[normalize-space()='Ok']");
	By successfulToasterMsg=By.cssSelector("div[aria-label='SOW Added Successfully']");
	





	public void navigateTo_ManageSOWScreen() throws InterruptedException
	{
		driver.findElement(resourceModule).click();
		Thread.sleep(1000);
		driver.findElement(manageSOWScreen).click();
	}

	public void clickOnAddBtn()
	{
		driver.findElement(addButton).click();
	}

	public String verfyAddSOWScreen()
	{
		return driver.findElement(addSOWScreenHeader).getText();
	}

	public void createSOWRecord(String SOWName, String clientNames,String sowValues, String sowTypes,String sowStatuses,String basises,String startMonth,String startYear,String startingDate,String endMonth,String endYear,String endingDate,String sowDescription,String filePath) throws InterruptedException, AWTException
	{
		driver.findElement(sowName).sendKeys(SOWName);
		WebElement clientNameDrp = driver.findElement(clientName);
		selectDropDownbyVisibleTest(clientNameDrp, clientNames);
		driver.findElement(sowValue).sendKeys(sowValues);
		WebElement sowTypeDrp = driver.findElement(sowType);
		selectDropDownbyVisibleTest(sowTypeDrp, sowTypes);
		WebElement sowStatusDrp = driver.findElement(sowStatus);
		selectDropDownbyVisibleTest(sowStatusDrp, sowStatuses);
		WebElement sowBasisDrp = driver.findElement(sowBasis);
		selectDropDownbyVisibleTest(sowBasisDrp, basises);
		selectStartDate(startMonth, startYear, startingDate);
		selectEndDate(endMonth, endYear, endingDate);
		driver.findElement(sowDetails).sendKeys(sowDescription);
		WebElement swUpload = driver.findElement(sowFileUpload);
		JsClickElement(swUpload);
        uploadFile(filePath);
        driver.findElement(saveBtn).click();
	}

	public void selectStartDate(String startMonth,String startYear,String startingDate) throws InterruptedException
	{
		driver.findElement(startDateIcon).click();
		Thread.sleep(2000);
		WebElement monthDropdown = driver.findElement(selectStartMonth);
		selectDropDownbyVisibleTest(monthDropdown, startMonth);
		WebElement yearDropdown = driver.findElement(selectStartYear);
		selectDropDownbyValue(yearDropdown, startYear);

		List<WebElement> allDates = driver.findElements(selectStartDate);


		for(WebElement dates:allDates)
		{
			String allDatesText =dates.getText();

			if(allDatesText.equalsIgnoreCase(startingDate))
			{
				dates.click();
				break;
			}


		}

	}

	public void selectEndDate(String endMonth,String endYear,String endingDate) throws InterruptedException
	{
		driver.findElement(endDateIcon).click();
		Thread.sleep(2000);
		WebElement monthDropdown = driver.findElement(selectEndMonth);
		selectDropDownbyVisibleTest(monthDropdown, endMonth);
		WebElement yearDropdown = driver.findElement(selectEndYear);



		selectDropDownbyVisibleTest(yearDropdown, endYear);
		List<WebElement> allDates = driver.findElements(selectEndDate);

		for(int i=0;i<allDates.size();i++)
		{
			String allDatesText = allDates.get(i).getText();

			if(allDatesText.equalsIgnoreCase(endingDate))
			{
				allDates.get(i).click();
				break;
			}
		}		
	}

	public void clickOnBtn_OnPopup() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(oKbtn).click();
		
	}
	public String verifyToasterMsg()
	{
		return driver.findElement(successfulToasterMsg).getText();
	}



}

