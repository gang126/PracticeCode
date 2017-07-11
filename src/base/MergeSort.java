package base;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("--------");
		int[] ins1={7,10,19,25};
		int[] ins2={12,17,21,30,48};
		int[] tmp=new int[ins1.length+ins2.length];
		MergeArray(ins1,ins1.length,ins2,ins2.length,tmp);
		for(int i=0; i<tmp.length; i++){
			System.out.print(tmp[i]+",");
		}
		
		System.out.println("--------");
		int[] ins={72,6,57,88,60,42,83,73,48,85};
		//int[] ins={72,6};
		int[] temp=new int[ins.length];
		mergesort(ins,0,ins.length-1,temp);
		for(int i=0; i<temp.length; i++){
			System.out.print(temp[i]+",");
		}
	}
	
	public static void MergeArray(int[] ins1, int n1, int[] ins2, int n2, int[] tmp){
		int i, j, k =0;
		i=j=k=0;
		while(i<n1 && j<n2){
			if(ins1[i] < ins2[j]){
				tmp[k++] = ins1[i++];
			}else
				tmp[k++] = ins2[j++];
		}
		
		while(i<n1){
			tmp[k++] = ins1[i++];
		}
		
		while(j<n2){
			tmp[k++] = ins2[j++];
		}
	}
	
	public static void mergesort(int[] ins, int start, int end, int[] tmp){
		if(start >= end){
			return;
		}
		int mid= (start+end)/2;
		mergesort(ins, start, mid, tmp);
		mergesort(ins, mid+1, end, tmp);
		merge(ins,start, mid , end , tmp);
	}
	
	public static void merge(int[] ins, int start, int mid, int end, int[] tmp){
		int left = start;
        int right = mid+1;
        int index = start;
        
        // merge two sorted subarrays in A to temp array
        while (left <= mid && right <= end) {
            if (ins[left] < ins[right]) {
                tmp[index++] = ins[left++];
            } else {
                tmp[index++] = ins[right++];
            }
        }
        while (left <= mid) {
            tmp[index++] = ins[left++];
        }
        while (right <= end) {
            tmp[index++] = ins[right++];
        }
        
        // copy temp back to A
        for (index = start; index <= end; index++) {
            ins[index] = tmp[index];
        }
    }
}
