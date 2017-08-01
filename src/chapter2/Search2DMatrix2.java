package chapter2;
	/*样例
	考虑下列矩阵：
	[
	    [1, 3, 5, 7],
	    [2, 4, 7, 8],
	    [3, 5, 9, 10]
	]
	给出target = 3，返回 2*/
public class Search2DMatrix2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix ={{1, 3, 5, 7},{2, 4, 7, 8},{3, 5, 9, 10}};
		System.out.println(matrix2(matrix,3));
	}
	
	public static int matrix2(int[][] matrix, int target){
		
		if(matrix == null || matrix.length==0){
			return 0;
		}
		
		if(matrix[0]==null || matrix[0].length==0){
			return 0;
		}
		int n = matrix.length;
		int m= matrix[0].length;
		int count =0;
		int x= n-1;
		int y=0;
		
		//从左下角的数 开始比较
		// from bottom left to top right
		while(x>=0 && y<m){
			if(matrix[x][y] >target){
				x--;
			}else if(matrix[x][y] <target){
				y++;
			}else{
				count++;
				x--;
				y++;
			}
		}
		
		return count;
	}
}
