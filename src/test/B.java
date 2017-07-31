package test;

import java.lang.reflect.Constructor;

public class B {
	public static void main(String[] args) {   
        B b=new B();   
        System.out.println("ͨ��Class.NewInstance()����˽�й��캯��:");   
        b.newInstanceByClassNewInstance();   
        System.out.println("ͨ��Constructor.newInstance()����˽�й��캯��:");   
        b.newInstanceByConstructorNewInstance();  
    }   
	 /*ͨ��Class.NewInstance()�����µ���ʾ��*/   
    private void newInstanceByClassNewInstance(){   
        try {/*��ǰ����Ϊreflect������ʹ��ȫ·��*/   
            A a=(A)Class.forName("test.A").newInstance();   
        } catch (Exception e) {   
        	System.out.println("ͨ��Class.NewInstance()����˽�й��캯����ʧ�ܡ�");   
        }  
    }  
      
    /*ͨ��Constructor.newInstance()�����µ���ʾ��*/   
    private void newInstanceByConstructorNewInstance(){   
        try {/*����ʹ�����·����ͬһ�����п��Բ��ô���·��*/   
            Class c=Class.forName("test.A");   
            /*���µ����޲εġ�˽�й��캯��*/   
            Constructor c0=c.getDeclaredConstructor();   
            c0.setAccessible(true);   
            A a0=(A)c0.newInstance();   
            /*���µ��ô��εġ�˽�й��캯��*/   
            Constructor c1=c.getDeclaredConstructor(new Class[]{int.class,int.class});   
            c1.setAccessible(true);   
            A a1=(A)c1.newInstance(new Object[]{5,6});   
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
    }   
}
