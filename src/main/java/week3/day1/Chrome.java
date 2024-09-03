package week3.day1;

public class Chrome extends Browser {
	
	
	public void openIncognito() {
		System.out.println("Open Incognito");
		}
	
	
	public void clearCache() {
		System.out.println("Clear cache");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Chrome chrome=new Chrome();
		System.out.println(chrome.browserName="Chrome");
		System.out.println(chrome.browserVersion=1.123f);
		chrome.openIncognito();
		chrome.openURL();
		chrome.clearCache();
		chrome.navigateBack();
		chrome.closeBrowser();
	}

}
