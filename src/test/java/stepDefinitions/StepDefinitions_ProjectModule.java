package stepDefinitions;

public class StepDefinitions_ProjectModule extends BaseTest{
	
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
	
	@When("User is on View Projects screen")
	public void user_is_on_view_projects_screen() throws InterruptedException {
		manageProjects=new Projects_ManageProjects(driver);
		manageProjects.clickOn_ProjectModule();
	}
	@When("Clicks on add button")
	public void clicks_on_add_button() {
		manageProjects.click_onaddButton_In_ViewProject_Screen();
	}
	@Then("Verify the {string} header")
	public void verify_the_header(String exp_Header) {
		String actualHeader = manageProjects.verify_AddProject_screen();
		Assert.assertEquals(actualHeader, exp_Header);
	}
	
	@When("User enters valid data {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_enters_valid_data_and(String projectName, String clientName, String ProjectType, String ProjectStatus, String startMonth, String startYear, String startDate, String endMonth, String endYear, String endDate, String percentaOfCompletion, String ProjectAmount, String estimatedStaffHours, String actualStaffHours, String noOfResources, String description) throws InterruptedException {
		
		manageProjects.createNew_Project(projectName, clientName, ProjectType, ProjectStatus, startMonth, startYear, startDate, endMonth, endYear, endDate, percentaOfCompletion, ProjectAmount, estimatedStaffHours, actualStaffHours, noOfResources, description);
	}
	@When("Click on save button")
	public void click_on_save_button() {
		
		manageProjects.clickOn_SaveButton();
	}
	
	@When("User clicks Ok on Add Project confirmation popup")
	public void user_clicks_ok_on_add_project_confirmation_popup() throws InterruptedException {
		manageProjects.clickonOkButtonOn_ConfrmPopup();
	}
	@Then("User is displayed with Successful message {string}")
	public void user_is_displayed_with_successful_message(String expectedSuccessMsg) {
	    
		String actualSuccessMsg = manageProjects.verifyAddProjectSuccessMsg();
		Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg);
	}
	
	
	@When("Select any of the Project {string}")
	public void select_any_of_the_project(String projectName) {
	   
		manageProjects.selectingTheProjectToUpdate(projectName);
		
	}
	@When("User Updates valid data {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_updates_valid_data_and(String project_type, String projectstatus, String startMonth, String startYear, String startingDate, String endMonth, String endYear, String endingDate, String completionPercentage, String amount, String estimated_HRS, String actual_HRS, String numberOfResources, String proj_Description) throws InterruptedException {
	   
		manageProjects.updatingProjectDetails( project_type, projectstatus, startMonth, startYear, startingDate, endMonth, endYear, endingDate, completionPercentage, amount, estimated_HRS, actual_HRS, numberOfResources, proj_Description);
	}
	@When("User Clicks on Update button")
	public void user_clicks_on_update_button() {
	    
		manageProjects.clickOnUpdateButton();
	}
	
	@When("User clicks Ok on Update Project confirmation popup")
	public void user_clicks_ok_on_update_project_confirmation_popup() throws InterruptedException {
		
		manageProjects.clickonOkButtonOn_ConfrmPopup();
	}
	@Then("User should be displayed with Successful message {string}")
	public void user_should_be_displayed_with_successful_message(String expUpdatedMsg) throws InterruptedException {
	    
		String actUpdatedMsg = manageProjects.verifyUpdateSuccMessage();
		Assert.assertEquals(actUpdatedMsg, expUpdatedMsg);
		
	}
	
	
	
	@Then("User selects {string} records")
	public void user_selects_records(String projectStatus) throws InterruptedException {
	   
		manageProjects.Validate_Deleteting_Projects_in_ViewProject_screen(projectStatus);
	}
	@Then("Delete button should be gets enable")
	public void delete_button_should_be_gets_enable() {
	   
		boolean statusOfdeleteBtn = manageProjects.verifyDeleteButton_In_ViewProjects_screen();
		Assert.assertEquals(statusOfdeleteBtn, true);
		
	}
	@When("User perform delete operation")
	public void user_perform_delete_operation() {
		manageProjects.perfornDeleteOperation();
	}
	
	@Then("User is displayed with Delete Project confirmation popup")
	public void user_is_displayed_with_delete_project_confirmation_popup() throws InterruptedException {
		String confirmationPopupText = manageProjects.verifyConfirmation_Popup();
		Assert.assertEquals(confirmationPopupText, "Delete Project");
	}
	@Then("Click on ok button")
	public void click_on_ok_button() throws InterruptedException {
		//manageProjects.clickOn_Okbutton();
	}
	
