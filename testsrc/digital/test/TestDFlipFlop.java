package digital.test;

import static org.junit.Assert.*;

import org.junit.Test;

import digital.interfaces.*;
import digital.implementation.*;


public class TestDFlipFlop {
	
	@Test public void testConstruction() {
		Network network = new Network() ;
		DeviceInterface ff = network.makeDFlipFlop("ff") ;
		PortInterface c = ff.getPort(0) ;
		PortInterface b = ff.getPort(1) ;
	}
	
	@Test public void testBehaviour() {
		Network network = new Network() ;
		DeviceInterface ff = network.makeDFlipFlop("ff") ;
		PortInterface c = ff.getPort(0) ;
		PortInterface b = ff.getPort(1) ;
		
		b.setValue(Value.TRUE) ;
		ff.clock() ;
		assertEquals( Value.TRUE, c.getValue() ) ;
		ff.update() ;
		assertEquals( Value.TRUE, c.getValue() ) ;
		
		b.setValue(Value.FALSE) ;
		assertEquals( Value.TRUE, c.getValue() ) ;
		ff.update() ;
		assertEquals( Value.TRUE, c.getValue() ) ;
		ff.clock() ;
		assertEquals( Value.FALSE, c.getValue() ) ;
		ff.update() ;
		assertEquals( Value.FALSE, c.getValue() ) ;
		
		b.setValue(Value.UNKNOWN) ;
		assertEquals( Value.FALSE, c.getValue() ) ;
		ff.update() ;
		assertEquals( Value.FALSE, c.getValue() ) ;
		ff.clock() ;
		assertEquals( Value.UNKNOWN, c.getValue() ) ;
		ff.update() ;
		assertEquals( Value.UNKNOWN, c.getValue() ) ;
		
		b.setValue(Value.TRUE) ;
		assertEquals( Value.UNKNOWN, c.getValue() ) ;
		ff.update() ;
		assertEquals( Value.UNKNOWN, c.getValue() ) ;
		ff.clock() ;
		assertEquals( Value.TRUE, c.getValue() ) ;
		ff.update() ;
		assertEquals( Value.TRUE, c.getValue() ) ;
	}
}
