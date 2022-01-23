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


public class TestCircuit2 {
	@Test public void testCircuit() {
		// Building a circuit that only has two inputs, an AND gate, and a D-flip-flop.
		

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

		// The network is built. Now we simulate with inputs 'TFTF' and 'TTFF'.
		inputA.setInputSequence( new Value[] {Value.TRUE, Value.FALSE, Value.TRUE, Value.FALSE} ) ;
		inputB.setInputSequence( new Value[] {Value.TRUE, Value.TRUE, Value.FALSE, Value.FALSE} ) ;
		RecordingConsumer recorder = new RecordingConsumer() ;
		try {
			network.simulate(7, recorder ) ; }
		catch( Network.TimeOut ex ) {
			assertTrue("Circuit has timed out", false ) ; }
		
		assertEquals( TRUE, recorder.getValue(0, "a" ) ) ;
		assertEquals( TRUE, recorder.getValue(0, "b" ) ) ;
		assertEquals( TRUE, recorder.getValue(0, "c" ) ) ;
		assertEquals( UNKNOWN, recorder.getValue(0, "d" ) ) ;
		
		assertEquals( FALSE, recorder.getValue(1, "a" ) ) ;
		assertEquals( TRUE, recorder.getValue(1, "b" ) ) ;
		assertEquals( FALSE, recorder.getValue(1, "c" ) ) ;
		assertEquals( TRUE, recorder.getValue(1, "d" ) ) ;
		
		assertEquals( TRUE, recorder.getValue(2, "a" ) ) ;
		assertEquals( FALSE, recorder.getValue(2, "b" ) ) ;
		assertEquals( FALSE, recorder.getValue(2, "c" ) ) ;
		assertEquals( FALSE, recorder.getValue(2, "d" ) ) ;
		
		assertEquals( FALSE, recorder.getValue(3, "a" ) ) ;
		assertEquals( FALSE, recorder.getValue(3, "b" ) ) ;
		assertEquals( FALSE, recorder.getValue(3, "c" ) ) ;
		assertEquals( FALSE, recorder.getValue(3, "d" ) ) ;
		
		assertEquals( UNKNOWN, recorder.getValue(4, "a" ) ) ;
		assertEquals( UNKNOWN, recorder.getValue(4, "b" ) ) ;
		assertEquals( UNKNOWN, recorder.getValue(4, "c" ) ) ;
		assertEquals( FALSE, recorder.getValue(4, "d" ) ) ;
		
		assertEquals( UNKNOWN, recorder.getValue(5, "a" ) ) ;
		assertEquals( UNKNOWN, recorder.getValue(5, "b" ) ) ;
		assertEquals( UNKNOWN, recorder.getValue(5, "c" ) ) ;
		assertEquals( UNKNOWN, recorder.getValue(5, "d" ) ) ;
	}
}
