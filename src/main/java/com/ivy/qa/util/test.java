package com.ivy.qa.util;

public class test {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Xls_Reader reader=new Xls_Reader("C:\\Users\\kkumar4\\Java_Selenium_WorkSpace\\MTCTCreation\\src\\main\\java\\com\\ivy\\qa\\testdata\\data.xlsx");
		System.out.println(reader.getCellData("Data",2,8));
		
	}

}
