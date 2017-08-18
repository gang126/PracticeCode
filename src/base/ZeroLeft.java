package base;

import java.util.Arrays;

public class ZeroLeft {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int compIndex = 0 ; for(int i = 1 ;i < array.length ; i ++ ){
		 * if(array[i] == 0 ){ swap(array,i,compIndex); compIndex++; } } for(int
		 * j : array){ System.out.print(j+","); }
		 */
		/*int[] arr = { 7, 0, 0, 0, 2, 36, 35, 0, 0, 12 };
		moveToLeft(arr);
		for (int j : arr) {
			System.out.print(j + ",");
		}
		System.out.println();
		int temp = 0;
		for (int x = arr.length - 1; x >= 0; x--) {
			System.out.print(arr[x] + ",");
		}
*/
		/*
		 * for(int j : arr){ System.out.print(j+","); }
		 */

		int[] a = { 7, 0, 0, 0, 2, 36, 35, 0, 0, 12 };
		int idx = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				a[idx] = a[i];
				idx++;
			} else {
				a[a.length - 1 - idx] = a[i];
			}
		}
		int zeroNum= a.length-idx;
		for(int i=0; i+zeroNum<a.length; i++){
			a[i+zeroNum]=a[i];
		}
		
		for(int i=0; i<zeroNum; i++){
			a[i]=0;
		}
		System.out.println("处理后的结果：" + Arrays.toString(a));
	}

	public static void moveToLeft(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[count++] = arr[i];
			}
		}

		for (int j = count; j < arr.length; j++) {
			arr[j] = 0;
		}

		/*
		 * int temp=0; for(int x=arr.length-1; x>=0; x--){ arr[temp++]=arr[x--];
		 * }
		 */
	}
}
