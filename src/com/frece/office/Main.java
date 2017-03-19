package com.frece.office;


public class Main {

	public static void main(String[] args) {
//		loadClass("com.frece.office.Word");
//		loadClass("com.frece.office.Excel");
		loadClass("com.frece.office.Outlook");

	}
	
	@SuppressWarnings("rawtypes")
	public static void loadClass(String str){
		try {
			Class c = Class.forName(str);
			OfficeAble oa = (OfficeAble) c.newInstance();
			oa.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
