package week3.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class YahooWebTableAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://finance.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Actions actions = new Actions(driver);

		WebElement more = driver.findElement(By.xpath("//li/button/span[text()='More']"));

		actions.moveToElement(more).perform();

		WebElement crypto = driver.findElement(
				By.xpath("//a[@aria-label='Finance: General']/following-sibling::ul/li/a[contains(text(),'Crypto')]"));
		crypto.click();

		// To get all names and their prices around 10k entries

		WebElement nextBtn = driver.findElement(By.xpath("//button[@aria-label='Goto next page']"));
		boolean isNextEnabled = nextBtn.isEnabled();
		int noOfRetries=3;
		while(isNextEnabled)
		{ try { while(noOfRetries>0) {
			List<WebElement> allCryptoNames=driver.findElements(By.
					xpath("//td[@class='cell  yf-42jv6g']//div[@class='name yf-ravs5v stacked']//span[@class='symbol yf-ravs5v']"));
			List<WebElement>allCryptoPrices=driver.findElements(By.xpath("//td[@class='cell  yf-42jv6g']//fin-streamer[@data-field='regularMarketPrice']")); 
			for (int i = 0; i < allCryptoNames.size(); i++) {
				System.out.println(allCryptoNames.get(i).getText()+"--"+allCryptoPrices.get(i).getText()); }
			nextBtn.click();
		}break;
		} catch(Exception e) {}}





		//				  List<WebElement> allCryptoNames=driver.findElements(By.xpath("//td[@class='cell  yf-42jv6g']//div[@class='name yf-ravs5v stacked']//span[@class='symbol yf-ravs5v']"));
		//				  for (int i = 0; i < allCryptoNames.size(); i++) {
		//				  System.out.println(allCryptoNames.get(i).getText()); }


	}

}
