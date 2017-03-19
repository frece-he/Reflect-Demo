package com.frece.refmethod;

import java.lang.reflect.Method;


@SuppressWarnings("rawtypes")
public class RefMethodTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		DemoClass demo = new DemoClass();
		try {
			Class c = demo.getClass();
			// get the method without any parameter, can use Class array or none parameter
//			Method m1 = c.getDeclaredMethod("print");
			Method m1 = c.getDeclaredMethod("print", new Class[]{});
			
			/**
			 * use  m1 obj to invoke method
			 *  m1.invoke(demo); is same as  demo.print();
			 */
			m1.invoke(demo);
			
			/**
			 * get method with parameter( int, int), can use Class array or just the class param
			 */
//			Method m2 = c.getDeclaredMethod("print", new Class[]{int.class, int.class});
			Method m2 = c.getDeclaredMethod("print", int.class, int.class);
			
			/**
			 * for the params list, can use real params directly or use Object array
			 * 
			 *  if params not matched, will throw IllegalArgumentException			 * 
			 */
			m2.invoke(demo, 10, 20);
//			m2.invoke(demo, new Object[]{30, 20,20});
			
//			Method m3 = c.getDeclaredMethod("print", String.class, String.class);
			Method m3 = c.getDeclaredMethod("print", new Class[]{String.class, String.class});
			
			//if return type is void then get null, otherwise get return value;
//			String str = (String) m3.invoke(demo, "hello", "World");
			String str = (String) m3.invoke(demo, new Object[]{new String("lower Case"), new String("UPPER CASE")});
			System.out.println("new str : " + str);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
}


 class DemoClass {
	
	public void print(){
		System.out.println("Hello World");
	}
	
	public void print(int a, int b){
		System.out.println(a + b);
	}
	public String print(String a, String b){
		String str = a.toUpperCase() + ", " +  b.toLowerCase();
//		System.out.println(str);
		return str;
	}
	
}
