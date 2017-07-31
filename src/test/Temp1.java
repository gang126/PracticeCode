package test;

import java.util.ArrayList;
import java.util.List;

public class Temp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 7/2;
		System.out.println(x);
		
		double s=5;
		s =s+5;
		System.out.println(s);
		System.out.println('a'+7+"Hello");
		
		List li= new ArrayList();
		li.add("¿¨¿¨");
		li.add("Ä°Ä°");
		
		List<String> l2= li;
		for(int n=0; n<l2.size(); n++){
			System.out.println(l2.get(n));
		}
		
		String s1= "test.dubbo.com";
		String[] str= s1.split("\\.");
		for(String s2 : str){
			System.out.println(s2);
		}
	}

}
