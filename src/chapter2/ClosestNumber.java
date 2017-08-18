package chapter2;

public class ClosestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A= {0, 3, 3, 4};
		System.out.println(closestNumber(A,1));
	}
	
	public static int closestNumber(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int index = firstIndex(A, target);
        if (index == 0) {
            return 0;
        }
        if (index == A.length) {
            return A.length - 1;
        }

        if (target - A[index - 1] < A[index] - target) {
            return index - 1;
        }
        return index;
    }

	
	private static int firstIndex(int[] A, int target) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[start] >= target) {
            return start;
        }
        if (A[end] >= target) {
            return end;
        }
        return A.length;
    }

}
