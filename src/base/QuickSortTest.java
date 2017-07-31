package base;

public class QuickSortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ins={72,6,57,88,60,42,83,73,48,85};
		
		//quick_sort(ins,0,ins.length-1);
		quickSort(ins,0,ins.length-1);
		for(int i : ins){
			System.out.print(i+",");
		}
		
	}
	
	public static void quick_sort(int s[], int l, int r)  
	{  
	    if (l < r)  
	    {  
	        //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见�?1  
	        int i = l, j = r, x = s[l];  
	        while (i < j)  
	        {  
	            while(i < j && s[j] >= x) // 从右向左找第�?个小于x的数  
	                j--;    
	            if(i < j)   
	                s[i++] = s[j];  
	              
	            while(i < j && s[i] < x) // 从左向右找第�?个大于等于x的数  
	                i++;    
	            if(i < j)   
	                s[j--] = s[i];  
	        }  
	        s[i] = x;  
	       quick_sort(s, l, i - 1); // 递归调用   
	       quick_sort(s, i + 1, r);  
	    }  
	
	}
	
	public static void quickSort(int[] A, int start, int end){
		
		if (start >= end) {
            return;
        }
        
        int left = start, right = end;
        // key point 1: pivot is the value, not the index
        int pivot = A[(start + end) / 2];

        // key point 2: every time you compare left & right, it should be 
        // left <= right not left < right
        while (left <= right) {
            // key point 3: A[left] < pivot not A[left] <= pivot
            while (left <= right && A[left] < pivot) {
                left++;
            }
            // key point 3: A[right] > pivot not A[right] >= pivot
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                
                left++;
                right--;
            }
        }
        
        quickSort(A, start, right);
        quickSort(A, left, end);
    }

}