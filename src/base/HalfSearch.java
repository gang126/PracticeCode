package base;

public class HalfSearch {

	public static void main(String[] args) {
		//数组必须有序
		int[] a={1, 2, 3, 3, 4, 5, 5};
		//System.out.println(half(a,5));
		int index = binarySearch(a,3);
		System.out.println(index);
		/*System.out.println(getMin(a,3));
		int minIndex = index;
		for(int i = 1; i < 1000000; i++){
			if(a[index] != a[minIndex]){
				minIndex += 1;
				break;
			}else{
				
				minIndex = index - i;
				if(minIndex < 0){
					
					minIndex += 1;
					break;
				}
				
				continue;
			}
			
			
			
		}
		
		
		System.out.println("下标是："+ minIndex);*/
	}

	
	public static int half(int[] a, int key){
		int min=0;
		int max=a.length-1;
		int mid;
		while(min<=max){
			mid=(min+max)>>1;
			if(a[mid]>key){
				max=mid-1;
			}else if(a[mid]<key){
				min=mid+1;
			}else
				return mid;
		}
		return min;
	}
	
	public static int binarySearch(int[] a , int target){
		
		int start=0; int end= a.length-1;
		while(start +1< end){
			int mid = start + (end -start)/2;
			if(a[mid] ==target){
				end=mid;
			}else if(a[mid] < target){
				start = mid;
			}else
				end = mid;
		}
		
		if(a[start] == target){
			return start;
		}
		
		if(a[end] == target){
			return end;
		}
		return -1;
	}
	
public static int lastPosition(int[] a , int target){
		
		int start=0; int end= a.length-1;
		while(start+1  < end){
			int mid = start + (end -start)/2;
			if(a[mid] ==target){
				start=mid;
			}else if(a[mid] < target){
				start = mid;
			}else
				end = mid;
		}
		
		if(a[end] == target){
			return end;
		}
		
		if(a[start] == target){
			return start;
		}
		
		
		return -1;
	}
	
	
	public static int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
	
	public static int findPosition1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

	public static int getMin(int[] ins, int target){
		int index=target-1;
		while(index>=0){
			if(ins[index] == ins[target]){
				index--;
			}else
				return index+1;
		}
		return index+1;
	}
}