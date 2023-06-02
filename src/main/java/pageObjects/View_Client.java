package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.AbstractComponents;

public class View_Client extends AbstractComponents{

	WebDriver driver;


	public View_Client(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	By clientModule=By.linkText("Client");
	By clientModulePageHeader=By.cssSelector("h4[id='page-heading'] span");
	By addClientBtn=By.className("btn");
	By clientName=By.id("name");
	By address=By.id("address");
	By country=By.id("country");
	By location=By.id("location");
	By status=By.id("status");
	By startDate=By.xpath("(//button[@type='button'])[1]");
	By selectMonth=By.xpath("//select[@title='Select month']");
	By selectYear=By.xpath("//select[@title='Select year']");
	By selectDate=By.xpath("//div[@class='ngb-dp-day ng-star-inserted']//div[@class='btn-light ng-star-inserted']");
	By endDate=By.xpath("(//button[@type='button'])[2]");	
	By description=By.id("description");
	By saveBtn=By.cssSelector("button[type='save']");
	By addClientScreen=By.cssSelector("h4[id='page-heading'] span");

	By allStatuses=By.xpath("//div[@class='ag-center-cols-container']/div/div[6]");
	By allCheckBoxes=By.xpath("//div[@ref='eCellWrapper']//div[2]");

	By nextButton=By.xpath("//div[@aria-label='Next Page']");

	By totalPagesCount=By.xpath("//span[@class='ag-paging-description']//span[4]");

	By deleteButton=By.className("btn-danger");

	By searchButton=By.cssSelector("button[type='search']");
	By resetButton=By.className("btn-secondary");
	By exportButton=By.cssSelector("button[data-toggle='dropdown']");
	By clientIDSearchField=By.id("clientId");
	By clientNameSearchField=By.cssSelector("input[placeholder='Client Name']");
	By statusSearchDropdown=By.cssSelector("select[name='status']");
	By clientNameColumnData=By.cssSelector("div[col-id='name']");
	By clientID_ColumnData=By.cssSelector("div[col-id='clientId']");
	By clientStatus_ColumnData=By.cssSelector("div[col-id='status']");



	By NavigationToFirstPage=By.cssSelector("span[class='ag-icon ag-icon-first']");

	By clientNameColumn=By.xpath("//span[text()='Client Name']");

	By errorMsg=By.xpath("//div[contains(text(),'Only Not-Active Clients Can Be Deleted')]");

	By exportBtn_Options=By.cssSelector("button[data-toggle='dropdown'] div a");

	By okBtnOn_ConfPopup=By.cssSelector("button[class='btn btn-primary mr-1']");

	By cancelBtnOn_ConfPopup=By.cssSelector("button[class='btn btn-secondary']");

	By update_SuccToasterMsg=By.cssSelector("div[aria-label=' Updated Successfully']");

	By addingClient_SuccToasterMsg=By.cssSelector("div[aria-label=' Client Added Successfully']");
	By updateButton=By.xpath("//button[@value='submit']");
	By okButton_OnConfPopup=By.cssSelector("button[class='btn btn-outline-primary']");


	WebElement clientNamesSize;
	
	public void click_on_ClientModule()
	{
		driver.findElement(clientModule).click();
	}

	public String verifyClientScreenHeader() throws InterruptedException
	{
		Thread.sleep(1000);
		return driver.findElement(clientModulePageHeader).getText();
	}

	public void click_on_Add()
	{
		driver.findElement(addClientBtn).click();
	}

	public String verifyAddClientScreen()
	{
		String pageHeadingText = driver.findElement(addClientScreen).getText();
		return pageHeadingText;
	}

	public void createNew_Client(String name,String clientAddress,String countryDropDownText,String locationtext,
			String statusText,String startMonth,String startYear,String startingDate,
			String endMonth,String endYear,String endingDate,String descriptionText) throws InterruptedException

	{
		driver.findElement(clientName).sendKeys(name);
		driver.findElement(address).sendKeys(clientAddress);
		WebElement countryDropdown = driver.findElement(country);
		selectDropDownbyVisibleTest(countryDropdown, countryDropDownText);
		driver.findElement(location).sendKeys(locationtext);
		WebElement statusDropdown = driver.findElement(status);
		selectDropDownbyVisibleTest(statusDropdown, statusText);
		selectStartDate(startMonth, startYear, startingDate);
		selectEndDate(endMonth, endYear, endingDate);
		driver.findElement(description).sendKeys(descriptionText);

	}

	public void clickonSaveButton()
	{
		driver.findElement(saveBtn).click();
	}

	public void clickonOkButtonOnPopup() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(okBtnOn_ConfPopup).click();
	}
	public String verifyConfirmationMessage() throws InterruptedException
	{
		Thread.sleep(2000);
		return driver.findElement(addingClient_SuccToasterMsg).getText();
	}


