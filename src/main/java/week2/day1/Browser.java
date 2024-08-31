package week2.day1;

public class Browser {

	
	public String launchBrowser(String browserName){
		System.out.println("Browser launched Successfully");
		return browserName;
		}
	
	public void launchUrl() {
		
		System.out.println("Application url Loaded successfully");
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Browser browser=new Browser();
	browser.launchBrowser("Browser launched Successfully");
	browser.launchUrl();

}}
