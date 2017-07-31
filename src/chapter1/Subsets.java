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
    	//ȥ��
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
    /*    对于集合里面的任何一个元素，有两种可能，一种是在子集合里，另一种是不在子集合里。
    在子集合里的话用1表示，不在的话用0表示，那么一个集合的子集合都可以用二进制表示，假设集合为{1,2,3}，
    那么可以用下列二级制表示：000,001,010,011......共有2^n种表示。
    http://blog.csdn.net/foreverbu/article/details/37567111
    http://blog.csdn.net/dengqiaodey/article/details/8083123*/
    public static ArrayList<ArrayList<Integer>> subsets2(int[] set){  
        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();  
        int max = 1 << set.length; //how many sub sets  
        for(int i=0; i<max; i++){  
            int index = 0;  
            int k = i;  
            ArrayList<Integer> s = new ArrayList<Integer>();  
            while(k > 0){  
                if((k&1) > 0){  
                    s.add(set[index]);  
                }  
                k>>=1;  
                index++;  
            }  
            allsubsets.add(s);  
        }  
        return allsubsets;  
    }  
}
