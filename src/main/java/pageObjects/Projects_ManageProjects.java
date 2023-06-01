package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utilities.AbstractComponents;

public class Projects_ManageProjects extends AbstractComponents{

	WebDriver driver;

	public Projects_ManageProjects(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
	}

	By projectsModule=By.xpath("(//a[@data-toggle='dropdown'])[3]");
	By manageProjects=By.cssSelector("a[routerlink='/viewProject']");

	By addClientScreen=By.cssSelector("h4[id='page-heading'] span");
	By addProjectBtn=By.cssSelector("button[routerlink='/addProject']");
	By deleteButton=By.className("btn-danger");
	By searchButton=By.cssSelector("button[type='search']");
	By resetButton=By.className("btn-secondary");
	By exportButton=By.cssSelector("button[data-toggle='dropdown']");
	By exportBtn_Options=By.cssSelector("div[class='dropdown-menu show'] a");

	By projectIDSearchField=By.id("projectId");
	By projectNameSearchField=By.cssSelector("input[placeholder='Project Name']");
	By clientNameSearchField=By.id("clientName");
	By projectStatusSearchDropdown=By.id("projectStatus");
	By projectTypeSearchDropdown=By.id("projectType");

	By allProjectsStatuses=By.cssSelector("div[col-id='projectStatus']");
	By allCheckBoxes=By.xpath("//div[@ref='eCellWrapper']//div[2]");

	By confirmationPopup_Header=By.xpath("//div[@class='modal-content']//h5");
	By okButton_OnConfPopuop=By.xpath("//div[@class='modal-content']//button[@class='btn btn-primary mr-1']");

	By errorMsg=By.cssSelector("div[aria-label=\" Only Projects With Status As 'NOT STARTED' Can Be Deleted \"]");


	By allProjectID_ColumnData=By.cssSelector("div[col-id='projectId']");
	By allProjectName_ColumnData=By.cssSelector("div[col-id='projectName']");
	By allClientNames_ColumnData=By.cssSelector("div[col-id='clientName']");
	By allProjectsStatus_ColumnData=By.cssSelector("div[col-id='projectStatus']");
	By allProjectsTypes_ColumnData=By.cssSelector("div[col-id='projectType']");




	//************************** Add Project **************************
	By addProjectScreen=By.cssSelector("h4[id='page-heading'] span");
	By projectName=By.id("projectName");
	By clientName=By.id("clientId");
	By projectType=By.id("projectType");
	By projectStatus=By.id("projectStatus");
	By startDate=By.xpath("(//button[@type='button'])[1]");
	By selectMonth=By.xpath("//select[@title='Select month']");
	By selectYear=By.xpath("//select[@title='Select year']");
	By selectDate=By.xpath("//div[@class='btn-light ng-star-inserted']");
	By endDate=By.xpath("(//button[@type='button'])[2]");
	By percentageOfCompletion=By.id("percentageOfCompletion");
	By projectAmount=By.id("sowAmount");
	By estimatedStaffHours=By.id("estimatedStaffHours");
	By actualStaffHours=By.id("actualStaffHours");
	By noOfResources=By.id("numberOfResource");
	By description=By.id("description");
	By saveBtn=By.cssSelector("button[type='submit']");
	By cancelBtn=By.cssSelector("button[class='btn btn-secondary btn-sm text-center']");

	By nextButton=By.xpath("//div[@aria-label='Next Page']");
	By updateButton=By.cssSelector("button[type='submit']");

	By okBtnOn_ConfPopup=By.cssSelector("button[class='btn btn-primary mr-1']");
	By cancelBtnOn_ConfPopup=By.cssSelector("button[class='btn btn-secondary']");

	By update_SuccToasterMsg=By.cssSelector("div[aria-label='Updated Successfully']");
	By projAdd_SuccToasterMsg=By.cssSelector("div[aria-label='Project Added Successfully']");


	WebElement projectMatch;


