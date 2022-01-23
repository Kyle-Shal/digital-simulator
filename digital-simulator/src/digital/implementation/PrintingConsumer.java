package digital.implementation;

import java.util.Iterator;

import digital.interfaces.NetInterface;
import digital.interfaces.SimulationResultConsumerI;

public class PrintingConsumer implements SimulationResultConsumerI {

	@Override
	public void finishedCycle(int cycle, Iterator<NetInterface> it) {
		System.out.println( "At the end of clock cycle " + cycle + " the net values are.") ;
		while( it.hasNext() ) {
			NetInterface n = it.next() ;
			System.out.println( n.getName() + " :\t" + n.getValue() ) ;
		}
	}
}
