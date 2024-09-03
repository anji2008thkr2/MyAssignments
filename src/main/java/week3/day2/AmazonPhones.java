package week3.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonPhones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
	driver.findElement(By.xpath("//input[contains(@id,\"twotabsearchtextbox\")]")).sendKeys("phones",Keys.ENTER);
		
	List<WebElement> ele=driver.findElements(By.xpath("//span[@class=\"a-price\"]"));
	
	for(WebElement e:ele) {
		System.out.println(e.getText());
	}
		

	}

}
