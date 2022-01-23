package digital.test;

import static org.junit.Assert.*;

import org.junit.Test;

import digital.interfaces.*;
import digital.implementation.*;


public class TestInput {
	
	@Test public void testConstruction() {
		Network network = new Network() ;
		InputDeviceInterface gate = network.makeInput("test") ;
		PortInterface a = gate.getPort(0) ;
	}
	
	// Since there is (presumably) no public way to make a port without making a device, we
	// test the Port class here.
	@Test public void testPort() {
		Network network = new Network() ;
		InputDeviceInterface gate = network.makeInput("test") ;
		PortInterface a = gate.getPort(0) ;
		
		a.setValue( Value.TRUE ) ;
		assertEquals( Value.TRUE, a.getValue() ) ;
		
		a.setValue( Value.FALSE ) ;
		assertEquals( Value.FALSE, a.getValue() ) ;
		
		a.setValue( Value.UNKNOWN ) ;
		assertEquals( Value.UNKNOWN, a.getValue() ) ;	
	}
	
	@Test public void testBehaviour() {
		Network network = new Network() ;
		InputDeviceInterface gate = network.makeInput("test") ;
		PortInterface a = gate.getPort(0) ;
		
		gate.setInputSequence( new Value[]
		  { Value.TRUE, Value.UNKNOWN, Value.FALSE } ) ;
		
		gate.clock() ;
		assertEquals( Value.TRUE, a.getValue() ) ;
		gate.update() ;
		assertEquals( Value.TRUE, a.getValue() ) ;
		
		
		gate.clock() ;
		assertEquals( Value.UNKNOWN, a.getValue() ) ;
		gate.update() ;
		assertEquals( Value.UNKNOWN, a.getValue() ) ;
		
		gate.clock() ;
		assertEquals( Value.FALSE, a.getValue() ) ;
		gate.update() ;
		assertEquals( Value.FALSE, a.getValue() ) ;
		
		gate.clock() ;
		assertEquals( Value.UNKNOWN, a.getValue() ) ;
		gate.update() ;
		assertEquals( Value.UNKNOWN, a.getValue() ) ;
	}
}
