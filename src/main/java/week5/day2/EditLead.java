package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class EditLead extends ProjectSpecificMethods{

	@Test(dataProvider="editLead")
	public void editLead(String phoneNumber,String compName) throws InterruptedException {
		System.out.println("Phone number :"+phoneNumber + "companyName :"+compName);
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(compName);
		driver.findElement(By.name("submitButton")).click();
		driver.close();
}
	
	
	@DataProvider(name="editLead")
	public String[][] editLeadTestData() {
		
		String [][] data=new String[2][2];
		data[0][0]="9876543210";
		data[0][1]="Microsoft";
		
		data[1][0]="9876543654";
		data[1][1]="google";
		
		return data;
		
		
	}
	
}






