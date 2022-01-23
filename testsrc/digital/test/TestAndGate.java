package digital.test;

import static org.junit.Assert.*;

import org.junit.Test;

import digital.interfaces.*;
import digital.implementation.*;


public class TestAndGate {
	
	@Test public void testConstruction() {
		Network network = new Network() ;
		DeviceInterface gate = network.makeAndGate("gate") ;
		PortInterface c = gate.getPort(0) ;
		PortInterface a = gate.getPort(1) ;
		PortInterface b = gate.getPort(2) ;
	}
	
	@Test public void testBehaviour() {
		Network network = new Network() ;
		DeviceInterface gate = network.makeAndGate("gate") ;
		PortInterface c = gate.getPort(0) ;
		PortInterface a = gate.getPort(1) ;
		PortInterface b = gate.getPort(2) ;
		
		a.setValue(Value.FALSE) ;
		b.setValue(Value.FALSE) ;
		gate.update() ;
		assertEquals( Value.FALSE, c.getValue() ) ;
		gate.clock() ;
		assertEquals( Value.FALSE, c.getValue() ) ;
		
		b.setValue(Value.UNKNOWN) ;
		gate.update() ;
		assertEquals( Value.FALSE, c.getValue() ) ;
		gate.clock() ;
		assertEquals( Value.FALSE, c.getValue() ) ;
		
		b.setValue(Value.TRUE) ;
		gate.update() ;
		assertEquals( Value.FALSE, c.getValue() ) ;
		gate.clock() ;
		assertEquals( Value.FALSE, c.getValue() ) ;
		
		a.setValue(Value.UNKNOWN) ;
		b.setValue(Value.FALSE) ;
		gate.update() ;
		assertEquals( Value.FALSE, c.getValue() ) ;
		gate.clock() ;
		assertEquals( Value.FALSE, c.getValue() ) ;
		
		b.setValue(Value.UNKNOWN) ;
		gate.update() ;
		assertEquals( Value.UNKNOWN, c.getValue() ) ;
		gate.clock() ;
		assertEquals( Value.UNKNOWN, c.getValue() ) ;
		
		b.setValue(Value.TRUE) ;
		gate.update() ;
		assertEquals( Value.UNKNOWN, c.getValue() ) ;
		gate.clock() ;
		assertEquals( Value.UNKNOWN, c.getValue() ) ;
		
		a.setValue(Value.TRUE) ;
		b.setValue(Value.FALSE) ;
		gate.update() ;
		assertEquals( Value.FALSE, c.getValue() ) ;
		gate.clock() ;
		assertEquals( Value.FALSE, c.getValue() ) ;
		
		b.setValue(Value.UNKNOWN) ;
		gate.update() ;
		assertEquals( Value.UNKNOWN, c.getValue() ) ;
		gate.clock() ;
		assertEquals( Value.UNKNOWN, c.getValue() ) ;
		
		b.setValue(Value.TRUE) ;
		gate.update() ;
		assertEquals( Value.TRUE, c.getValue() ) ;
		gate.clock() ;
		assertEquals( Value.TRUE, c.getValue() ) ;
	}
}
