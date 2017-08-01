package chapter1;
/*样例
如果 source = "source" 和 target = "target"，返回 -1。

如果 source = "abcdabcdefg" 和 target = "bcd"，返回 1。*/
public class StrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String source= "bcd";
		String target="bcde";
		System.out.println(Str(source,target));

	}
	
	public static int Str(String source, String target){
		if(source==null || target == null){
			return -1;
		}
		//i<=source.length()-target.length();
		for(int i=0; i<=source.length()-target.length(); i++){
			int j;
			for(j=0; j<target.length(); j++){
				if(source.charAt(i+j)!=target.charAt(j)){
					break;
				}		
			}
			if(j==target.length()){
				return i;
			}
		}	
		return -1;
	}
}
