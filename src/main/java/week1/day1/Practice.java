package week1.day1;

public class Practice {
	
		public static String reverseString(String input) {
			
			// Write your code here 
	      String revString="";
	      
	      if(input==null){ System.out.println("Invalid Input");}
	     
	      else{
	      for(int i=input.length()-1;i>=0;i--){
	        
	        revString=revString+input.charAt(i);}}
	      
			
	 return revString;
	   }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    System.out.println(reverseString(null));	
	}

}
