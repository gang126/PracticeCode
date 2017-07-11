package base;

import java.util.HashMap;

//ÅÀÂ¥Ìİ
public class ClimbLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sum2(10));
	}
	
	public static int sum(int n){
		if(n<1){
			return 0;
		}
		if(n==1){
			return 1;
		}
		if(n==2){
			return 2;
		}	
		return sum(n-1)+sum(n-2);
	}
	
	public static int sum1(int n){
		if(n<1){
			return 0;
		}
		if(n==1){
			return 1;
		}
		if(n==2){
			return 2;
		}	
		
		HashMap<Integer, Integer> map =new HashMap<Integer, Integer>();
		
		if(map.containsKey(n)){
			return map.get(n);
		}
		int sum=sum(n-1)+sum(n-2);
		map.put(n, sum);
		
		return sum;
	}
	
	public static int sum2(int n){
		if(n<1){
			return 0;
		}
		if(n==1){
			return 1;
		}
		if(n==2){
			return 2;
		}	
		
		int a=1, b=2;
		int temp=0;
		
		for(int i=3; i<=n; i++){
			temp=a+b;
			a=b;
			b=temp;
		}
		return temp;
	}
}
