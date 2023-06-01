package cucumberOptions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import stepDefinitions.BaseTest;

public class Hooks {

	BaseTest test=new BaseTest();


	@After
	public void testStatus(Scenario scenario) throws IOException
	{

		if(scenario.isFailed()){
			try	{
				String failedScaenarioname = scenario.getName();
				System.out.println(failedScaenarioname+"  is Failed");
				TakesScreenshot ts= (TakesScreenshot)test.driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				File dest=new File(".\\Screenshots\\FailedTest_Screenshot.png");
				Files.copy(src, dest);
			}
			catch(Exception e)
			{

			}
		}

		else
		{

			try	{
				String passedScaenarioname = scenario.getName();
				System.out.println(passedScaenarioname+"  is Passed");
				TakesScreenshot ts= (TakesScreenshot)test.driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				File dest=new File(".\\Screenshots\\PassedTest_Screenshot.png");
				Files.copy(src, dest);
			}
				catch(Exception e)
				{
					
				}
			}
		
	}


}
