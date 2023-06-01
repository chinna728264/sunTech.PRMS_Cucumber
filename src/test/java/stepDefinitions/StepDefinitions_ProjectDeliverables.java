package stepDefinitions;

public class StepDefinitions_ProjectDeliverables extends BaseTest {
	
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
		
		projectDeliverables=new Projects_ProjectDeliverables(driver);
		
		projectDeliverables.navigateTo_searchProjectScreen();
	
	}
	
	@When("User selects respective {string}")
	public void user_selects_respective(String projectName) throws InterruptedException {
	   
		projectDeliverables.selectingProject(projectName);
	}
	@Then("User should be navigated to {string} screen")
	public void user_should_be_navigated_to_screen(String expectedHeader) {
		String actualHeader = projectDeliverables.verifyDeliverablesScreenHeader();
		//Assert.assertEquals(actualHeader, expectedHeader);
		
	}
	@Then("Click on Add button")
	public void click_on_add_button() throws InterruptedException {
	   
		//projectDeliverables.clickOnAddButton();
	}
	@Then("User enters valid data {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void user_enters_valid_data(String Deliverables, String details, String status, String year, String month, String date, String act_Year, String act_Month, String act_Date) throws AWTException, InterruptedException {
	    
		//projectDeliverables.creatingProjectDeliverables(Deliverables, details, status, year, month, date, act_Year, act_Month, act_Date);
	}
	
	@Then("Select the check box")
	public void select_the_check_box() {
		
		//projectDeliverables.selectCheckbox();
		
	}
	@Then("Click on save button")
	public void click_on_save_button() throws InterruptedException {
	   
		//projectDeliverables.clickOnSaveButton();
	}*/

}
