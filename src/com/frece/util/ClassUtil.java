package com.frece.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings("rawtypes")
public class ClassUtil {

	public static void main(String[] args) {
		getInfoFromClass("123");
//		getConstructorsInfo("".getClass());
	}
	
	
	public static void getInfoFromClass(Object obj){
		Class classOfObj = obj.getClass();
		getInfoFromClass(classOfObj);
	}
	
	/**
	 * print all info of Class, include methods and attributes.
	 * @param class 
	 */
	public static void getInfoFromClass(Class c){
		System.out.println("Class <" + c.getSimpleName() + "> £º ");
		System.out.println();
		getFieldsInfo(c);
		getConstructorsInfo(c);		
		getMethodsInfo(c);		 
	}
	
	private static void getFieldsInfo(Class c) {
		//get fields info
		System.out.println("===Fields===");
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			//get type and name
			System.out.println( field.getType().getSimpleName()  + "  " + field.getName());
		}
		System.out.println();
	}

	private static void getConstructorsInfo(Class c) {
		//get constructors info
		System.out.println("===Constructors===");
		//get constructors array
		Constructor[] constructors = c.getDeclaredConstructors();
		for (int i = 0; i < constructors.length; i++) {
			//get constructor name
			System.out.print(constructors[i].getName() + " (");
			//get constructor parameter type
			Class[] paraTypes = constructors[i].getParameterTypes();
//			 for (Class arg : paraTypes) {
//				System.out.print(arg.getSimpleName() + ", ");
//			}
			for (int j = 0; j < paraTypes.length; j++) {
				if(j == (paraTypes.length - 1)){
					System.out.print(paraTypes[j].getSimpleName());
				} else{
					System.out.print(paraTypes[j].getSimpleName() + ", ");
				}
			}
			System.out.println(")");
		}
		System.out.println();
	}

	private static void getMethodsInfo(Class c) {
		//get methods info
		System.out.println("===Methods===");
		Method[] methods =  c.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			//get the class of return type
			System.out.print(methods[i].getReturnType().getSimpleName() + "  ");
			//get class name
			 System.out.print(methods[i].getName() + "(");
			 //get the class of parameter list
			 Class[] paraTypes = methods[i].getParameterTypes();

			 for (int  j = 0; j< paraTypes.length; j++) {
					if(j == (paraTypes.length - 1)){
						System.out.print(paraTypes[j].getName());
					}else {
						System.out.print(paraTypes[j].getName() + ", ");
					}
				}			 
			 System.out.println(")");
		}
		System.out.println();
	}


}