//********************************************************************************************************************
	
	
	@Then("Delete button should be disable")
	public void delete_button_should_be_disable() {
		boolean statusOfdeleteBtn = manageProjects.verifyDeleteButton_In_ViewProjects_screen();
		Assert.assertEquals(statusOfdeleteBtn, false);
		
		
	}
	@Then("User should be displayed with {string} error message")
	public void user_should_be_displayed_with_error_message(String expectedErrorMsg) throws InterruptedException {
	    
		String actualErrorMsg = manageProjects.verifyErrorMessage();
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	}
	
//************************************************************************************************
	
	@When("User enters project ID {string}")
	public void user_enters_project_id(String projectID) throws InterruptedException {
		manageProjects.projectIDSearchField(projectID);
	}
	
	@When("Clicks on search button")
	public void clicks_on_search_button() throws InterruptedException {
		
		manageProjects.clickOnSearchbtn();
	    
	}
	@Then("User should found client name {string} in Search table")
	public void user_should_found_client_id_in_search_table(String ProjIDS) throws InterruptedException {
		manageProjects.verifyProjectID_In_SearchTable(ProjIDS);
	}
	@Then("Click on reset button")
	public void click_on_reset_button() {
	    
	}
	
	@When("User enters project Name {string}")
	public void user_enters_project_name(String projectName) throws InterruptedException {
	    
		manageProjects.projectNameSearchField(projectName);
	}
	@Then("User should found project name {string} in Search table")
	public void user_should_found_project_name_in_search_table(String projectName) throws InterruptedException {
	    
		manageProjects.verifyProjectNames_In_SearchTable(projectName);
	}
	
	@When("User enters Client Name {string}")
	public void user_enters_client_name(String clientName) throws InterruptedException {
		manageProjects.clienttNameSearchField(clientName);
		
	}
	@Then("User should found Client name {string} in Search table")
	public void user_should_found_client_name_in_search_table(String clientName) throws InterruptedException {
		manageProjects.verifyClientName_In_SearchTable(clientName);
	}
	
	@When("User selects respective {string} filter")
	public void user_selects_respective_filter(String projectStatus) throws InterruptedException {
		manageProjects.projectStatusSearchField(projectStatus);
		
	}
	@Then("User should found all {string} in Search table")
	public void user_should_found_all_in_search_table(String projectStatus) throws InterruptedException {
		manageProjects.verifyProjectStatus_In_SearchTable(projectStatus);
	    
	}
	@Then("Filters should gets reset")
	public void filters_should_gets_reset() {
	    
		
	}
	
	
	@When("User selects respective project type {string} filter")
	public void user_selects_respective_project_type_filter(String projectType) throws InterruptedException {
	 
		manageProjects.projectTypeSearchField(projectType);
	}
	
	@Then("User should found all project type {string} in Search table")
	public void user_should_found_all_project_type_in_search_table(String projectType) throws InterruptedException {
		manageProjects.verifyProjectType_In_SearchTable(projectType);
		
	}
	
	@When("User clicks on export button")
	public void user_clicks_on_export_button() {
		manageProjects.clickOn_ExportButton();
	}
	@When("User selects any {string} should download report file successfully")
	public void user_selects_any_should_download_report_file_successfully(String reportType) throws InterruptedException {
		manageProjects.download_ProjectsReport(reportType);
	}*/

}
