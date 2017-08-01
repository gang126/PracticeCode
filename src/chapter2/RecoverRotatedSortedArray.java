package chapter2;

import java.util.ArrayList;

/*说明
	什么是旋转数组？
	比如，原始数组为[1,2,3,4], 则其旋转数组可以是[1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
	样例
	[4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
	题解：		
	三步翻转法	*/	
public class RecoverRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ArrayList<Integer> list=new ArrayList<Integer>();
		 list.add(4);list.add(5);list.add(1);list.add(2);list.add(3);
		 
		 list=recoverSortedArray(list);
		 for(int x=0; x<list.size(); x++){
			 System.out.print(list.get(x));
		 }
	}
	
	public static ArrayList<Integer> recoverSortedArray(ArrayList<Integer> list){
		//因为 要判断i+1， 所有 list.size()-1
		for(int i=0; i<list.size()-1; i++){
			if(list.get(i)>list.get(i+1)){
				reverse(list, 0, i);
				reverse(list, i+1,list.size()-1 );
				reverse(list, 0, list.size()-1);
				
			}
		}
		return list;
	}
	
	public static void reverse(ArrayList<Integer> list, int start, int end){
		
		for(int i=start, j=end; i<j; i++, j--){
			int temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);
		}
	}
}
