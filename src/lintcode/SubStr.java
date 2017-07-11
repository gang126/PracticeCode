package lintcode;

public class SubStr {
	 /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     * 	如果 source = "source" 和 target = "target"，返回 -1。

		如果 source = "abcdabcdefg" 和 target = "bcd"，返回 1。
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String source="aabsdabcdabcdefg";
		String target="bcd";
		System.out.println(strStr2(source,target));
		System.out.println(NaiveStringSearch(source,target));
		
		int[] ins= GetNext("abcdabd");
		for(int xx : ins){
			System.out.print(xx+", ");
		}
		String str1="";
		System.err.println(""==str1);		
	}
	
	 public static int strStr(String source, String target) {
		 
		 /*char[] chs= target.toCharArray();
		 for(int i=0; i< chs.length; i++){
			 if(source.indexOf(chs[i])!=-1){
				 return source.indexOf(chs[i]);
			 }
			 
		 }*/
		 int x=-1;
		 if(source==null || target ==null || source.length()<target.length()){
			 return x;
		 }else
			 return source.indexOf(target);
		
			 
	 }
	 
	 public static int strStr2(String str1, String str2) {
         if(str1==null || str2==null){
			return -1;
		}
         //防止"" "";
		for(int i=0; i<str1.length()-str2.length()+1; i++){
			int j=0;
			for( j=0; j<str2.length(); j++){
				if(str1.charAt(i+j)!=str2.charAt(j)){
					break;
				}
			}
			if(j==str2.length()){
				return i;
			}
		}
		return -1;
    }
	 
	 public static int NaiveStringSearch(String S, String P)
	 {
	     int i = 0;    //S的下标
	     int j = 0;    //P的下标
	     int s_len = S.length();
	     int p_len = P.length();

	     while (i < s_len && j < p_len)
	     {
	         if (S.toCharArray()[i] == P.toCharArray()[j])  //若相等，都前进一步
	         {
	             i++;
	             j++;
	         }
	         else  //不相等
	         {
	             i ++;
	             j = 0;
	         }
	     }

	     if (j == p_len)  //匹配成功
	         return i - j;

	     return -1;
	 }
	 
	 //字符串匹配的 KMP 算法
	 public static int[] getNext(String b)  
	 {  
	     int len=b.length();  
	     int j=0;  
	           
	     int next[]=new int[len+1];//next表示长度为i的字符串前缀和后缀的最长公共部分，从1开始  
	     next[0]=next[1]=0;  
	           
	     for(int i=1;i<len;i++)//i表示字符串的下标，从0开始  
	     {//j在每次循环开始都表示next[i]的值，同时也表示需要比较的下一个位置  
	         while(j>0&&b.charAt(i)!=b.charAt(j))
	        	 j=next[j];  
	         if(b.charAt(i)==b.charAt(j))j++;  
	         next[i+1]=j;  
	     }  
	           
	     return next;  
	 }
	 
	 public static int[] GetNext(String P)
	 {
	     int p_len = P.length();
	     int i = 0;   //P的下标
	     int j = -1;  
	     int next[]=new int[p_len+1];
	     next[0] = -1;

	     while (i < p_len)
	     {
	         if (j == -1 || P.toCharArray()[i] == P.toCharArray()[j])
	         {
	             i++;
	             j++;
	             next[i] = j;
	         }
	         else
	             j = next[j];
	     }
	     
	     return next;
	 }
}
