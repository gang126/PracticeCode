package chapter2;
	/*样例
	考虑下列矩阵：
	[
  [1, 3, 5, 7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
	给出target = 3，返回 2*/
public class Search2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix ={{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
		System.out.println(matrix(matrix,3));
	}
	
	public static boolean matrix(int[][] matrix, int target){
		if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        
        int row = matrix.length;
        int column = matrix[0].length;
        
        // find the row index, the last number <= target 
        int start = 0, end = row - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[end][0] <= target) {
            row = end;
        } else if (matrix[start][0] <= target) {
            row = start;
        } else {
            return false;
        }
        
        // find the column index, the number equal to target
        start = 0;
        end = column - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[row][start] == target) {
            return true;
        } else if (matrix[row][end] == target) {
            return true;
        }
        return false;
    }

}
