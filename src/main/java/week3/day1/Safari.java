package week3.day1;

public class Safari extends Browser{
	
	public void readerMode() {
		System.out.println("Reader Mode");
		
	}
	
	public void fullScreenMode() {
	System.out.println("Full screen Mode");	
	}

	public static void main(String[] args) {
		
		String s1="TestLeaf";
		String s2=new String("TestLeaf");
		String s3=new String("TestLeaf");
        System.out.println(s1.length()==s2.length());
		
		
		
		// TODO Auto-generated method stub
		Safari safari=new Safari();
		System.out.println(safari.browserName="Safari");
		System.out.println(safari.browserVersion=1.111f);
		safari.readerMode();
		safari.openURL();
		safari.fullScreenMode();
		safari.navigateBack();
		safari.closeBrowser();

	}

}
