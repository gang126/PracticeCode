package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S= {1,2,3};
		List<List<Integer>> ret =subsets(S);
		
		for(int i=0; i<ret.size(); i++){
			System.out.print("[");
			for(int j=0; j<ret.get(i).size(); j++){
				System.out.print(ret.get(i).get(j)+",");
			}
			System.out.print("]");
			System.out.println();
		}
	}

	
	public static List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (S == null) {
            return ret;
        }
        
        Arrays.sort(S);
        
        dfs(S, 0, new ArrayList<Integer> (), ret);
        
        return ret;
    }
    
    public static void dfs(int[] S, int index, List<Integer> path, List<List<Integer>> ret) {
    	//ШЅжи
    	/*if(!ret.contains(path)){
    		 ret.add(new ArrayList<Integer>(path));
    	}*/
    	ret.add(new ArrayList<Integer>(path));
        
        for (int i = index; i < S.length; i++) {
        	//[1,2,2] 
        	/*if(i!=0 && S[i] == S[i-1] && i>index) {
        		continue;
        	}*/
            path.add(S[i]);
            dfs(S, i + 1, path, ret);
            path.remove(path.size() - 1);
        }
    }
}
