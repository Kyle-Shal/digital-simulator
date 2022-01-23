package digital.test;

import org.junit.Test;

import digital.implementation.Network;
import digital.implementation.RecordingConsumer;
import digital.interfaces.DeviceInterface;
import digital.interfaces.InputDeviceInterface;
import digital.interfaces.NetInterface;
import digital.interfaces.Value;
import static digital.interfaces.Value.*;
import static org.junit.Assert.*;


public class TestCircuit1 {
	@Test public void testCircuit() {
		// Building a circuit that only has an input, and one flip-flop.
		Network network = new Network() ;
		
		InputDeviceInterface inputA = network.makeInput("A") ;

		NetInterface a = network.makeNet("a") ;
		a.addPort(  inputA.getPort(0) ) ;

		DeviceInterface flipFlop = network.makeDFlipFlop( "FF" ) ;
		a.addPort( flipFlop.getPort(1) ) ;

		NetInterface b = network.makeNet("b") ;
		b.addPort( flipFlop.getPort(0) ) ;

		//The network is built. Now we simulate with input 'TTFTFF'.
		inputA.setInputSequence( new Value[] {Value.TRUE, Value.TRUE, Value.FALSE, Value.TRUE, Value.FALSE, Value.FALSE} ) ;
		RecordingConsumer recorder = new RecordingConsumer() ;
		try {
			network.simulate(7, recorder ) ; }
		catch( Network.TimeOut ex ) {
			assertTrue("Circuit has timed out", false ) ; }
		
		assertEquals( TRUE, recorder.getValue(0, "a") ) ;
		assertEquals( UNKNOWN, recorder.getValue(0, "b") ) ;
		
		assertEquals( TRUE, recorder.getValue(1, "a") ) ;
		assertEquals( TRUE, recorder.getValue(1, "b") ) ;
		
		assertEquals( FALSE, recorder.getValue(2, "a") ) ;
		assertEquals( TRUE, recorder.getValue(2, "b") ) ;
		
		assertEquals( TRUE, recorder.getValue(3, "a") ) ;
		assertEquals( FALSE, recorder.getValue(3, "b") ) ;
		
		assertEquals( FALSE, recorder.getValue(4, "a") ) ;
		assertEquals( TRUE, recorder.getValue(4, "b") ) ;
		
		assertEquals( FALSE, recorder.getValue(5, "a") ) ;
		assertEquals( FALSE, recorder.getValue(5, "b") ) ;
		
		assertEquals( UNKNOWN, recorder.getValue(6, "a") ) ;
		assertEquals( FALSE, recorder.getValue(6, "b") ) ;
	}
}
