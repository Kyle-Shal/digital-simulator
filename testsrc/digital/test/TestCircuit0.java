package digital.test;

import org.junit.Test;

import digital.implementation.Network;
import digital.implementation.RecordingConsumer;
import digital.interfaces.InputDeviceInterface;
import digital.interfaces.NetInterface;
import digital.interfaces.Value;
import static digital.interfaces.Value.*;
import static org.junit.Assert.*;


public class TestCircuit0 {
	@Test public void testCircuit() {
		 // Testing a circuit that only has an input and one net.
		
		Network network = new Network() ;
		
		InputDeviceInterface inputA = network.makeInput("A") ;
		NetInterface a = network.makeNet("a") ;
		a.addPort(  inputA.getPort(0) ) ;
		
		inputA.setInputSequence( new Value[] {Value.TRUE, Value.FALSE, Value.TRUE, Value.FALSE} ) ;
		RecordingConsumer recorder = new RecordingConsumer() ;
		try {
			network.simulate(6, recorder ) ; }
		catch( Network.TimeOut ex ) {
			assertTrue("Circuit has timed out", false ) ; }
		
		assertEquals( TRUE   , recorder.getValue(0, "a") ) ;
		assertEquals( FALSE  , recorder.getValue(1, "a") ) ;
		assertEquals( TRUE   , recorder.getValue(2, "a") ) ;
		assertEquals( FALSE  , recorder.getValue(3, "a") ) ;
		assertEquals( UNKNOWN, recorder.getValue(4, "a") ) ;
		assertEquals( UNKNOWN, recorder.getValue(5, "a") ) ;
	}
}
