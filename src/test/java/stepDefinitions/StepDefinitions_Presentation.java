package stepDefinitions;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.Projects_ManageProjects;
import pageObjects.Projects_ProjectDeliverables;
import pageObjects.SOW_Manage_SOW;
import pageObjects.View_Client;

public class StepDefinitions_Presentation extends BaseTest{


	@Before
	public void setUp() throws IOException
	{
		driver=setUpDriver();
	}

	@After
	public void tearDown()
	{
		//driver.quit();
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

	@When("User is on {string} screen")
	public void user_is_on_screen(String expectedHeader) throws InterruptedException  {
		try
		{
			viewClient=new View_Client(driver);
			viewClient.click_on_ClientModule();
			String actulaHeader = viewClient.verifyClientScreenHeader();
			Assert.assertEquals(actulaHeader, expectedHeader);	
		}catch(Exception e)
		{

		}
	}

	@When("Clicks on add button")
	public void clicks_on_add_button() {
		viewClient.click_on_Add();
	}

	@Then("Verify the {string} header")
	public void verify_the_header(String header) {
		//		String headerOfScreen = viewClient.verifyAddClientScreen();
		//		Assert.assertEquals(headerOfScreen, header);
	}

	@When("User enters valid data {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_enters_valid_data_and(String clientName, String clientAddress, String countryDropDownText, String locationtext, String statusText, String startMonth, String startYear, String startingDate, String endMonth, String endYear, String endingDate, String descriptionText) throws InterruptedException {
		viewClient.createNew_Client(clientName, clientAddress, countryDropDownText, locationtext, statusText, startMonth, startYear, startingDate, endMonth, endYear, endingDate, descriptionText);


	}

	@When("Click on save button")
	public void click_on_save_button() {

		viewClient.clickonSaveButton();
	}

	@When("User clicks Ok on the Add Client confirmation popup")
	public void user_clicks_ok_on_the_add_client_confirmation_popup() throws InterruptedException {

		viewClient.clickonOkButtonOnPopup();
	}
	@Then("User should be displayed with  {string}")
	public void user_should_be_displayed_with(String expectedSucces_Msg) throws InterruptedException {

		String actualSuccesMsg = viewClient.verifyConfirmationMessage();
		Assert.assertEquals(actualSuccesMsg, expectedSucces_Msg);
	}

	@Then("User selects any of the {string}")
	public void user_selects_any_of_the(String clientName) {

		viewClient.selectingClientToUpdate(clientName);
	}
	@When("User Updates data {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_updates_data_and(String clientAddress, String countryDropDownText, String locationtext, String statusText, String startMonth, String startYear, String startingDate, String endMonth, String endYear, String endingDate, String descriptionText) throws InterruptedException {

		viewClient.updatingClientDetails(clientAddress,countryDropDownText,locationtext,statusText,startMonth,startYear,startingDate,endMonth,endYear,endingDate,descriptionText);

	}
	@When("User click on Update button")
	public void user_click_on_update_button() {

		viewClient.clickOnUpdateButton();
	}
	@When("User clicks Ok on the confirmation popup")
	public void user_clicks_ok_on_the_confirmation_popup() throws InterruptedException {

		viewClient.clickonOkButtonOnPopup();
	}
	@Then("User should be displayed with Successful message {string}")
	public void user_should_be_displayed_with_successful_message(String expectedMsg) throws InterruptedException {

		String actualMessage = viewClient.verifyUpdatedToasterMessage();
		Assert.assertEquals(actualMessage, expectedMsg);

	}


	@Then("User selects {string} status client")
	public void user_selects_status_client(String statusOfClient) throws InterruptedException {

		viewClient.Validate_DeletionOfClient_BasesOnStatus_in_Client_screen(statusOfClient);

	}

	@Then("Delete button should be gets enable")
	public void delete_button_should_be_gets_enable() {
		boolean deleteBtnStatus = viewClient.verifyDeleteButton();
		Assert.assertTrue(deleteBtnStatus);
	}
	@When("User perform delete operation")
	public void user_perform_delete_operation() {

		viewClient.performDeleteOperation();
	}

	@When("User selects {string} records")
	public void user_selects_records(String statusOfClient) throws InterruptedException {

		viewClient.Validate_DeletionOfClient_BasesOnStatus_in_Client_screen(statusOfClient);
	}
	@Then("Delete button should be disable")
	public void delete_button_should_be_disable() {
		boolean statusOf_DeleteBtn = viewClient.verifyDeleteButton();
		Assert.assertEquals(statusOf_DeleteBtn,false );

	}
	@Then("User should be displayed with {string} error message")
	public void user_should_be_displayed_with_error_message(String expectedErrorMsg) throws InterruptedException {

		String actualError_Message = viewClient.verifyErrorMessage();
		Assert.assertEquals(actualError_Message, expectedErrorMsg);

	}

	@When("User is on View Projects screen")
	public void user_is_on_view_projects_screen() throws InterruptedException {
		manageProjects=new Projects_ManageProjects(driver);
		manageProjects.clickOn_ProjectModule();
	}

	@When("Click on add button on View Projects screen")
	public void click_on_add_button_on_view_projects_screen() {

		manageProjects.click_onaddButton_In_ViewProject_Screen();
	}

	@Then("Verifys the {string} header")
	public void verifys_the_header(String exp_Header) {

		//	String actualHeader = manageProjects.verify_AddProject_screen();
		//	Assert.assertEquals(actualHeader, exp_Header);
	}

	@When("User enters valid data {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_enters_valid_data_and(String projectName, String clientName, String ProjectType, String ProjectStatus, String startMonth, String startYear, String startDate, String endMonth, String endYear, String endDate, String percentaOfCompletion, String ProjectAmount, String estimatedStaffHours, String actualStaffHours, String noOfResources, String description) throws InterruptedException {

		manageProjects.createNew_Project(projectName, clientName, ProjectType, ProjectStatus, startMonth, startYear, startDate, endMonth, endYear, endDate, percentaOfCompletion, ProjectAmount, estimatedStaffHours, actualStaffHours, noOfResources, description);
	}

	@When("Clicks on save button on View Projects screen")
	public void clicks_on_save_button_on_view_projects_screen() {

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

	@Then("User is be displayed with Successful message {string}")
	public void user_is_be_displayed_with_successful_message(String expUpdatedMsg) throws InterruptedException {

		String actUpdatedMsg = manageProjects.verifyUpdateSuccMessage();
		Assert.assertEquals(actUpdatedMsg, expUpdatedMsg);
	}



	@Then("User selects {string} record in View Projects screen")
	public void user_selects_record_in_view_projects_screen(String projectStatus) throws InterruptedException {

		manageProjects.Validate_Deleteting_Projects_in_ViewProject_screen(projectStatus);
	}
	@Then("Delete button should be get enable in View Projects screen")
	public void delete_button_should_be_get_enable_in_view_projects_screen() throws InterruptedException {
		boolean statusOfdeleteBtn = manageProjects.verifyDeleteButton_In_ViewProjects_screen();
		Assert.assertEquals(statusOfdeleteBtn, true);

	}
	@When("User perform delete operations in View Projects screen")
	public void user_perform_delete_operations_in_view_projects_screen() {

		manageProjects.perfornDeleteOperation();
	}
	@Then("User is displayed with Delete Project confirmation popup")
	public void user_is_displayed_with_delete_project_confirmation_popup() throws InterruptedException {

		String confirmationPopupText = manageProjects.verifyConfirmation_Popup();
		Assert.assertEquals(confirmationPopupText, "Delete Project");

	}
	@Then("User clicks Ok on Delete Project confirmation popup")
	public void user_clicks_ok_on_delete_project_confirmation_popup() throws InterruptedException {

		manageProjects.clickOn_Okbutton();
	}
	@Then("User is displayed with deleted Successful message {string}")
	public void user_is_displayed_with_deleted_successful_message(String string) {


	}

	/////////////////////////////////////////////////////

	@When("User selects {string} record")
	public void user_selects_record(String projectStatus) throws InterruptedException {

		manageProjects.Validate_Deleteting_Projects_in_ViewProject_screen(projectStatus);

	}
	@Then("Delete button should gets disable")
	public void delete_button_should_gets_disable() throws InterruptedException {

		boolean statusOfdeleteBtn = manageProjects.verifyDeleteButton_In_ViewProjects_screen();
		Assert.assertEquals(statusOfdeleteBtn, false);
	}
	@Then("User should be displayed with {string} error msg")
	public void user_should_be_displayed_with_error_msg(String expectedErrorMsg) throws InterruptedException {

		String actualErrorMsg = manageProjects.verifyErrorMessage();
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	}

	@When("User clicks on export button")
	public void user_clicks_on_export_button() {
		manageProjects.clickOn_ExportButton();
	}
	@When("User selects any {string} should download report file successfully")
	public void user_selects_any_should_download_report_file_successfully(String reportType) throws InterruptedException {
		manageProjects.download_ProjectsReport(reportType);
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
	
	@Then("User enters valid datas {string}, {string}, {string},{string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
	public void user_enters_valid_datas_and(String location, String departtment, String EmpName_ID, String resourceFuntion, String resourceType, String billRateType, String amountRate_USD, String statYear, String startMonth, String startDate, String endYear, String endMonth, String endDate, String estimatedQty, String actualQty, String percetageAllocation) throws InterruptedException {
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
		
	}
	
	@When("User is on View SOW screen")
	public void user_is_on_view_sow_screen() throws InterruptedException {
	   
		manageSow=new SOW_Manage_SOW(driver);
		manageSow.navigateTo_ManageSOWScreen();
		
	}
	
	@When("Clicks on Add button SOW")
	public void clicks_on_add_button_sow() {
		
		manageSow.clickOnAddBtn();
	}
	@Then("User is displayed with {string} screen")
	public void user_is_displayed_with_screen(String expectdHeader) {
		
		String actulaHeader = manageSow.verfyAddSOWScreen();
		Assert.assertEquals(actulaHeader, expectdHeader);
		
	}
	@When("User enters valid data {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, and  {string}")
	public void user_enters_valid_data_and(String SOWName, String clientNames, String sowValues, String sowTypes, String sowStatuses, String basises, String startMonth, String startYear, String startingDate, String endMonth, String endYear, String endingDate, String sowDescription, String filePath) throws InterruptedException, AWTException {
	   
		manageSow.createSOWRecord(SOWName,clientNames,sowValues, sowTypes, sowStatuses, basises, startMonth, startYear, startingDate, endMonth, endYear, endingDate, sowDescription, filePath);
	}
	@When("Click on ok button on the confirmation Popup")
	public void click_on_ok_button_on_the_confirmation_popup() throws InterruptedException {
	    
		manageSow.clickOnBtn_OnPopup();
	}
	@Then("User hould be displayed with {string}")
	public void user_hould_be_displayed_with(String exptSuccMessage) {
	   
		String actSuccMessage = manageSow.verifyToasterMsg();
		Assert.assertEquals(actSuccMessage, exptSuccMessage);
	}
	
	@When("User is on Search Projects screen")
	public void user_is_on_search_projects_screen() throws InterruptedException {
		
		projectDeliverables=new Projects_ProjectDeliverables(driver);
		
		projectDeliverables.navigateTo_searchProjectScreen();
	
	}
	
	@When("User selects respective {string}")
	public void user_selects_respective(String projectName) throws InterruptedException {
	   
		projectDeliverables.selectingProject(projectName);
	}
	
	
	@Then("Click on Add btn")
	public void click_on_add_btn() throws InterruptedException {
	   Thread.sleep(1000);
		projectDeliverables.clickOnAddButton();
	}
	@Then("User enters valid data {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void user_enters_valid_data(String Deliverables, String details, String status, String year, String month, String date, String act_Year, String act_Month, String act_Date) throws AWTException, InterruptedException {
	    
		projectDeliverables.creatingProjectDeliverables(Deliverables, details, status, year, month, date, act_Year, act_Month, act_Date);
	}
	
	@Then("Select the check box")
	public void select_the_check_box() {
		
		projectDeliverables.selectCheckbox();
		
	}
//	@Then("Click on save button")
//	public void click_on_save_button() throws InterruptedException {
//	   
//		//projectDeliverables.clickOnSaveButton();
//	}












}
