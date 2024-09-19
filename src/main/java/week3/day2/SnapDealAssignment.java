package week3.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SnapDealAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Actions action=new Actions(driver);

		WebElement mensSection=driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		action.moveToElement(mensSection).perform();

		WebElement sportsShoes=driver.findElement(By.xpath("//span[text()=\"Sports Shoes\"]"));
		action.moveToElement(sportsShoes).click().perform();
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		
		WebElement product=driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		action.moveToElement(product).scrollToElement(product).build().perform();
		
		List<WebElement>allProducts= driver.findElements(By.xpath("//p[@class=\"product-title\"]"));
        System.out.println(allProducts.size());




	}

}
