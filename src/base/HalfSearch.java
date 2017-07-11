package base;

public class HalfSearch {

	public static void main(String[] args) {
		//数组必须有序
		int[] a={1,3,5,7,9};
		//System.out.println(half(a,6));
		int index = half(a,5);
	
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
		
		
		System.out.println("下标是："+ minIndex);
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
}