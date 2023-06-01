package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.AbstractComponents;

public class Resource extends AbstractComponents{

	WebDriver driver;

	public Resource(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}


	By resourceModule=By.cssSelector("a[routerlink='/viewResource']");

	By allProjectNames=By.cssSelector("div[col-id='projectName']");
	By resourceAllocationHeader=By.cssSelector("h4[id='page-heading'] span");
	By searchProjectHeader=By.cssSelector("h4[id='page-heading'] span");
	By addButton=By.id("addBtn");
	By saveButton=By.id("saveButton");

	By okButton=By.xpath("//div[@class='modal-footer']//button[1]");

	By deleteButton=By.className("btn-danger");



	By firstElement=By.xpath("(//div[@class='ag-cell ag-cell-normal-height ag-cell-value ag-cell-not-inline-editing']/following-sibling::div)");
	By secondElement=By.xpath("(//div[@class='ag-cell ag-cell-normal-height ag-cell-value ag-cell-not-inline-editing']/following-sibling::div)[2]");
	By resourceIDField=By.cssSelector("input[placeholder='Search an Employee Name - ID']");

	By resourceFunctionDrp=By.xpath("(//div[@class='ag-cell ag-cell-normal-height ag-cell-value ag-cell-not-inline-editing']/following-sibling::div)[6]");
	By resourceTypeDrp=By.xpath("(//div[@class='ag-cell ag-cell-normal-height ag-cell-value ag-cell-not-inline-editing']/following-sibling::div)[6]");

	By billableRateDrp=By.xpath("(//div[@class='ag-cell ag-cell-normal-height ag-cell-value ag-cell-not-inline-editing']/following-sibling::div)[7]");

	By amountRateUSD=By.xpath("(//div[@class='ag-cell ag-cell-not-inline-editing ag-cell-normal-height ag-cell-value ag-cell-focus'])[1]");

	By startDateEMP=By.xpath("(//div[@class='ag-cell ag-cell-normal-height ag-cell-value ag-cell-not-inline-editing']/following-sibling::div)[4]");

	By endDateEMP=By.xpath("(//div[@class='ag-cell ag-cell-normal-height ag-cell-value ag-cell-not-inline-editing']/following-sibling::div)[5]");

	By estimatedQty=By.xpath("(//div[@class='ag-cell ag-cell-normal-height ag-cell-value ag-cell-not-inline-editing']/following-sibling::div)[6]");

	By actualQty=By.xpath("(//div[@class='ag-cell ag-cell-normal-height ag-cell-value ag-cell-not-inline-editing']/following-sibling::div)[7]");

	By percentageOfAllocation=By.xpath("(//div[@class='ag-cell ag-cell-normal-height ag-cell-value ag-cell-not-inline-editing']/following-sibling::div)[8]");


	By notactiveElement=By.xpath("//div[@class='ag-cell ag-cell-normal-height ag-cell-value ag-cell-not-inline-editing']");
	By activeElement=By.xpath("//div[@class='ag-cell ag-cell-normal-height ag-cell-value ag-cell-not-inline-editing ag-cell-focus']");
	By locationDropDown=By.id("ddlViewBy");
	By departmentDropDown=By.id("ddlViewBy");
	By resFunction=By.id("ddlViewBy");
	By resType=By.id("ddlViewBy");
	By billableRate=By.id("ddlViewBy");

	//------------------------------------------

	By monthAndYear=By.xpath("//button[@aria-label='Choose month and year']");
	By allYears=By.cssSelector("td[class='mat-calendar-body-cell-container'] button div:first-child");
	By allMonths=By.cssSelector("td[class='mat-calendar-body-cell-container'] button div:first-child");
	By allDates=By.cssSelector("td[class='mat-calendar-body-cell-container'] button div:first-child");


	By endDate_MonthAndYear=By.xpath("//button[@aria-label='Choose month and year']");
	By endDate_AllYears=By.cssSelector("td[class='mat-calendar-body-cell-container'] button div:first-child");
	By endDate_AllMonths=By.cssSelector("td[class='mat-calendar-body-cell-container'] button div:first-child");
	By endDate_AllDates=By.cssSelector("td[class='mat-calendar-body-cell-container'] button div:first-child");

	By toSelectAllCheckBox=By.cssSelector("div[class='ag-labeled ag-label-align-right ag-checkbox ag-input-field ag-header-select-all']");
	By checkBoxes=By.xpath("//div[@ref='eCellWrapper']//div[2]");
	//**************************************************************************************************

	By resourceID_ColumnData=By.cssSelector("div[col-id='employeeNumber']");

	By resourceFunction_ColumnData=By.cssSelector("div[col-id='resourceFunction']");

	By resourceTpe_ColumnData=By.cssSelector("div[col-id='resourceTypeId']");

