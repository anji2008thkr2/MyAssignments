package marathon.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[contains(@placeholder,'Search Amazon')]")).sendKeys("Bags for boys");
		driver.findElement(By.xpath("(//div[text()=\"bags for boys\"])[1]")).click();

		int total=0;


		//Iterate over each page and get the Total number
		/*
		 * WebElement scroll=driver.findElement(By.className("s-pagination-strip"));
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		 * 
		 * 
		 * boolean nextBtnDisabled=driver.findElements(By.
		 * xpath("//span[contains(@class,'s-pagination-disabled') and text()='Next']")).
		 * size()>0;
		 * 
		 * while(!nextBtnDisabled) {
		 * total+=driver.findElements(By.xpath("//span[@class='a-price-whole']")).size()
		 * ;
		 * 
		 * driver.findElement(By.xpath("//a[contains(@class,'s-pagination-next')]")).
		 * click(); nextBtnDisabled=driver.findElements(By.
		 * xpath("//span[contains(@class,'s-pagination-disabled') and text()='Next']")).
		 * size()>0; } System.out.println("Total -"+total);
		 */

		String getResults=driver.findElement(By.xpath("(//div[contains(@class,\"a-section a-spacing-small a-spacing-top-small\")])[1]")).getText();
		int totalResults=Integer.parseInt(getResults.split(" ")[3].replace(",", ""));
		System.out.println("Total Results"+totalResults);
		selectBag(driver,"Skybags");
		selectBag(driver,"KILLER");
		driver.findElement(By.xpath("//span[@data-action=\"a-dropdown-button\"]")).click();
		selectFromDropDown(driver,"Best Sellers");
		String name=driver.findElement(By.xpath("(//div[@data-cy=\"title-recipe\"])[1]")).getText();
		System.out.println(name);

		String discountPrize= driver.findElement(By.xpath("(//span[@class=\"a-price-whole\"])[1]")).getText();
		System.out.println(discountPrize);
		System.out.println("Current Tile -"+driver.getTitle());
		driver.quit();




	}

	public static void selectBag(WebDriver driver,String bagName) {
		Actions action =new Actions(driver);
	WebElement ele=	driver.findElement(By.xpath("//div[@id='brandsRefinements']//span[text()=\"Skybags\"]/..//input"));
	//action.moveToElement(ele).click().build().perform();	
	action.click(ele).perform();
	
	}

	public static void selectFromDropDown(WebDriver driver,String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']/parent::li"));
	}


}
