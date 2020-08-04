package mainProgram;

import bleSource.BleTester;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("hello");
		
		//test ble filtering
		BleTester bt= new BleTester();
		try {
			bt.startTest();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
