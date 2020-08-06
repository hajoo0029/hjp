

public class SIGINF {

	
	public SIGINF() {
		rSize=0;
		fSize=0;
		rssi=new int[2000];
		filteredRssi=new double[2000];
		filter = new KalmanFilter(0.0f);
		weight=1;
		
	}
	public SIGINF(String tst) {
		rSize=0;
		fSize=0;
		
		rssi=new int[] {-10,-15,-11,-12,-12,-12,-10,-15,-11,-12,-12,-12,-10,-15,-11,-12,-12,-12,-10,-15,-11,-12,-12,-12,-10,-15,-11,-12,-12,-12,-10,-15,-11,-12,-12,-12,-10,-15,-11,-12,-12,-12,-10,-15,-11,-12,-12,-12,-10,-15,-11,-12,-12,-12,-10,-15,-11,-12,-12,-12};
		rSize=rssi.length;
		
		filteredRssi=new double[2000];
		filter = new KalmanFilter(0.0f);
		weight=1;
		
	}
	
	int rSize;
	int fSize;
	
	int txP;
	int[] rssi;
	double[] filteredRssi; 
	String[] time;
	double weight;
	
	  private KalmanFilter filter;
	  public KalmanFilter getFilter() {
	        return filter;
	    }
	    public void setFilter(KalmanFilter filter) {
	        this.filter = filter;
	    }
	
	double distance;
	
	public double getWeight() {
		return this.weight;
	}
	
	public void stackRSSI(int rssi) {
		if(rSize<2000) {
		this.rssi[rSize]=rssi;
		this.rSize++;
		}
		
	}
	public void stackFRSSI(double d) {
		if(fSize<2000) {
			this.filteredRssi[fSize]=d;
			this.fSize++;
			}
	}
	
	public void setTxp(int TX) {
		this.txP=TX;
	}
	
	public void setRssi(int[] Rssi) {
		this.rssi= Rssi;
	}
	public void setFilteredRssi(double[] filteded){
		this.filteredRssi=filteded;
	}
	public void setDistance(double dist) {
		this.distance=dist;
	}
	public int getTxp() {
		return this.txP;
	}
	public double[] getFilteredRssi(){
		return this.filteredRssi;
	}
	public double getDistance() {
		return this.distance;
	}
	public double getNewFSssi() {
		if(this.fSize>0) {
			return this.filteredRssi[fSize-1];
		}else return 0;
		
		
	}
	

}
