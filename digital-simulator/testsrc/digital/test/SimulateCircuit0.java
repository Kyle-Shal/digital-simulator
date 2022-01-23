package digital.test;

import digital.implementation.*;
import digital.interfaces.*;

public class SimulateCircuit0 {

	/** This example simply tests an input device. The network is
	 * 
	 * +---+      a
	 * | A |>-------
	 * +---+
	 */
	public static void main(String[] args) {
		System.out.println("Building a circuit that only has an input and one net.") ;
		
		Network network = new Network() ;
		
		InputDeviceInterface inputA = network.makeInput("A") ;
		NetInterface a = network.makeNet("a") ;
		a.addPort(  inputA.getPort(0) ) ;
		
		System.out.println("The network is built. Now we simulate with input 'TFTF'.") ;
		inputA.setInputSequence( new Value[] {Value.TRUE, Value.FALSE, Value.TRUE, Value.FALSE} ) ;
		try {
			network.simulate(6, new PrintingConsumer() ) ; }
		catch( Network.TimeOut ex ) {
			System.out.println( "Circuit did not settle in the required time") ; }
	}

}
