package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;

public class FacebookLogin {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("testleaf.2023@gmail.com");
		
		WebElement password=driver.findElement(By.id("pass"));
		password.sendKeys("Tuna@321");
		
		WebElement loginbtn=driver.findElement(By.name("login"));
		loginbtn.click();
		
		WebElement findYourAccount=driver.findElement(By.partialLinkText("Find your account"));
		findYourAccount.click();
		
		String title=driver.getTitle();
		
	     System.out.println(title);
		
		
		
		
		
		
		
		

	}

}
