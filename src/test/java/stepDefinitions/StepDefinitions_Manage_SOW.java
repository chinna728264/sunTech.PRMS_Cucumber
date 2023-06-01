package stepDefinitions;

public class StepDefinitions_Manage_SOW extends BaseTest{

	
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
	
	
	@When("User is on View SOW screen")
	public void user_is_on_view_sow_screen() throws InterruptedException {
	   
		manageSow=new SOW_Manage_SOW(driver);
		manageSow.navigateTo_ManageSOWScreen();
		
	}
	
	@When("Clicks on Add button")
	public void clicks_on_add_button() {
		
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
	}*/

	
}
