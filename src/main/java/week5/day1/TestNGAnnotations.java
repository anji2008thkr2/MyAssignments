package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGAnnotations extends SalesForceBaseClass {

  @DataProvider
  public String[][] getLegalEntityName() {
	  
	  return new String[][] {{"John doe"},{"Sam Willis"} };
	  
  }
	
	@Test(dataProvider="getLegalEntityName")
	public void addLegalEntitiesTest(String legalName) {
		Actions action=new Actions(driver);
        WebElement legalEntity=driver.findElement(By.xpath("//a[@data-label='Legal Entities']"));
		action.scrollToElement(legalEntity).moveToElement(legalEntity).click().perform();
		//elementToBeVisible(driver, legalEntity, 30).click();

		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		WebElement legalEntityName = driver.findElement(By.xpath("//label[text()='Legal Entity Name']/following-sibling::div"));
		legalEntityName.sendKeys(legalName);

		WebElement companyName = driver.findElement(By.xpath("//input[@name='CompanyName']"));
		companyName.sendKeys("TestLeaf");

		WebElement description = driver.findElement(By.xpath("//label[text()='Description']/following-sibling::div/textarea"));
		action.scrollToElement(description).perform();
		elementToBeClicakable(driver, description, 20).sendKeys("Salesforces");



		WebElement statusDD=driver.findElement(By.xpath("//label[text()='Status']//following::button"));
		//  action.scrollToElement(statusDD).moveToElement(statusDD).click(statusDD).perform();
		//  elementToBeClicakable(driver, statusDD, 30).click();
		driver.executeScript("arguments[0].click();",statusDD);

		WebElement activeBtn=driver.findElement(By.xpath("//span[text()='Active']"));
		action.scrollToElement(activeBtn).moveToElement(activeBtn).click(activeBtn).perform();
		//action.scrollToElement(activeBtn).click().perform();
		//elementToBeVisible(driver, activeBtn, 30).click();

		WebElement saveBtn=driver.findElement(By.xpath("//button[text()='Save']"));
		action.click(saveBtn).perform();
 }





	@Test(enabled=false)
	public void legalEntitiesErrorValidation() {
		Actions action=new Actions(driver);

		WebElement legalEntity=driver.findElement(By.xpath("//a[@data-label='Legal Entities']"));
		action.scrollToElement(legalEntity).moveToElement(legalEntity).click().perform();
		//elementToBeVisible(driver, legalEntity, 30).click();

		driver.findElement(By.xpath("//div[@title='New']")).click();

		WebElement companyName = driver.findElement(By.xpath("//input[@name='CompanyName']"));
		companyName.sendKeys("TestLeaf");

		WebElement description = driver.findElement(By.xpath("//label[text()='Description']/following-sibling::div/textarea"));
		action.scrollToElement(description).perform();
		elementToBeClicakable(driver, description, 20).sendKeys("Salesforces");



		WebElement statusDD=driver.findElement(By.xpath("//label[text()='Status']//following::button"));
		//  action.scrollToElement(statusDD).moveToElement(statusDD).click(statusDD).perform();
		//  elementToBeClicakable(driver, statusDD, 30).click();
		driver.executeScript("arguments[0].click();",statusDD);

		WebElement activeBtn=driver.findElement(By.xpath("//span[text()='Active']"));
		action.scrollToElement(activeBtn).moveToElement(activeBtn).click(activeBtn).perform();
		//action.scrollToElement(activeBtn).click().perform();
		//elementToBeVisible(driver, activeBtn, 30).click();

		WebElement saveBtn=driver.findElement(By.xpath("//button[text()='Save']"));
		action.click(saveBtn).perform();

		String text = driver.findElement(By.xpath("//div[@class='fieldLevelErrors']")).getText();

		System.out.println(text);}



	public static WebElement elementToBeClicakable(WebDriver driver,By xpath,int duration) {
		return new WebDriverWait(driver,Duration.ofSeconds(duration))
				.until(ExpectedConditions.elementToBeClickable(xpath));
	}

	public static WebElement elementToBeClicakable(WebDriver driver,WebElement xpath,int duration) {
		return new WebDriverWait(driver,Duration.ofSeconds(duration))
				.until(ExpectedConditions.elementToBeClickable(xpath));
	}


	public static WebElement elementToBeVisible(WebDriver driver,WebElement xpath,int duration) {
		return new WebDriverWait(driver,Duration.ofSeconds(duration))
				.until(ExpectedConditions.visibilityOf(xpath));

	}



}
