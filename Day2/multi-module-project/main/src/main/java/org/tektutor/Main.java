package org.tektutor;

public class Main {

	public String getModuleName() {
		return "Main";
	}

	public static void main ( String[] args ) {

		Frontend fe = new Frontend();
		BusinessLayer bl = new BusinessLayer();
		DataAccessLayer dal = new DataAccessLayer();
		Main mainObj = new Main();

		System.out.println ( mainObj.getModuleName() ); 
		System.out.println ( fe.getModuleName() ); 
		System.out.println ( bl.getModuleName() ); 
		System.out.println ( dal.getModuleName() ); 

	}

}
