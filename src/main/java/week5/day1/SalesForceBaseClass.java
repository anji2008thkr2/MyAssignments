package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class SalesForceBaseClass {
	
	public RemoteWebDriver driver;
    
	@Parameters({"url","username","password"})
	@BeforeMethod()
	public void preCondition(String url,String userName, String password) {
		System.out.println(url + "--"+ userName + "--"  + password );
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
	
		By appLauncherIcon=By.xpath("//div[@class='slds-icon-waffle']");
		driver.findElement(appLauncherIcon).click();
	
  	  WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
  	   viewAll.click();
		
	}

	
	@AfterMethod()
	public void postCondition() {
		driver.quit();
	}
	

}
