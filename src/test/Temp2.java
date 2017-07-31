package test;

public class Temp2 implements Runnable{

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Temp2 ss= new Temp2();
		new Thread(ss).start();
		Thread.sleep(10);
		new Thread(ss).start();
	}
	
	static boolean flag=false;
	public static synchronized void test0(){
		for(int i=0; i<10000; i++){
			System.out.println("test0: "+Thread.currentThread().getName()+" "+i);
		}
	}
	
	public void test1(){
		synchronized(Temp2.class){
			for(int i=0; i<10000; i++){
				System.out.println("test1: "+Thread.currentThread().getName()+" "+i);
			}
		}
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(flag){
			flag=false;
			test0();
		}else{
			flag=true;
			test1();
		}
	}

}
