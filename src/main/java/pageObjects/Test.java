package pageObjects;

import java.awt.AWTException;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Test {

	public static void main(String[] args) throws AWTException, InterruptedException {
		
	
WebDriver driver=new EdgeDriver();
driver.manage().window().maximize();
driver.get("https://www.google.co.in/");

Thread.sleep(3000);

List<WebElement> lang = driver.findElements(By.xpath("//div[@class='gb_u gb_v']/a"));

List<WebElement> lanuage = lang.stream().filter(s->s.getText().equalsIgnoreCase("Gmail")).collect(Collectors.toList());

lanuage.get(0).click();

	
	}
}
