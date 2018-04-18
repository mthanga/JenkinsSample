package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Search {

	//public static WebDriver driver;
	public static WebDriver driver;
	@BeforeSuite
	public void initialise(){
		try{
			//System.setProperty("webdriver.chrome.driver", "/home/ionixx/workspace/JenkinsSample/chromedriver/chromedriver_linux");
			
			//driver = new ChromeDriver();
			driver = new HtmlUnitDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://ec2-52-87-156-174.compute-1.amazonaws.com/IX/#/");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void execute(){
		try{
			Thread.sleep(5000);
			driver.findElement(By.id("name_field")).sendKeys("multiuser1");
			driver.findElement(By.id("password")).sendKeys("Espresso@1");
			driver.findElement(By.id("login_btn")).click();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void quite(){
		try{
			driver.quit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
