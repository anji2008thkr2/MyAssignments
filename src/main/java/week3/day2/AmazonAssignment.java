package week3.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonAssignment {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


		WebElement element = driver.findElement(By.xpath("//input[@name='field-keywords']"));
		element.sendKeys("oneplus 9 pro"+Keys.ENTER);

		String price=driver.findElement(By.xpath("(//div[@data-cy=\"price-recipe\"]//span[@class=\"a-price-whole\"])[1]")).getText().replace(",", "");
		System.out.println("Price..."+price);

		String noOfRatings=driver.findElement(By.xpath("(//span[@class=\"a-size-base s-underline-text\"])[1]")).getText();
		System.out.println("No of Ratings..."+noOfRatings);

		WebElement textLink =	driver.findElement(By.xpath("(//span[@class=\"a-size-medium a-color-base a-text-normal\"])[1]"));

		Actions action=new Actions(driver);
		action.moveToElement(textLink).click().perform();
		
		Set<String> allWindows= driver.getWindowHandles();
		
		Iterator<String> iterator = allWindows.iterator();
		
		String title=driver.getTitle();
		while(iterator.hasNext()) {
		
		String winId=iterator.next();
			driver.switchTo().window(winId);}
		
		System.out.println(driver.getTitle());
		
		 
			
	 WebElement addToCartBtn=driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']"));
	 action.moveToElement(addToCartBtn).click().perform();
	 
	 //driver.switchTo().alert();
	 
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	
	 String grandTotal=  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("attach-accessory-cart-subtotal"))).getText();
	
	System.out.println(grandTotal);
	String processedString=grandTotal.replace("₹", "").replace(",", "").replaceAll(".00", "");
	

	
	if(price.equals(processedString)) {
		System.out.println("Price are equal");
	}
	
	}
	


}
