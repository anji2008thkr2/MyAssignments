package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CRM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("testLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Anjali");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("thakkar");
		
		WebElement sourceDD = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select s = new Select(sourceDD);
		s.selectByIndex(4);

		WebElement marketingCampain = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select s1 = new Select(marketingCampain);
		s1.selectByVisibleText("Automobile");
		
		WebElement ownership = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select s2 = new Select(ownership);
		s2.selectByValue("OWN_SCORP");
		
		driver.findElement(By.name("submitButton")).click();
		
		driver.getTitle();
		System.out.println(driver.getTitle());
		
		driver.close();
		
		
		




		
		
		
		
		
		

	}

}
