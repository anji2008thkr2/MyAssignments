package week3.day1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandle {

	public static void main(String[] args) {
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.xpath("//span[text()='Open with delay']"));
	//	element.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		//wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	
		Set<String> windowHandles = driver.getWindowHandles();

		for(String s:windowHandles) {
			
			if(!(driver.switchTo().window(s).getTitle().equals("Web Table"))) {
				driver.close();
				
	}
			else {
				System.out.println(driver.getTitle());
			}
			
		}
		
	}

}
