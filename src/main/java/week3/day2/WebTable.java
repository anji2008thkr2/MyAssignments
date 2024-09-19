package week3.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://erail.in/trains-between-stations/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		HashMap<String,Integer> hm=new HashMap<>();
		
		WebElement element = driver.findElement(By.id("txtStationFrom"));
		element.clear();
		element.sendKeys("MAS",Keys.ENTER);
		
		WebElement element2 = driver.findElement(By.id("txtStationTo"));
		element2.clear();
		element2.sendKeys("MDU",Keys.ENTER);
		driver.findElement(By.xpath("//label[@for=\"chkSelectDateOnly\"]/following-sibling::input")).click();
		
	     int rowCount=driver.findElements(By.xpath("//table[@class=\"DataTable TrainList TrainListHeader stickyTrainListHeader\"]//tr")).size();
			
		for (int i = 2; i <= rowCount; i++) {
		String name=driver.findElement(By.xpath("//table[contains(@class,'DataTable TrainList TrainListHeader stickyTrainListHeader')]//tr["+i+"]//td[2]")).getText();
		
		if(hm.containsKey(name)) {
		hm.put(name, hm.get(name)+1);
		}
		else {
			hm.put(name,1);
		}}
		//System.out.println(hm);
		
	
	
		for(Map.Entry<String, Integer> mp: hm.entrySet()) {
			if(mp.getValue()>1) {
				System.out.println(mp.getKey() +" "+mp.getValue());
			}
			
		}
		
	
	}
}
