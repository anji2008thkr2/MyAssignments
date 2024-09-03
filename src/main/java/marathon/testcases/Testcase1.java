package marathon.testcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testcase1 {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));


		By cinemaIcon=By.xpath("//div/span[contains(@class,\"p-dropdown-label p-inputtext\")]//span//img");
		By location=By.xpath("//h6[text()='Chennai']");
		By clkcinema=By.xpath("//span[text()='Cinema']");
		By cinemaDrpDwn=By.xpath("//span[text()='Select Cinema']");
		By selectCinema=By.xpath("//span[text()='INOX The Marina Mall, OMR, Chennai']");
		By dateDrpDwn=By.xpath("//div/div[@id='date' and @data-pc-section='root' ]//span");
		By tommDt=By.xpath("//ul/li/span[contains(text(),'Tomorrow')]");
		By movieDrpDwn=By.xpath("//div[@id='movie']");
		By selectMovie=By.xpath("//li/span[text()='STREE 2 SARKATE KA AATANK']");
		By selectTime=By.xpath("(//span[contains(text(),'10:50 PM')])[1]");
		By bookbtn=By.xpath("//span[text()='Book']");
		By accept=By.xpath("//button[text()='Accept']");
		By selectSeat=By.xpath("(//td/span[text()='3'])[1]");
		By proceed=By.xpath("//button[text()='Proceed']");
		By seatInfo=By.className("seat-info");
		By grandTotal=By.className("grand-amount");
		By closeIcon=By.xpath("(//div[contains(@class,'cross-icon')])[1]");



		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));

		wait.until(ExpectedConditions.elementToBeClickable(cinemaIcon)).click();
		wait.until(ExpectedConditions.elementToBeClickable(location)).click();
		wait.until(ExpectedConditions.elementToBeClickable(clkcinema)).click();
		wait.until(ExpectedConditions.elementToBeClickable(cinemaDrpDwn)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectCinema)).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(tommDt)).click();
 		wait.until(ExpectedConditions.elementToBeClickable(selectMovie)).click();


		wait.until(ExpectedConditions.elementToBeClickable(selectTime)).click();
		wait.until(ExpectedConditions.elementToBeClickable(bookbtn)).click();
		//wait.until(ExpectedConditions.elementToBeClickable(accept)).click();
		wait.until(ExpectedConditions.elementToBeClickable(accept)).click();
		wait.until(ExpectedConditions.elementToBeClickable(selectSeat)).click();
		wait.until(ExpectedConditions.elementToBeClickable(proceed)).click();
        System.out.println("********************");
		String seatInfor=wait.until(ExpectedConditions.visibilityOfElementLocated(seatInfo)).getText();
		System.out.println(seatInfor);
		System.out.println("********************");
		String grandTotalInfo=wait.until(ExpectedConditions.visibilityOfElementLocated(grandTotal)).getText();
		System.out.println(grandTotalInfo);
		
		Actions act = new Actions(driver);
		WebElement proceedClick=wait.until(ExpectedConditions.elementToBeClickable(proceed));
		act.click(proceedClick);
		
		WebElement proceedClickAgain=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/button[contains(@class,btn-proceeded) and text()='Proceed']")));
		new Actions(driver).click(proceedClickAgain);
		
		WebElement proceedClickAgain_1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/button[contains(@class,btn-proceeded) and text()='Proceed']")));
		new Actions(driver).click(proceedClickAgain_1);
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(proceed)).click();
		
        WebElement closeIconAler=wait.until(ExpectedConditions.elementToBeClickable(closeIcon));
		act.click(closeIconAler);
		
        System.out.println("Title -"+ driver.getTitle());













		//driver.findElement(selectMovie).click();


		driver.quit();









	}

}
