

public class IDPAIR {
	String myid;
	String yourid;
	
	
	public IDPAIR(String my, String your) {
		this.myid=my;
		this.yourid=your;
		
	}
	public boolean isSame(String m, String y) {
		if(this.myid.equals(m)&&this.yourid.equals(y)) {
			return true;
		}
		else{return false;
		}
		
		
	}

}
