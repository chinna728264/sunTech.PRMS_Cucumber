package stepDefinitions;

public class StepDefinitions_Resource extends BaseTest{
	
	/*@Before
	public void setUp() throws IOException
	{
		driver=setUpDriver();
	}
	
	@Given("User is on PRMS landing page")
	public void user_is_on_prms_landing_page() throws IOException {
		
		loginPage=new LoginPage(driver);
		loginPage.goTo();
	}

	@When("User enters valid {string} and {string}")
	public void user_enters_valid_and(String UserName, String Password) {
	
		loginPage.landingPage(UserName, Password);
				
	}
	
	@Then("Verify the title of page {string}")
	
	public void verify_the_title_of_page(String title) throws InterruptedException {	
		Thread.sleep(2000);	
		if(driver.getPageSource().contains("Invalid Credentials"))
		{
			System.out.println("Invalid Credentials Please Try Again !!!!!!!!!!!!!!!");
			driver.quit();
			Assert.assertTrue(false);
			
		}
		else
		{
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@And("Successful toaster message should be displayed {string}")
	public void successful_toaster_message_should_be_displayed(String toasterMsg) throws InterruptedException {
		Thread.sleep(2000);	
		String successfullMsg = loginPage.verfySuccessfulMsg();
		Assert.assertEquals(toasterMsg, successfullMsg);
	}
	

	@When("User is on Search Projects screen")
	public void user_is_on_search_projects_screen() throws InterruptedException {
	   
		resource=new Resource(driver);
		resource.clickOnResourceModule();
		String searchProj_Header = resource.verify_SearchProjectHeader();
		Assert.assertEquals(searchProj_Header, "Search Project");
	}

	@When("User selects any of the {string}")
	public void user_selects_any_of_the(String projectName) {
		resource.selectProject(projectName);
	}
	
	@Then("User should be navigated to {string} screen")
	public void user_should_be_navigated_to_screen(String expectedHeader) {
	    
		String actual_Header = resource.verify_ResourceAllocation_Header();
		//Assert.assertEquals(actual_Header, expectedHeader);
	}
	@Then("Click on Add button")
	public void click_on_add_button() throws InterruptedException {
	   
		resource.clickOn_AddButton();
	}
	
	@Then("User enters valid data {string}, {string}, {string},{string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
	public void user_enters_valid_data_and(String location, String departtment, String EmpName_ID, String resourceFuntion, String resourceType, String billRateType, String amountRate_USD, String statYear, String startMonth, String startDate, String endYear, String endMonth, String endDate, String estimatedQty, String actualQty, String percetageAllocation) throws InterruptedException {
		resource.addingResouces(location,departtment,EmpName_ID,resourceFuntion,resourceType,billRateType,amountRate_USD,statYear,startMonth,startDate,endYear,endMonth,endDate,estimatedQty,actualQty,percetageAllocation);
		
	}
	

	@When("User selects  {string}")
	public void user_selects(String projectName) throws InterruptedException {
		resource.selectingTheProject_To_Update(projectName);
		
	}
	
	@When("User Updates dates data {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
	public void user_updates_dates_data_and(String EmployeeName_or_ID,String resourceFunction,String resourceType,String billRateType,String amountRate_USD,String statYear,String startMonth,String startDate,String endYear,String endMonth,String endDate,String estimated_Qty,String actual_Qty,String percetage_Allocation) throws InterruptedException {
	    
		resource.verifyTheEmployeeAndUpdateDetails(EmployeeName_or_ID, resourceFunction, resourceType, billRateType, amountRate_USD, statYear, startMonth, startDate, endYear, endMonth, endDate, estimated_Qty, actual_Qty, percetage_Allocation);
	}
	
	@When("User selects {string} to delete")
	public void user_selects_to_delete(String projectName) throws InterruptedException {
	   
		resource.selectingTheProject_To_Delete(projectName);
	}
	
	@When("User deletes particualar employees from project {string}")
	public void user_deletes_particualar_employees_from_project(String EmployeeName_Or_ID) throws InterruptedException {
		resource.verifyingTheEmployee_and_Deleting(EmployeeName_Or_ID);
	}
	@Then("User is displayed with {string} message")
	public void user_is_displayed_with_message(String expectedMsg) throws InterruptedException {
		String actualMsg = resource.verifyDeletionToasterMessage();
		Assert.assertEquals(actualMsg, expectedMsg);
		
	}*/
	
}