	public void clickOn_ProjectModule() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(projectsModule).click();
		driver.findElement(manageProjects).click();

	}

	public void click_onaddButton_In_ViewProject_Screen()
	{
		driver.findElement(addProjectBtn).click();
	}
	public String verify_AddProject_screen()
	{
		return driver.findElement(addProjectScreen).getText();
	}

	public void createNew_Project(String projectname,String clientname,String project_type,String projectstatus,
			String startMonth,String startYear,String startingDate,
			String endMonth,String endYear,String endingDate,String completionPercentage,String amount,String estimated_HRS
			,String actual_HRS,String numberOfResources,String proj_Description) throws InterruptedException
	{
		driver.findElement(projectName).sendKeys(projectname);

		WebElement clientNameDroDown = driver.findElement(clientName);
		selectDropDownbyVisibleTest(clientNameDroDown, clientname);

		WebElement projectTypeDropDown = driver.findElement(projectType);
		selectDropDownbyVisibleTest(projectTypeDropDown, project_type);

		WebElement projectStatuDropDown = driver.findElement(projectStatus);
		selectDropDownbyVisibleTest(projectStatuDropDown, projectstatus);

		selectStartDate(startMonth, startYear, startingDate);
		selectEndDate(endMonth, endYear, endingDate);

		driver.findElement(percentageOfCompletion).sendKeys(completionPercentage);
		driver.findElement(projectAmount).sendKeys(amount);
		driver.findElement(estimatedStaffHours).sendKeys(estimated_HRS);
		driver.findElement(actualStaffHours).sendKeys(actual_HRS);
		driver.findElement(noOfResources).sendKeys(numberOfResources);
		driver.findElement(description).sendKeys(proj_Description);	

	}

	public void clickOn_SaveButton()
	{
		driver.findElement(saveBtn).click();
	}


	public String verifyAddProjectSuccessMsg()
	{
		return driver.findElement(projAdd_SuccToasterMsg).getText();
	}


	public void selectingTheProjectToUpdate(String projectName)
	{

		try {
			do {
				List<WebElement> projectNames = driver.findElements(allProjectName_ColumnData);

				for(int i=1;i<projectNames.size();i++)
				{
					String projectNameText = projectNames.get(i).getText();

					if(projectNameText.equalsIgnoreCase(projectName))
					{
						projectMatch=projectNames.get(i);
						projectMatch.click();
						
					}
					
				}	

				if(projectMatch.toString().length()<0)
				{
					driver.findElement(nextButton).click();
				}

			}while(projectMatch.toString().length()>0);

		}catch(Exception e)

		{

		}
	}


	public void updatingProjectDetails(String project_type,String projectstatus,
			String startMonth,String startYear,String startingDate,
			String endMonth,String endYear,String endingDate,String completionPercentage,String amount,String estimated_HRS
			,String actual_HRS,String numberOfResources,String proj_Description) throws InterruptedException
	{
		WebElement projectTypeDropDown = driver.findElement(projectType);
		selectDropDownbyVisibleTest(projectTypeDropDown, project_type);

		WebElement projectStatuDropDown = driver.findElement(projectStatus);
		selectDropDownbyVisibleTest(projectStatuDropDown, projectstatus);

		selectStartDate(startMonth, startYear, startingDate);
		selectEndDate(endMonth, endYear, endingDate);

		WebElement perCmpl = driver.findElement(percentageOfCompletion);
		perCmpl.clear();
		perCmpl.sendKeys(completionPercentage);
		WebElement amt = driver.findElement(projectAmount);
		amt.clear();
		amt.sendKeys(amount);
		WebElement esStaffHrs = driver.findElement(estimatedStaffHours);
		esStaffHrs.clear();
		esStaffHrs.sendKeys(estimated_HRS);
		WebElement actStaffHrs = driver.findElement(actualStaffHours);
		actStaffHrs.clear();
		actStaffHrs.sendKeys(actual_HRS);
		WebElement res = driver.findElement(noOfResources);
		res.clear();
		res.sendKeys(numberOfResources);
		WebElement des = driver.findElement(description);
		des.clear();
		des.sendKeys(proj_Description);

	}

	public void clickOnUpdateButton()
	{
		driver.findElement(updateButton).click();
	}

	public void clickonOkButtonOn_ConfrmPopup() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(okBtnOn_ConfPopup).click();
	}

	public String verifyUpdateSuccMessage() throws InterruptedException
	{
		Thread.sleep(1000);
		return driver.findElement(update_SuccToasterMsg).getText();
	}


	public void Validate_Deleteting_Projects_in_ViewProject_screen(String projectsStatus) throws InterruptedException
	{
		List<WebElement> statuses = driver.findElements(allProjectsStatuses);

		for(int k=0;k<statuses.size();k++)
		{
			String	allStatasusText=statuses.get(k).getText();

			if(allStatasusText.equals(projectsStatus))
			{

				List<WebElement> allCheckbx = driver.findElements(allCheckBoxes);
				Thread.sleep(2000);
				allCheckbx.get(k-1).click();
				Thread.sleep(1000);
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




	public boolean verifyDeleteButton_In_ViewProjects_screen() throws InterruptedException
	{
		Thread.sleep(1000);
		return driver.findElement(deleteButton).isEnabled();
	}

	public void perfornDeleteOperation()
	{
		driver.findElement(deleteButton).click();
	}

	public String verifyConfirmation_Popup() throws InterruptedException
	{
		Thread.sleep(2000);
		return driver.findElement(confirmationPopup_Header).getText();
	}
	public void clickOn_Okbutton() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(okButton_OnConfPopuop).click();
	}

	public String verifyErrorMessage() throws InterruptedException
	{
		Thread.sleep(2000);
		return driver.findElement(errorMsg).getText();
	}



	public void projectIDSearchField(String projectID) throws InterruptedException
	{
		driver.findElement(projectIDSearchField).sendKeys(projectID);
		Thread.sleep(1000);
	}
	public void clickOnSearchbtn() throws InterruptedException
	{
		driver.findElement(searchButton).click();
		Thread.sleep(2000);
	}

	public void	verifyProjectID_In_SearchTable(String projID) throws InterruptedException
	{
		List<WebElement> projectIDs = driver.findElements(allProjectID_ColumnData);	
		Thread.sleep(2000);
		List<WebElement> filteredRecords = verifySeachFilters_UsingStreams(projectIDs, projID);	
		Assert.assertEquals(projectIDs.size()-1, filteredRecords.size());
		System.out.println("Project ID Search Filter Records are Matching Perfectly....!!!!!");
	}


	public void projectNameSearchField(String projectname) throws InterruptedException
	{
		driver.findElement(projectNameSearchField).sendKeys(projectname);
		Thread.sleep(1000);
	}


	public void	verifyProjectNames_In_SearchTable(String projNames) throws InterruptedException
	{
		List<WebElement> projectIDs = driver.findElements(allProjectName_ColumnData);	
		Thread.sleep(2000);
		List<WebElement> filteredRecords = verifySeachFilters_UsingStreams(projectIDs, projNames);
		Assert.assertEquals(projectIDs.size()-1, filteredRecords.size());
		System.out.println("Project Name Search Filter Records are Matching Perfectly....!!!!!");
	}

	public void clienttNameSearchField(String clientname) throws InterruptedException
	{
		driver.findElement(clientNameSearchField).sendKeys(clientname);
		Thread.sleep(1000);
	}

	public void	verifyClientName_In_SearchTable(String clientName) throws InterruptedException
	{
		List<WebElement> clientNames = driver.findElements(allClientNames_ColumnData);	
		Thread.sleep(2000);
		List<WebElement> filteredRecords = verifySeachFilters_UsingStreams(clientNames, clientName);
		Assert.assertEquals(clientNames.size()-1, filteredRecords.size());
		System.out.println("Client Name Search Filter Records are Matching Perfectly....!!!!!");
	}

	public void projectStatusSearchField(String projectStatus) throws InterruptedException
	{
		WebElement projectstatusDrp = driver.findElement(projectStatusSearchDropdown);
		selectDropDownbyVisibleTest(projectstatusDrp, projectStatus);
		Thread.sleep(1000);
	}

	public void	verifyProjectStatus_In_SearchTable(String ProjectStatus) throws InterruptedException
	{
		List<WebElement> projectsStatuses = driver.findElements(allProjectsStatus_ColumnData);	
		Thread.sleep(2000);
		List<WebElement> filteredRecords = verifySeachFilters_UsingStreams(projectsStatuses, ProjectStatus);
		Assert.assertEquals(projectsStatuses.size()-1, filteredRecords.size());
		System.out.println("Project Status Search Filter Records are Matching Perfectly....!!!!!");
	}

	public void projectTypeSearchField(String projectType) throws InterruptedException
	{
		WebElement projectTypeDrp = driver.findElement(projectTypeSearchDropdown);
		selectDropDownbyVisibleTest(projectTypeDrp, projectType);
		Thread.sleep(1000);
	}

	public void	verifyProjectType_In_SearchTable(String ProjectType) throws InterruptedException
	{
		List<WebElement> projectsTypes = driver.findElements(allProjectsTypes_ColumnData);	
		Thread.sleep(2000);
		List<WebElement> filteredRecords = verifySeachFilters_UsingStreams(projectsTypes, ProjectType);
		Assert.assertEquals(projectsTypes.size()-1, filteredRecords.size());
		System.out.println("Project Type Search Filter Records are Matching Perfectly....!!!!!");
	}

	public void clickOn_ExportButton()
	{
		driver.findElement(exportButton).click();
	}

	public void download_ProjectsReport(String reportType) throws InterruptedException
	{
		Thread.sleep(1000);
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






}