	By billRateType_ColumnData=By.cssSelector("div[col-id='billRateType']");

	By amountRateUSD_ColumnData=By.cssSelector("div[col-id='amount']");

	By startDate_ColumnData=By.cssSelector("div[col-id='startDate']");

	By endDate_ColumnData=By.cssSelector("div[col-id='endDate']");

	By estimatedQTY_ColumnData=By.cssSelector("div[col-id='estimatedQty']");
	By actualQTY_ColumnData=By.cssSelector("div[col-id='actualQty']");
	By percentageAllocation_ColumnData=By.cssSelector("div[col-id='percentageAllocation']");

	By okButton_OnConfPopup=By.cssSelector("button[class='btn btn-outline-primary']");
	
	By succFDeletedToasterMsg=By.cssSelector("div[aria-label='Successfully Deleted Data']");
	

	String resourceFuntion_To_EndDate_Visibility = "document.querySelector('.ag-body-horizontal-scroll-viewport').scrollBy(1100,0)";


	public void clickOnResourceModule() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(resourceModule).click();
	}

	public String verify_SearchProjectHeader()
	{
		return driver.findElement(searchProjectHeader).getText();
	}

	public void selectProject(String projectName)
	{
		List<WebElement> projects = driver.findElements(allProjectNames);

		for(int i=1;i<projects.size();i++)
		{
			String projectsNameText = projects.get(i).getText();

			if(projectsNameText.equalsIgnoreCase(projectName))
			{
				projects.get(i).click();
				break;
			}
		}
	}

	public String verify_ResourceAllocation_Header()
	{
		return driver.findElement(resourceAllocationHeader).getText();
	}

	public void clickOn_AddButton() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(addButton).click();
	}

	public void addingResouces(String location, String department, String EmpName_ID, String resourceFuntion, String resourceType, String billRateType, String amountRate_USD, String statYear, String startMonth, String startDate, String endYear, String endMonth, String endDate, String estimated_Qty, String actual_Qty, String percetage_Allocation) throws InterruptedException
	{
		location(location);
		deparment(department);
		resourceName_ID(EmpName_ID);
		resourceFunction(resourceFuntion);
		resourceType(resourceType);	    
		billableRateType(billRateType);
		Thread.sleep(1000);
		driver.findElement(amountRateUSD).sendKeys(amountRate_USD,Keys.ENTER);
		selectingResourceStartDate(statYear,startMonth,startDate);
		selectingResourceEndDate(endYear,endMonth,endDate);
		driver.findElement(estimatedQty).sendKeys(estimated_Qty,Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(actualQty).sendKeys(actual_Qty,Keys.ENTER);
		driver.findElement(percentageOfAllocation).sendKeys(percetage_Allocation,Keys.ENTER); 
		scrollDown();
		scrollLeft();
		clickOnCheckBox();
		saveTheRecord(); 

	}

	public void location(String location) throws InterruptedException
	{
		WebElement locationDrp = driver.findElement(locationDropDown);
		Thread.sleep(1000);
		selectDropDownbyVisibleTest(locationDrp, location);
		Thread.sleep(1000);
		driver.findElement(firstElement).click();
	}
	public void deparment(String department) throws InterruptedException
	{
		Thread.sleep(1000);
		WebElement deptDropDown = driver.findElement(departmentDropDown);
		deptDropDown.click();
		selectDropDownbyVisibleTest(deptDropDown,department);
		Thread.sleep(1000);
		driver.findElement(secondElement).click();
		Thread.sleep(2000);
	}
	public void resourceName_ID( String EmpName_ID) throws InterruptedException
	{
		driver.findElement(secondElement).click();
		Thread.sleep(2000);
		WebElement resourceNames = driver.findElement(resourceIDField);
		resourceNames.sendKeys(EmpName_ID);
		Thread.sleep(2000);
		resourceNames.sendKeys(Keys.ENTER);
	}

	public void resourceFunction(String resourceFuntion) throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(resourceFunctionDrp).click();
		WebElement resFun = driver.findElement(resFunction);
		resFun.click();
		selectDropDownbyVisibleTest(resFun,resourceFuntion);
	}
	public void resourceType(String resourceType) throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(resourceTypeDrp).click();
		WebElement resourcetype = driver.findElement(resType);
		resourcetype.click();
		selectDropDownbyVisibleTest(resourcetype,resourceType); 
	}
	public void billableRateType(String billRateType) throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(billableRateDrp).click();
		WebElement rate = driver.findElement(billableRate);
		rate.click();
		selectDropDownbyVisibleTest(rate,billRateType);
	}
	public void selectingResourceStartDate(String statYear,String startMonth,String startDate) throws InterruptedException
	{
		driver.findElement(startDateEMP).click();
		Thread.sleep(1000);
		driver.findElement(monthAndYear).click();
		Thread.sleep(1000);
		List<WebElement> numYears = driver.findElements(allYears);

		for(WebElement yer:numYears)
		{

			String yeartext = yer.getText();
			if(yeartext.equalsIgnoreCase(statYear))
			{
				yer.click();
				break;
			}
		}

		Thread.sleep(1000);
		List<WebElement> numMonts = driver.findElements(allMonths);

		for(WebElement mon:numMonts)
		{

			String monText = mon.getText();

			if(monText.equalsIgnoreCase(startMonth))
			{
				mon.click();
				break;
			}
		}

		Thread.sleep(1000);
		List<WebElement> numDates = driver.findElements(allDates);

		for(WebElement dt:numDates)
		{

			String dtText = dt.getText();

			if(dtText.equalsIgnoreCase(startDate))
			{
				dt.click();
				break;
			}
		}
	}

	public void selectingResourceEndDate(String endYear,String endMonth,String endDate) throws InterruptedException
	{
		driver.findElement(endDateEMP).click();
		Thread.sleep(1000);
		driver.findElement(endDate_MonthAndYear).click();

		Thread.sleep(1000);
		List<WebElement> endyears = driver.findElements(endDate_AllYears);

		for( WebElement endYr:endyears)
		{

			String endYearText = endYr.getText();
			if(endYearText.equalsIgnoreCase(endYear))
			{
				endYr.click();
				break;
			}
		}

		Thread.sleep(1000);
		List<WebElement> endmonths = driver.findElements(endDate_AllMonths);

		for(WebElement endmon:endmonths)
		{

			String endMonthText = endmon.getText();

			if(endMonthText.equalsIgnoreCase(endMonth))
			{
				endmon.click();
				break;
			}
		}

		Thread.sleep(1000);
		List<WebElement> endDates = driver.findElements(endDate_AllDates);

		for( WebElement endDT:endDates)
		{

			String endDtText = endDT.getText();

			if(endDtText.equalsIgnoreCase(endDate))
			{
				endDT.click();
				break;
			}
		}
	}

	public void scrollDown()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(200,500)");	
	}
	public void scrollLeft() throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.querySelector('.ag-body-horizontal-scroll-viewport').scrollBy(-2500,0)");
	}
	public void clickOnCheckBox()
	{
		List<WebElement> chkBoxes = driver.findElements(checkBoxes);

		for(int ch=chkBoxes.size()-1;ch>=0;ch--)
		{
			chkBoxes.get(ch).click();
			break;
		}
	}

	public void saveTheRecord() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(saveButton).click();
		Thread.sleep(1000);
		driver.findElement(okButton).click();
	}

	//******************************************************************************************88

	public void selectingTheProject_To_Update(String projectName) throws InterruptedException
	{
		Thread.sleep(3000);
		List<WebElement> projNames = driver.findElements(allProjectNames);

		for(int i=1;i<projNames.size();i++)
		{
			String projText = projNames.get(i).getText();
			if(projText.equalsIgnoreCase(projectName))
			{
				projNames.get(i).click();
				Thread.sleep(2000);	
				JavascriptExecutor js1=(JavascriptExecutor)driver;
				js1.executeScript("window.scrollBy(0,300)");
				break;


			}
		}
	}


	public void verifyTheEmployeeAndUpdateDetails(String EmployeeName_or_ID,String resourceFunction,String resourceType,String billRateType,String amountRate_USD,String statYear,String startMonth,String startDate,String endYear,String endMonth,String endDate,String estimated_Qty,String actual_Qty,String percetage_Allocation ) throws InterruptedException
	{

		List<WebElement> resourcesData = driver.findElements(resourceID_ColumnData);

		for(int i=1;i<resourcesData.size();i++)
		{

			if(resourcesData.get(i).getText().contains(EmployeeName_or_ID))
			{

				scrollChildWidow(resourceFuntion_To_EndDate_Visibility);

				List<WebElement> resourceFunctionData = driver.findElements(resourceFunction_ColumnData);
				resourceFunctionData.get(i).click();
				WebElement resourceFn_Drp = driver.findElement(resFunction);
				resourceFn_Drp.click();
				selectDropDownbyVisibleTest(resourceFn_Drp, resourceFunction);

				List<WebElement> resourceTypeData = driver.findElements(resourceTpe_ColumnData);
				resourceTypeData.get(i).click();
				WebElement resourcetype = driver.findElement(resType);
				resourcetype.click();
				selectDropDownbyVisibleTest(resourcetype,resourceType); 



				List<WebElement> billRateTypeData = driver.findElements(billRateType_ColumnData);
				billRateTypeData.get(i).click();		
				WebElement rate = driver.findElement(billableRate);
				rate.click();
				selectDropDownbyVisibleTest(rate,billRateType);



				List<WebElement> amountRateData = driver.findElements(amountRateUSD_ColumnData);
				amountRateData.get(i).sendKeys(amountRate_USD,Keys.ENTER);



				List<WebElement> stratDateData = driver.findElements(startDate_ColumnData);
				stratDateData.get(i).click();
				selectingResourceStartDateToUpdate( statYear, startMonth, startDate);


				List<WebElement> endDateData = driver.findElements(endDate_ColumnData);
				endDateData.get(i).click();
				selectingResourceEndDate_To_Update( endYear, endMonth, endDate);

				List<WebElement> estimatedQTYData = driver.findElements(estimatedQTY_ColumnData);
				estimatedQTYData.get(i).sendKeys(estimated_Qty,Keys.ENTER);

				List<WebElement> actualQTYData = driver.findElements(actualQTY_ColumnData);
				actualQTYData.get(i).sendKeys(actual_Qty,Keys.ENTER);


				List<WebElement> percentageAllocationData = driver.findElements(percentageAllocation_ColumnData);
				percentageAllocationData.get(i).sendKeys(percetage_Allocation,Keys.ENTER); 
				
				scrollDown();
				scrollLeft();
				clickOnCheckBox();
				saveTheRecord();
				break;
			}

		}
	}

	public void selectingResourceStartDateToUpdate(String statYear,String startMonth,String startDate) throws InterruptedException
	{

		driver.findElement(monthAndYear).click();
		Thread.sleep(1000);
		List<WebElement> numYears = driver.findElements(allYears);

		for(WebElement yer:numYears)
		{

			String yeartext = yer.getText();
			if(yeartext.equalsIgnoreCase(statYear))
			{
				yer.click();
				break;
			}
		}

		Thread.sleep(1000);
		List<WebElement> numMonts = driver.findElements(allMonths);

		for(WebElement mon:numMonts)
		{

			String monText = mon.getText();

			if(monText.equalsIgnoreCase(startMonth))
			{
				mon.click();
				break;
			}
		}

		Thread.sleep(1000);
		List<WebElement> numDates = driver.findElements(allDates);

		for(WebElement dt:numDates)
		{

			String dtText = dt.getText();

			if(dtText.equalsIgnoreCase(startDate))
			{
				dt.click();
				break;
			}
		}
	}

	public void selectingResourceEndDate_To_Update(String endYear,String endMonth,String endDate) throws InterruptedException
	{

		driver.findElement(endDate_MonthAndYear).click();

		Thread.sleep(1000);
		List<WebElement> endyears = driver.findElements(endDate_AllYears);

		for( WebElement endYr:endyears)
		{

			String endYearText = endYr.getText();
			if(endYearText.equalsIgnoreCase(endYear))
			{
				endYr.click();
				break;
			}
		}

		Thread.sleep(1000);
		List<WebElement> endmonths = driver.findElements(endDate_AllMonths);

		for(WebElement endmon:endmonths)
		{

			String endMonthText = endmon.getText();

			if(endMonthText.equalsIgnoreCase(endMonth))
			{
				endmon.click();
				break;
			}
		}

		Thread.sleep(1000);
		List<WebElement> endDates = driver.findElements(endDate_AllDates);

		for( WebElement endDT:endDates)
		{

			String endDtText = endDT.getText();

			if(endDtText.equalsIgnoreCase(endDate))
			{
				endDT.click();
				break;
			}
		}
	}

	public void verifyingTheEmployee_and_Deleting(String EmployeeName_or_ID) throws InterruptedException
	{
		List<WebElement> resourcesData = driver.findElements(resourceID_ColumnData);

		List<WebElement> chk = driver.findElements(checkBoxes);
		for(int i=1;i<resourcesData.size();i++)
		{

			if(resourcesData.get(i).getText().contains(EmployeeName_or_ID))
			{
				chk.get(i-1).click();
				Thread.sleep(1000);
				driver.findElement(deleteButton).click();
				Thread.sleep(2000);
				driver.findElement(okButton_OnConfPopup).click();
				break;
			}
		}
	}
	
	public void selectingTheProject_To_Delete(String projectName) throws InterruptedException
	{
		Thread.sleep(3000);
		List<WebElement> projNames = driver.findElements(allProjectNames);

		for(int i=1;i<projNames.size();i++)
		{
			String projText = projNames.get(i).getText();
			if(projText.equalsIgnoreCase(projectName))
			{
				projNames.get(i).click();
				break;
			}
		}
	}
	public String verifyDeletionToasterMessage() throws InterruptedException
	{
		Thread.sleep(1000);
		return driver.findElement(succFDeletedToasterMsg).getText();
	}

}
