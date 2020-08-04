package bleSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import datas.DataLocalConnector_BleTestSet;

public class BleTester {
	
	DataLocalConnector_BleTestSet Blecon;
	private HashMap<IDPAIR,SIGINF> sigmap;
	
	public BleTester() {
		
		Blecon=new DataLocalConnector_BleTestSet();
	
		sigmap=new HashMap<>();
		
		
		
		
		
		
	}
	public void startTest() throws ClassNotFoundException {
		
		Blecon.connectANDquery(sigmap);
		Set<IDPAIR> pairs = sigmap.keySet();
		Iterator<IDPAIR> it = pairs.iterator();
		
		while(it.hasNext()) {
			valueFilter(sigmap.get(it.next()));
			
		}
	}
    private void valueFilter(SIGINF si){
    	int rssi=0;
    	for(int p=0; p<si.rSize; p++) {
    		rssi=si.rssi[p];
    		if(p>10) {
    			si.stackFRSSI((rssi* (p - 1) / p) + (si.getFilter().update(rssi) / p));
    			si.setDistance(Math.pow(10, ((si.getTxp() - si.getNewFSssi()) / (10 * 2)))*si.getWeight());
    			
    		}else if(p==10){
    			 si.stackFRSSI((si.rssi[4] + si.rssi[5]) / 2);
    			 si.getFilter().update(si.getNewFSssi());
    			
    		}
    		
    	}
    }
}
