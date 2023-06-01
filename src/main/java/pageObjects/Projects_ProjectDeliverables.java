package pageObjects;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.AbstractComponents;

public class Projects_ProjectDeliverables extends AbstractComponents{

	WebDriver driver;
	public Projects_ProjectDeliverables(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}

	By projectsModule=By.xpath("(//a[@data-toggle='dropdown'])[3]");
	By projectsDeliverables=By.cssSelector("a[routerlink='/viewDeliverables']");

	By searchProjctScreen=By.cssSelector("h4[id='page-heading'] span");
	By allProjectNames=By.cssSelector("div[col-id='projectName']");
	By nextButton=By.cssSelector("div[aria-label='Next Page']");
	By addButton=By.cssSelector("button[type='add']");
	By deliverables=By.xpath("//div[@class='ag-cell ag-cell-normal-height ag-cell-value ag-cell-not-inline-editing']");
	By details=By.xpath("(//div[@role='gridcell'])[3]");
	By status=By.xpath("(//div[@role='gridcell'])[4]");
	By statusDropDown=By.id("ddlViewBy");
	By estimationOfCompletionDate=By.className("ag-cell-focus");
	By actualCompletionDate=By.className("ag-cell-focus");
	By selectingAllCheckBoxes=By.xpath("(//div[@ref='eWrapper'])[1]");

	By monthandYeaBtns=By.id("mat-calendar-button-0");
	By allYears=By.xpath("//td[@role='gridcell']/button/div[1]");
	By allMonths=By.xpath("//div[@class='mat-calendar-body-cell-content mat-focus-indicator']|//div[@class='mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-today']");
	By allDates=By.cssSelector("td[role='gridcell']");

	By act_monthandYeaBtn_actCmpDtPic=By.id("mat-calendar-button-2");
	By saveBtn=By.cssSelector("button[type='save']");
	By deliverablesScreenHeader=By.cssSelector("h4[id='page-heading'] span");
	By checkBoxes=By.xpath("//div[@ref='eCellWrapper']//div[2]");



	String projectNamesText;
	List<WebElement> proj;



	public void navigateTo_searchProjectScreen() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(projectsModule).click();
		driver.findElement(projectsDeliverables).click();

	}

	
	public void selectingProject(String projectName) throws InterruptedException
	{
				List<WebElement> projectNames = driver.findElements(allProjectNames);

				for(int i=1;i<projectNames.size();i++)
				{	
					projectNamesText = projectNames.get(i).getText();

					if(projectNamesText.equalsIgnoreCase(projectName))
					{
						 projectNames.get(i).click();
						break;
					}
				}	
	}


	public void clickOnAddButton() throws InterruptedException
	{
		driver.findElement(addButton).click();
		Thread.sleep(1000);
	}

	public String verifyDeliverablesScreenHeader()
	{
		return driver.findElement(deliverablesScreenHeader).getText();
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
	public void creatingProjectDeliverables(String projDeliverables,String deliverableDetails,String projDeliverableStatus,
			String year,String month, String date,String act_Year,String act_Month, String act_Date) throws AWTException, InterruptedException
	{

		
		Thread.sleep(2000);
		clickOnCheckBox();
		WebElement pr_Deliv = driver.findElement(deliverables);
		pr_Deliv.click();
		//driver.findElement(deliverables)
		pr_Deliv.sendKeys(projDeliverables,Keys.ENTER);
		
		WebElement pr_DelDetails = driver.findElement(details);
		pr_DelDetails.click();
		pr_DelDetails.sendKeys(deliverableDetails);
		driver.findElement(status).click();
		Thread.sleep(2000);
		WebElement projStausDrp = driver.findElement(statusDropDown);
		selectDropDownbyVisibleTest(projStausDrp, projDeliverableStatus);
		estimationOfCompletionDate_Month_and_Year(year, month, date);
		actualCompletionDate_Month_and_Year(act_Year, act_Month, act_Date);


	}

	public void estimationOfCompletionDate_Month_and_Year(String year,String month, String date) throws InterruptedException
	{
		driver.findElement(estimationOfCompletionDate).click();
		Thread.sleep(1000);
		driver.findElement(monthandYeaBtns).click();


		List<WebElement> years = driver.findElements(allYears);

		for(int y=0;y<years.size();y++)
		{

			String allYearsText = years.get(y).getText();

			if(allYearsText.equalsIgnoreCase(year))
			{
				years.get(y).click();
				break;
			}
		}

		Thread.sleep(1000);	
		List<WebElement> months = driver.findElements(allMonths);

		for(int m=0;m<months.size();m++)
		{
			Thread.sleep(1000);
			String allMonthsText = months.get(m).getText();

			if(allMonthsText.equalsIgnoreCase(month))
			{
				years.get(m).click();
				break;
			}
		}

		Thread.sleep(1000);	
		List<WebElement> dates = driver.findElements(allDates);

		for(int d=0;d<dates.size();d++)
		{
			Thread.sleep(1000);
			String allDatesText = dates.get(d).getText();

			if(allDatesText.equalsIgnoreCase(date))
			{
				years.get(d).click();
				break;
			}
		}

	}

	public void actualCompletionDate_Month_and_Year(String act_Year,String act_Month, String act_Date) throws InterruptedException
	{

		driver.findElement(actualCompletionDate).click();
		Thread.sleep(1000);
		driver.findElement(act_monthandYeaBtn_actCmpDtPic).click();
		Thread.sleep(1000);

		List<WebElement> years = driver.findElements(allYears);

		for(int y=0;y<years.size();y++)
		{
			Thread.sleep(1000);
			String allYearsText = years.get(y).getText();

			if(allYearsText.equalsIgnoreCase(act_Year))
			{
				years.get(y).click();
				break;
			}
		}
		Thread.sleep(1000);	
		List<WebElement> months = driver.findElements(allMonths);

		for(int m=0;m<months.size();m++)
		{
			Thread.sleep(1000);
			String allMonthsText = months.get(m).getText();

			if(allMonthsText.equalsIgnoreCase(act_Month))
			{
				years.get(m).click();
				break;
			}
		}

		Thread.sleep(1000);	
		List<WebElement> dates = driver.findElements(allDates);

		for(int d=0;d<dates.size();d++)
		{
			Thread.sleep(1000);
			String allDatesText = dates.get(d).getText();

			if(allDatesText.equalsIgnoreCase(act_Date))
			{
				years.get(d).click();
				break;
			}
		}

	}



	public void selectCheckbox()
	{
		driver.findElement(selectingAllCheckBoxes).click();
	}
	public void clickOnSaveButton() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(saveBtn).click();
	}


}
