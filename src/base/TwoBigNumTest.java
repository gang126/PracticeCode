package base;

import java.math.BigInteger;

public class TwoBigNumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="92233720368547758078";
        String b = "123456789123456789";
        
        String c= "11234565";
        String d= "6780198";
        BigInteger a2 = new BigInteger(a);
        BigInteger b2 = new BigInteger(b);
        
        BigInteger result=a2.add(b2);
        
        System.out.println (result );
        System.out.println (bigAdd(a,b) );
        System.out.println (subStract(c,d) );
        
	}
    
	public static String bigAdd(String a, String b){
		String str="", max="", min="";
		max=(a.length()>b.length()) ? a : b;
		min=(max==a) ? b : a;
		String tempStr="";
		for(int i=0; i<max.length()-min.length(); i++){
			tempStr +="0";
		}
		min =tempStr +min;
		int JW=0;
		for(int j=max.length()-1; j>=0; j--){
			int tempA=Integer.parseInt(String.valueOf(max.charAt(j)));
			int tempB=Integer.parseInt(String.valueOf(min.charAt(j)));
			int temp;
			if (tempA + tempB + JW >= 10 && j != 0)  
            {  
                temp = tempA + tempB + JW - 10;  
                JW = 1;  
            }else{
            	temp = tempA + tempB + JW;
            	JW=0;
            }	
			str = String.valueOf(temp) + str;  
		}
		return str;
	}
	
	public static String subStract(String a , String b){
		String str="", max="", min="";
		
		max= (a.length()>b.length()) ? a : b;
		min= (max==a) ? b : a;
		String tmpStr = "";
		for(int i=0; i<max.length()-min.length(); i++){
			tmpStr +="0";
		}
		min= tmpStr + min;
		int JW=0;
		for(int j=max.length()-1; j>=0; j--){
			int tempA=Integer.parseInt(String.valueOf(max.charAt(j)));
			int tempB=Integer.parseInt(String.valueOf(min.charAt(j)));
			int temp;
			if (tempA - tempB + JW < 0 && j != 0)  
            {  
                temp = Math.abs(10+tempA - tempB + JW);  
                JW = -1;  
            }else{
            	temp = tempA - tempB + JW;
            	JW=0;
            }	
			str = String.valueOf(temp) + str;  
		}
		return str;
	}
}
