package digital.test;

import digital.implementation.*;
import digital.interfaces.*;

public class SimulateCircuit1 {

	/** This example simply tests an input device. The network is
	 * 
	 * +-----------+    a   +---------------+    b
	 * | A : input |>------>| FF: DFlipFlop |>-----------
	 * +-----------+        +---------------+
	 */
	public static void main(String[] args) {
		
		System.out.println("Building a circuit that only has an input, and one flip-flop.") ;
		Network network = new Network() ;
		
		InputDeviceInterface inputA = network.makeInput("A") ;
		
		NetInterface a = network.makeNet("a") ;
		a.addPort(  inputA.getPort(0) ) ;
		
		DeviceInterface flipFlop = network.makeDFlipFlop( "FF" ) ;
		a.addPort( flipFlop.getPort(1) ) ;
		
		NetInterface b = network.makeNet("b") ;
		b.addPort( flipFlop.getPort(0) ) ;

		System.out.println("The network is built. Now we simulate with input 'TTFTFF'.") ;
		inputA.setInputSequence( new Value[] {Value.TRUE, Value.TRUE, Value.FALSE, Value.TRUE, Value.FALSE, Value.FALSE} ) ;
		try {
			network.simulate(7, new PrintingConsumer() ) ; }
		catch( Network.TimeOut ex ) {
			System.out.println( "Circuit did not settle in the required time") ; }
	}

}
