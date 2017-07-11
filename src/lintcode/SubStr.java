package lintcode;

public class SubStr {
	 /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     * 	��� source = "source" �� target = "target"������ -1��

		��� source = "abcdabcdefg" �� target = "bcd"������ 1��
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
         //��ֹ"" "";
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
	     int i = 0;    //S���±�
	     int j = 0;    //P���±�
	     int s_len = S.length();
	     int p_len = P.length();

	     while (i < s_len && j < p_len)
	     {
	         if (S.toCharArray()[i] == P.toCharArray()[j])  //����ȣ���ǰ��һ��
	         {
	             i++;
	             j++;
	         }
	         else  //�����
	         {
	             i ++;
	             j = 0;
	         }
	     }

	     if (j == p_len)  //ƥ��ɹ�
	         return i - j;

	     return -1;
	 }
	 
	 //�ַ���ƥ��� KMP �㷨
	 public static int[] getNext(String b)  
	 {  
	     int len=b.length();  
	     int j=0;  
	           
	     int next[]=new int[len+1];//next��ʾ����Ϊi���ַ���ǰ׺�ͺ�׺����������֣���1��ʼ  
	     next[0]=next[1]=0;  
	           
	     for(int i=1;i<len;i++)//i��ʾ�ַ������±꣬��0��ʼ  
	     {//j��ÿ��ѭ����ʼ����ʾnext[i]��ֵ��ͬʱҲ��ʾ��Ҫ�Ƚϵ���һ��λ��  
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
	     int i = 0;   //P���±�
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
