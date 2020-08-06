

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DataLocalConnector_BleTestSet {
	
	
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/ACUB?autoReconnect=true&useSSL=false";
    

    String dbUser = "juha";
    String dbPasswd = "1234";
    Connection con;
    
    boolean test = true;
    
    private IDPAIR[] pairs;
	int pairsize;
    
	public DataLocalConnector_BleTestSet() {
		this.pairsize=0;
		pairs=new IDPAIR[100];
		
	}
	
	
	public void connectANDquery( HashMap<IDPAIR,SIGINF> map) throws ClassNotFoundException {
		  System.out.println("get Ble Test Datas ");
          
          try{
        	
        	 Class.forName(driver);
        	  con = DriverManager.getConnection(url, dbUser, dbPasswd);
        	  
          
          
         
          } catch(SQLException e) {
        	   System.out.println(e.getMessage());
        	}
          
          if(test) {
              try{
            	  
              Statement st = con.createStatement();
              System.out.println("sql:select");
              String sql ="SELECT my_id, other_id, rssi, mTime " +
                      "FROM testset_ble";

              ResultSet rs    = st.executeQuery(sql);
              getData(rs,map);
              
              
              
              }
              catch (SQLException s){
              System.out.println("SQL statement is not executed!");
              }
              }
         
	}
	
	public void getData(ResultSet rst,HashMap<IDPAIR,SIGINF> mm) throws SQLException {
		
		while(rst.next()) {
		int size= rst.getRow();
		String mmmi=rst.getString("my_id");
		String yyyi=rst.getString("other_id");
		System.out.println("From database :"+mmmi+"  "+yyyi);
		
		boolean samepair=false;
		IDPAIR thispair=null;
		System.out.println(size);
		if(this.pairsize==0) {
			IDPAIR temp=new IDPAIR(mmmi,yyyi);
			pairsize++;
			thispair=temp;
			mm.put(temp, new SIGINF());
			System.out.println("first pair add");
		
		}else {
		for(int i=0; i<this.pairsize; i++) {
			if(this.pairs[i].isSame(mmmi, yyyi)) {
				samepair=true;
				thispair=pairs[i];
				System.out.println("issame");
			}else {
				IDPAIR temp=new IDPAIR(mmmi,yyyi);
				pairsize++;
				thispair=temp;
				mm.put(temp, new SIGINF());
				System.out.println("is not same");
			}
			
		}
		}
		
		mm.get(thispair).stackFRSSI(rst.getInt("rssi"));
		
		}
		
	}
	
	
	    
	
}
