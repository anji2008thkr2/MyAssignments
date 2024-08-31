package week1.day1;

import java.util.HashMap;
import java.util.Map;

public class Annogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		   String s1="silent";
	        String s2="listen";
	        
	        System.out.println(annogram(s1,s2));

		
	}
	
	
	 public  static boolean annogram(String s1,String s2){
		 boolean b=false;
	        Map<Character,Integer> hm=new HashMap<>();

	        if(s1.length()!=s2.length()){
	        	b=false;
	         return b;
	        }

	        for(char c:s1.toCharArray()){
	            if(hm.containsKey(c)){
	                hm.put(c,hm.getOrDefault(c,1)+1);}   //test
	        
	          else {
	        	 hm.put(c,1);
	        }}

	        for(char c:s2.toCharArray()){
	            if(!hm.containsKey(c)){
	                hm.put(c,hm.getOrDefault(c,1)+1);
	            }
	            else {
	            	hm.put(c,hm.get(c)-1);
	            	
	            }
	            
	            }

	          //return  false;}


	        for(Map.Entry<Character, Integer> mp:hm.entrySet()){

	            if(mp.getValue()>0){
	            	
	            	b=false;

	                return b;
	                
	            }
	            
	            else {
	            	b=true;
	            }
	            }
	        
	        


	        return b;
	}

}
