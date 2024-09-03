package week3.day1;

public class Edge extends Browser {
	
	
	public void takeSnap() {
		
		System.out.println("Take Snap");
	}
	
	public void clearCookies() {
		  System.out.println("Clear Cookie");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Edge edge=new Edge();
		System.out.println(edge.browserName="Edge");
		System.out.println(edge.browserVersion=1.145f);
		edge.takeSnap();
		edge.openURL();
		edge.clearCookies();
		edge.navigateBack();
		edge.closeBrowser();
	}

}
