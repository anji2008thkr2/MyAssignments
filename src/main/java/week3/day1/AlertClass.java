package week3.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver =new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();

		Alert alert=driver.switchTo().alert();
		String alertMsg=alert.getText();
		System.out.println(alertMsg);
		alert.sendKeys("Typing message on Alert box...");
		alert.dismiss();
		String cancelledMsg= driver.findElement(By.xpath("//span[@id=\"confirm_result\"]")).getText();

		System.out.println(cancelledMsg);

	}

}
