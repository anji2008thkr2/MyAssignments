package marathon.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testcase3 {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.tatacliq.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		Actions action=new Actions(driver);

		driver.findElement(By.id("wzrk-cancel")).click();

		WebElement brands=driver.findElement(By.xpath("//div[text()=\"Brands\"]"));
		action.moveToElement(brands).perform();

		WebElement watches=driver.findElement(By.xpath("//div[text()=\"Watches & Accessories\"]"));
		action.moveToElement(watches).perform();

		List<WebElement> allBrands= driver.findElements(By.xpath("//div[@class='DesktopHeader__featureBrands']/div[@class='DesktopHeader__brandsDetails']"));
		allBrands.get(0).click();

		WebElement selectDropDwn=driver.findElement(By.className("SelectBoxDesktop__hideSelect"));
		Select select =new Select(selectDropDwn);
		select.selectByValue("isProductNew");

		WebElement mensCategory=driver.findElement(By.xpath("//div[text()='Men' and @class='FilterDesktop__newFilName']/preceding-sibling::div"));
		mensCategory.click();

		//List<WebElement>allPrices=driver.findElements(By.xpath("//div[@class=\"ProductDescription__priceHolder\"]/h3[@class=\"ProductDescription__boldText\"]"));
		int retries = 3;
		String expectedPrice = null;
		while (retries > 0) {
			try {
				List<WebElement> allPrices = new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ProductDescription__priceHolder']/h3[@class='ProductDescription__boldText']")));
				expectedPrice=allPrices.get(0).getText().replace("₹", "");
				for (WebElement price : allPrices) {
					action.scrollToElement(price).perform();
					System.out.println("Watch Price--" + price.getText());
				}
				// Exit loop if successful
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Caught StaleElementReferenceException, retrying...");
				retries--;}}

		//		try {
		//
		//			for (WebElement price : allPrices) {
		//
		//				action.scrollToElement(price).perform();
		//
		//				System.out.println("Watch Price--"+price.getText());}
		//		}
		//		catch(StaleElementReferenceException e) {
		//			allPrices=driver.findElements(By.xpath("//div[@class=\"ProductDescription__priceHolder\"]/h3[@class=\"ProductDescription__boldText\"]"));
		//			for (WebElement price : allPrices) {
		//
		//				action.scrollToElement(price).perform();
		//
		//				System.out.println("Watch Price--"+price.getText());}
		//		}

		WebElement firstWatch=driver.findElements(By.xpath("//div[@class='ProductModule__dummyDiv']")).get(0);
		firstWatch.click();

		Set<String>allWindows= driver.getWindowHandles();
		String parentWindow=driver.getWindowHandle();

		for (String winId : allWindows) {
			if(!parentWindow.equals(winId)) {
				driver.switchTo().window(winId);

			}

		}
		String actualProductPrice=driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']")).getText().split(" ")[1].replace("₹", "").trim();
		System.out.println(actualProductPrice);
		
		if(actualProductPrice.equals(expectedPrice)) {
			System.out.println("Both prices are equal");
		}

	WebElement addToBag=driver.findElement(By.xpath("//div[@data-test='button-main-div']/span[text()='ADD TO BAG']"));
              addToBag.click();  
              
         WebElement cart=driver.findElement(By.className("DesktopHeader__cartCount"));
           String cartCount= cart.getText();
           System.out.println(cartCount +" "+"Item(s) in cart...");
           
           cart.click();
           
           File screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   		try {
   			FileUtils.copyFile(screenshotAs, new File("C:\\TestLeaf\\SeleniumLearning\\watch.png"));
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
           
          if(!(driver==null)) {
        	 driver.close(); 
          }
        
       driver.switchTo().window(parentWindow).close();
        	  
          

	}

}
