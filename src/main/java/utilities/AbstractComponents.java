package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void selectDropDownbyVisibleTest(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public void selectDropDownbyValue(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(value);
	}
	
	public void selectDropDownbyIndex(WebElement element,String index)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(index);
	}
	
	public String getSelectOptioninDropdown(WebElement element)
	{
		Select sel=new Select(element);
		WebElement currentYear = sel.getFirstSelectedOption();
		String yearText = currentYear.getText();
		return yearText;
	}
	
	public void moveToElement_and_Click(WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		act.click();
	}
	
	public void waitElement(WebElement element,long timeOutInSeconds)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
	public List<WebElement> verifySeachFilters_UsingStreams(List<WebElement> element,String filterName)
	{
		List<WebElement> filteredList = element.stream().filter(name->name.getText().contains(filterName)).collect(Collectors.toList());
		return filteredList;
	}
	
	public void uploadFile(String filePath) throws AWTException, InterruptedException
	{
		Robot rb=new Robot();
		rb.delay(1000);
		
		StringSelection sel=new StringSelection(filePath);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	
	}
	
	public void JsClickElement(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	//To Scrool left based on x and y axes
	public void scrollChildWidow(String querySelctor)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(querySelctor);
	}
	
	//public void scr

}
