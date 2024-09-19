package week5.day1.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class CreateLead extends ProjectSpecificMethods {
     
	@Test(dataProvider="createLeadTestData")
	public void createLead(String companyName,String fname,String lname)  {
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.name("submitButton")).click();}
	
	
	@DataProvider
	public String[][] createLeadTestData() {
		
		String[][] data=new String[2][3];
		data[0][0]="TestLeaf";
		data[0][1]="Anjali";
		data[0][2]="Thakkar";
		
		data[1][0]="Qeagle";
		data[1][1]="John";
		data[1][2]="Cena";
		 return data;
	}
}






