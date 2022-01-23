package digital.test;

import static org.junit.Assert.*;

import org.junit.Test;

import digital.interfaces.*;
import digital.implementation.*;


public class TestNotGate {
	
	@Test public void testConstruction() {
		Network network = new Network() ;
		DeviceInterface gate = network.makeNotGate("gate") ;
		PortInterface c = gate.getPort(0) ;
		PortInterface b = gate.getPort(1) ;
	}
	
	@Test public void testBehaviour() {
		Network network = new Network() ;
		DeviceInterface gate = network.makeNotGate("gate") ;
		PortInterface c = gate.getPort(0) ;
		PortInterface b = gate.getPort(1) ;
		
		b.setValue(Value.TRUE) ;
		gate.update() ;
		assertEquals( Value.FALSE, c.getValue() ) ;
		gate.clock() ;
		assertEquals( Value.FALSE, c.getValue() ) ;
		
		b.setValue(Value.FALSE) ;
		gate.update() ;
		assertEquals( Value.TRUE, c.getValue() ) ;
		gate.clock() ;
		assertEquals( Value.TRUE, c.getValue() ) ;
		
		b.setValue(Value.UNKNOWN) ;
		gate.update() ;
		assertEquals( Value.UNKNOWN, c.getValue() ) ;
		gate.clock() ;
		assertEquals( Value.UNKNOWN, c.getValue() ) ;
	}
}
