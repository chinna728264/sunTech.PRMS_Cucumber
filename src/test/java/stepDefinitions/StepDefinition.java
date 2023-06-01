package stepDefinitions;

public class StepDefinition extends BaseTest {
	/*ArrayList<String> beforeSorting;
	
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

	//*****************************  1st Scenario ************************************
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
	
	//*****************************  2nd Scenario ************************************	
// ***************************** To Add Client Step Definitions ************************************
	
	@When("User is on {string} screen")
	public void user_is_on_screen(String expectedHeader) throws InterruptedException  {
		
		 viewClient=new View_Client(driver);
		 viewClient.click_on_ClientModule();
		 String actulaHeader = viewClient.verifyClientScreenHeader();
		 Assert.assertEquals(actulaHeader, expectedHeader);	
	}

	@When("Clicks on add button")
	public void clicks_on_add_button() {
		viewClient.click_on_Add();
	}

	@Then("Verify the {string} header")
	public void verify_the_header(String header) {
		String headerOfScreen = viewClient.verifyAddClientScreen();
		Assert.assertEquals(headerOfScreen, header);
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
	
	
	//*****************************  3rd Scenario ************************************
	
	
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
	
	
//******************** Done *****************************************	
	
	
	
	
	
	
	
	
	
	
	//-------------------------------------------------------------------------------------
	
	@Then("User selects {string} records")
	public void user_selects_records(String statusOfClient) throws InterruptedException {
		
	viewClient.Validate_DeletionOfClient_BasesOnStatus_in_Client_screen(statusOfClient);
		    
	}

	@Then("Delete button should be gets enable")
	public void delete_button_should_be_gets_enable() {
	
		boolean deleteBtnStatus = viewClient.verifyDeleteButton();
		Assert.assertTrue(deleteBtnStatus);
	}
	
	@When("User perform delete operation")
	public void user_perform_delete_operation() {
	    
	}

	//Sorting Scenario
	
	
	
	@Then("Verify the recods")
	public void verify_the_recods() throws InterruptedException {
	 
//		 beforeSorting = viewClient.beforeSorting_ClientNames_Data_in_Client_table_of_ClientName();
//		System.out.println(beforeSorting.size());
//		Collections.sort(beforeSorting);
//		System.out.println("Before Sorting Records"+beforeSorting);
		viewClient.verifySotingOperation();
		viewClient.test1();

	}
	@Then("Click on Sort icon on Client Name")
	public void click_on_sort_icon_on_client_name() throws InterruptedException {
	
		//viewClient.clickOnClientColumn();
	}
	@Then("All the Client Name recods Should be sorted based on the Alphabet\\/numbers values in ascending order")
	public void all_the_client_name_recods_should_be_sorted_based_on_the_alphabet_numbers_values_in_ascending_order() throws InterruptedException, IOException {
	   
//		ArrayList<String> AfterSorting = viewClient.afterSorting_ClientNames_Data_in_Client_table_of_ClientName();
//		//ArrayList<String> AfterSorting=viewClient.test2();
//		System.out.println(AfterSorting.size());
//		System.out.println("After Sorting Records"+AfterSorting);
//		Assert.assertEquals(beforeSorting, AfterSorting);
//		System.out.println("Test Pass");
	}
	
	
	
	//*****************************  Search Filters *************************
	@When("User enters client name {string}")
	public void user_enters_client_name(String ClientName) {
		viewClient.clientNameSearch(ClientName);
	}
	@When("Clicks on search button")
	public void clicks_on_search_button() throws InterruptedException {
		viewClient.clickOnSearchbtn();
		Thread.sleep(2000);
	}
	@Then("User should found client name {string} in Search table")
	public void user_should_found_client_name_in_search_table(String ClienName) throws InterruptedException {
		viewClient.verifyClientName_in_SearchTable(ClienName);
		
	}
	@Then("Click on reset button")
	public void click_on_reset_button() {
	    
	}
	
	
	@When("User enters client ID {string}")
	public void user_enters_client_id(String ClientID) {
		viewClient.clientID_search(ClientID);
	}
	@Then("User should found only one client ID {string} in Search table")
	public void user_should_found_only_one_client_id_in_search_table(String ClientID) throws InterruptedException {
	    viewClient.verifyClientID_in_SearchTable(ClientID);
	}
	
	@Then("Filters should gets reset")
	public void filters_should_gets_reset() {
	    
	}
	
	
	@When("User selects respective {string} filter")
	public void user_selects_respective_filter(String status) {
	  
		viewClient.clientStatus_search(status);
	}
	@Then("User should found all {string} in Search table")
	public void user_should_found_all_in_search_table(String status) throws InterruptedException {
	   
		viewClient.verifyClientStatus_in_SearchTable(status);
	}
	
//**************************** Search Scenarios Done *****************************

	
	
	// Unable to Deleting some status data 
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
	
	//**************************************
	
	@When("User clicks on export button")
	public void user_clicks_on_export_button() {
		viewClient.clickOn_ExportButton();
	}
	
	@When("User selects any {string} should download report file successfully")
	public void user_selects_any_should_download_report_file_successfully(String reportType) {
		viewClient.download_ClientModuleReport(reportType);
	}*/



}