	public void selectingClientToUpdate(String clientName)
	{
		
		List<WebElement> clientNames = driver.findElements(clientNameColumnData);
		
		for(int i=1;i<clientNames.size();i++)
		{
			String clientNameText = clientNames.get(i).getText();
			if(clientNameText.equalsIgnoreCase(clientName))
			{
				clientNamesSize=clientNames.get(i);
				clientNamesSize.click();
				break;
				
			}
		}
		
//			do {
//				List<WebElement> clientNames = driver.findElements(clientNameColumnData);
//				for(int i=1;i<clientNames.size();i++)
//				{
//					String clientNameText = clientNames.get(i).getText();
//					if(clientNameText.equalsIgnoreCase(clientName))
//					{
//						clientNamesSize=clientNames.get(i);
//						clientNamesSize.click();
//						break;
//						
//					}
//				}
//				if(clientNamesSize.toString().length()<0)
//				{
//					driver.findElement(nextButton).click();
//				}
//
//			}
//			while(clientNamesSize.toString().length()>0);
				
	}

	public void updatingClientDetails(String clientAddress,String countryDropDownText,String locationtext,
			String statusText,String startMonth,String startYear,String startingDate,
			String endMonth,String endYear,String endingDate,String descriptionText) throws InterruptedException
	{
		WebElement addre = driver.findElement(address);
		addre.clear();
		addre.sendKeys(clientAddress);
		WebElement countryDropdown = driver.findElement(country);
		selectDropDownbyVisibleTest(countryDropdown, countryDropDownText);
		WebElement loc = driver.findElement(location);
		loc.clear();
		loc.sendKeys(locationtext);
		WebElement statusDropdown = driver.findElement(status);
		selectDropDownbyVisibleTest(statusDropdown, statusText);
		selectStartDate(startMonth, startYear, startingDate);
		selectEndDate(endMonth, endYear, endingDate);
		WebElement des = driver.findElement(description);
		des.clear();
		des.sendKeys(descriptionText);
	}

	public void clickOnUpdateButton() 
	{
		driver.findElement(updateButton).click();
	}

	public String verifyUpdatedToasterMessage() throws InterruptedException
	{
		Thread.sleep(2000);
		return driver.findElement(update_SuccToasterMsg).getText();
	}	



	public void Validate_DeletionOfClient_BasesOnStatus_in_Client_screen(String clientStatus) throws InterruptedException
	{


		List<WebElement> statuses = driver.findElements(allStatuses);

		for(int k=0;k<statuses.size();k++)
		{
			String allStatasusText=statuses.get(k).getText();
			if(allStatasusText.equals(clientStatus))
			{
				List<WebElement> allCheckbx = driver.findElements(allCheckBoxes);
				Thread.sleep(2000);
				allCheckbx.get(k).click();
				Thread.sleep(1000);
				break;
			}		
		}


	}
	public boolean verifyDeleteButton()
	{
		return driver.findElement(deleteButton).isEnabled();
	}


	public void performDeleteOperation()
	{
		driver.findElement(deleteButton).click();

	}

	public String verifyErrorMessage() throws InterruptedException
	{
		Thread.sleep(2000);
		return driver.findElement(errorMsg).getText();
	}

	public void clientNameSearch(String clintsNames)
	{
		driver.findElement(clientNameSearchField).sendKeys(clintsNames);
	}
	public void clickOnSearchbtn() throws InterruptedException
	{
		driver.findElement(searchButton).click();
		Thread.sleep(2000);
	}

	public void verifyClientName_in_SearchTable(String clientname) throws InterruptedException
	{
		List<WebElement> displayedData = driver.findElements(clientNameColumnData);
		Thread.sleep(2000);
		List<WebElement> filteredData = verifySeachFilters_UsingStreams(displayedData,clientname);
		Assert.assertEquals(displayedData.size()-1, filteredData.size());
		System.out.println("Client Name Search Filter Records are Matching Perfectly....!!!!!");
	}


	public void clientID_search(String clientID)
	{
		driver.findElement(clientIDSearchField).sendKeys(clientID);
	}

	public void verifyClientID_in_SearchTable(String clientID) throws InterruptedException
	{
		List<WebElement> displayedData = driver.findElements(clientID_ColumnData);
		Thread.sleep(2000);
		List<WebElement> filteredData = verifySeachFilters_UsingStreams(displayedData,clientID);
		Assert.assertEquals(displayedData.size()-1, filteredData.size());
		System.out.println("Client ID Search Filter Records are Matching Perfectly....!!!!!");
	}

	public void clientStatus_search(String status)
	{
		WebElement status_dropDown = driver.findElement(statusSearchDropdown);
		selectDropDownbyVisibleTest(status_dropDown,status);
	}

	public void verifyClientStatus_in_SearchTable(String status) throws InterruptedException
	{

		List<WebElement> displayedData = driver.findElements(clientStatus_ColumnData);
		Thread.sleep(2000);
		List<WebElement> filteredData = verifySeachFilters_UsingStreams(displayedData,status);
		Assert.assertEquals(displayedData.size()-1, filteredData.size());
		System.out.println("Client Status Search Filter Records are Matching Perfectly....!!!!!");

	}


