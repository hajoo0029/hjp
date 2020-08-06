

public class Main {
	
	public static void main(String[] args) {
		System.out.println("hello");
		
		//test ble filtering
		
		boolean test = true;
		
		if(test) {
			BleTester bt= new BleTester();
			try {
				bt.startTest();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("filter test start");
			BleTester bt= new BleTester();
			SIGINF tester=new SIGINF("test");
			bt.valueFilter(tester);
			
			//int n = tester.distance;
			System.out.println( tester.distance);
			
			
			
		}
		
		
		
		
		
	}

}
