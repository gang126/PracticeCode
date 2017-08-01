package chapter1;
/*样例
 * 另外一种算法 - Rabin Karp。该算法与 KMP 有着同等的时间复杂度 O(n+m) 
如果 source = "source" 和 target = "target"，返回 -1。

如果 source = "abcdabcdefg" 和 target = "bcd"，返回 1。*/
public class StrStr2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String source= "abcde";
		String target="bcd";
		
		System.out.println(Str(source, target));
	}
	
	public static int Str(String source, String target){
		if(source ==null || target == null){
			return -1;
		}
		int base=1000000;
		int m=target.length();
		if(m==0){
			return 0;
		}
		int pow=1;
		//31的m-1次方
		for(int i=0; i<m; i++){
			pow=(pow*31)%base;
		}
		
		int targetCode=0;
		//目标字符串的  hashcode值
		for(int i=0; i<m; i++){
			targetCode=(targetCode*31 + target.charAt(i))%base;
		}
		
		int hashCode=0;
		for(int i=0; i<source.length(); i++){
			//abc+d
			hashCode=(hashCode*31 + source.charAt(i))%base;	
			//不够m的长度， ++
			if(i<m-1){
				continue;
			}
			
			//减掉最高位
			if(i>=m){
				hashCode= hashCode-(source.charAt(i-m)*pow)%base;
				//可能出现负数
				if(hashCode<0){
					hashCode=hashCode+base;
				}
			}
			
			//hash相等 再判断值
			if(targetCode == hashCode){
				if(source.substring(i-m+1, i+1).equals(target)){
					return i-m+1;
				}
			}
		}
		
		return -1;
	}
}