	public void clickOn_ExportButton()
	{
		driver.findElement(exportButton).click();
	}

	public void download_ClientModuleReport(String reportType)
	{
		List<WebElement> options = driver.findElements(exportBtn_Options);

		for(WebElement optionsText:options)
		{
			String reportsType = optionsText.getText();
			if(reportsType.equals(reportType))
			{
				optionsText.click();
				break;
			}

		}
	}












	public void selectStartDate(String startMonth,String startYear,String startingDate) throws InterruptedException
	{
		driver.findElement(startDate).click();
		Thread.sleep(2000);
		WebElement monthDropdown = driver.findElement(selectMonth);
		selectDropDownbyVisibleTest(monthDropdown, startMonth);
		WebElement yearDropdown = driver.findElement(selectYear);
		selectDropDownbyValue(yearDropdown, startYear);

		List<WebElement> allDates = driver.findElements(selectDate);


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
		driver.findElement(endDate).click();
		Thread.sleep(2000);
		WebElement monthDropdown = driver.findElement(selectMonth);
		selectDropDownbyVisibleTest(monthDropdown, endMonth);
		WebElement yearDropdown = driver.findElement(selectYear);



		selectDropDownbyVisibleTest(yearDropdown, endYear);
		List<WebElement> allDates = driver.findElements(selectDate);

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


	public void Validate_nextButton()
	{
		String pagesCount = driver.findElement(totalPagesCount).getText();
		int toalPagesNumber = Integer.parseInt(pagesCount);

		for(int c=1;c<=toalPagesNumber;c++)
		{
			List<WebElement> statuses = driver.findElements(allStatuses);

			for(int o=0;o<statuses.size();o++)
			{
				String	allStatasusText=statuses.get(o).getText();
				System.out.println(allStatasusText);
			}

			driver.findElement(nextButton).click();
		}
		driver.findElement(NavigationToFirstPage).click();

	}


	//****************************************** Sorting Scenario is Pending *************************

	public ArrayList<String> beforeSorting_ClientNames_Data_in_Client_table_of_ClientName() throws InterruptedException
	{

		String pagesCount = driver.findElement(totalPagesCount).getText();

		int toalPagesNumber = Integer.parseInt(pagesCount);

		ArrayList<String> actualData= new ArrayList<String>();


		for(int p=1;p<=toalPagesNumber;p++)
		{
			List<WebElement> clientNames = driver.findElements(clientNameColumnData);

			for(int c=1;c<clientNames.size();c++)
			{
				actualData.add(clientNames.get(c).getText());
			}
			driver.findElement(nextButton).click();
			Thread.sleep(1000);
		}

		driver.findElement(NavigationToFirstPage).click();
		Thread.sleep(2000);
		return  actualData;


	}
	public void clickOnClientColumn() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(clientNameColumn).click();
	}

	public ArrayList<String> afterSorting_ClientNames_Data_in_Client_table_of_ClientName() throws InterruptedException, IOException
	{


		Thread.sleep(1000);
		driver.findElement(clientNameColumn).click();
		Thread.sleep(2000);

		String pagesCount = driver.findElement(totalPagesCount).getText();
		int toalPagesNumber = Integer.parseInt(pagesCount);

		ArrayList<String> actualData1= new ArrayList<String>();



		for(int p=1;p<=toalPagesNumber;p++)
		{
			List<WebElement> clientNames = driver.findElements(clientNameColumnData);

			for(int c=1;c<clientNames.size();c++)
			{
				actualData1.add(clientNames.get(c).getText());

			}

			driver.findElement(nextButton).click();


		}

		return actualData1;		
	}


	public void verifySotingOperation() throws InterruptedException
	{


		Thread.sleep(1000);

		String pagesCount = driver.findElement(totalPagesCount).getText();
		int toalPagesNumber = Integer.parseInt(pagesCount);

		ArrayList<String> actualData1= new ArrayList<String>();


		for(int p=1;p<=toalPagesNumber;p++)
		{
			List<WebElement> clientNames = driver.findElements(clientNameColumnData);

			for(int c=1;c<clientNames.size();c++)
			{
				actualData1.add(clientNames.get(c).getText());

			}

			driver.findElement(nextButton).click();
		}

		System.out.println("First :" +actualData1);



	}

	public void test1() throws InterruptedException
	{
		driver.findElement(NavigationToFirstPage).click();
		Thread.sleep(1000);
		driver.findElement(clientNameColumn).click();
		Thread.sleep(2000);
		String pagesCount2ndTime = driver.findElement(totalPagesCount).getText();

		int toalPagesNumber2ndTime = Integer.parseInt(pagesCount2ndTime);

		ArrayList<String> expData1= new ArrayList<String>();

		for(int p=1;p<=toalPagesNumber2ndTime;p++)
		{
			List<WebElement> clientNames = driver.findElements(clientNameColumnData);

			for(int c=1;c<clientNames.size();c++)
			{
				expData1.add(clientNames.get(c).getText());

			}

			driver.findElement(nextButton).click();
		}


		System.out.println(expData1);
	}



}
