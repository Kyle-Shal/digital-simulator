package digital.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import digital.interfaces.NetInterface;
import digital.interfaces.SimulationResultConsumerI;
import digital.interfaces.Value;

public class RecordingConsumer implements SimulationResultConsumerI {

	HashMap<String, ArrayList<Value> > hm = new HashMap<String, ArrayList<Value> >() ;
	@Override
	public void finishedCycle(int cycle, Iterator<NetInterface> it) {
		while( it.hasNext() ) {
			NetInterface net = it.next();
			String name = net.getName() ; 
			Value value = net.getValue() ;
			if( cycle == 0 )
				hm.put(name, new ArrayList<Value>() ) ;
			ArrayList<Value> list = hm.get(name) ;
			list.add(value) ; }
	}
	
	public Value getValue( int cycle, String name ) {
		ArrayList<Value> list = hm.get(name) ;
		return list.get( cycle ) ;
	}
}