package digital.interfaces;

import java.util.Iterator;

public interface SimulationResultConsumerI {
	void finishedCycle( int cycle, Iterator<NetInterface> it ) ;
}
