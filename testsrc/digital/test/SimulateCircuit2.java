package digital.test;

import digital.implementation.*;
import digital.interfaces.*;

public class SimulateCircuit2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Building a circuit that only has two inputs, an AND gate, and a D-flip-flop.") ;
		

		Network network = new Network() ;
		
		InputDeviceInterface inputA = network.makeInput("A") ;
		NetInterface a = network.makeNet("a") ;
		a.addPort(  inputA.getPort(0) ) ;

		InputDeviceInterface inputB = network.makeInput("B") ;
		NetInterface b = network.makeNet("b") ;
		b.addPort(  inputB.getPort(0) ) ;

		DeviceInterface andGate = network.makeAndGate("and") ;
		NetInterface c = network.makeNet("c") ;
		c.addPort( andGate.getPort(0) ) ;
		a.addPort( andGate.getPort(1) ) ;
		b.addPort( andGate.getPort(2) ) ;
		
		DeviceInterface ff = network.makeDFlipFlop( "ff" ) ;
		NetInterface d = network.makeNet( "d" ) ;
		d.addPort( ff.getPort(0) ) ;
		c.addPort( ff.getPort(1) ) ;

		System.out.println("The network is built. Now we simulate with inputs 'TFTF' and 'TTFF'.") ;
		inputA.setInputSequence( new Value[] {Value.TRUE, Value.FALSE, Value.TRUE, Value.FALSE} ) ;
		inputB.setInputSequence( new Value[] {Value.TRUE, Value.TRUE, Value.FALSE, Value.FALSE} ) ;
		try {
			network.simulate(6, new PrintingConsumer() ) ; }
		catch( Network.TimeOut ex ) {
			System.out.println( "Circuit did not settle in the required time") ; }
	}

}
