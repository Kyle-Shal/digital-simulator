package digital.implementation;

import util.Assert;
import java.util.* ;

import digital.interfaces.*;

/** A Network is a collection of digital devices and nets.
 * <p>The network can be simulated.
 * @author Theodore Norvell
 *
 */
public class Network {

	/** A set of devices. No two devices may have the same name. */
	private List<DeviceInterface> devices = new ArrayList<DeviceInterface>() ;

	/** A set of nets (wires). No two nets may have the same name. */
	private List<NetInterface> nets = new ArrayList<NetInterface>() ;

	/** This factory is used to create the devices and nets. */
	private DigitalFactory factory = new DigitalFactory() ;

	/** Create an input device.
	 * <p> The new device is added to the network and returned.
	 * @param name a unique name for the device.
	 * @return the new device
	 */
	public InputDeviceInterface makeInput( String name ) {
		Assert.check( getDeviceByName(name)==null, "Device name is not unique." ) ;
		InputDeviceInterface device = factory.makeNewInput( name ) ;
		devices.add( device ) ;
		return device ; }

	/** Create an and-gate device.
	 * <p> The new device is added to the network and returned.
	 * @param name a unique name for the device.
	 * @return the new device
	 */
	public DeviceInterface makeAndGate( String name ) {
		Assert.check( getDeviceByName(name)==null, "Device name is not unique." ) ;
		DeviceInterface device = factory.makeNewAndGate( name ) ;
		devices.add( device ) ;
		return device ; }

	/** Create an or-gate device.
	 * <p> The new device is added to the network and returned.
	 * @param name a unique name for the device.
	 * @return the new device
	 */
	public DeviceInterface makeOrGate( String name ) {
		Assert.check( getDeviceByName(name)==null, "Device name is not unique." ) ;
		DeviceInterface device = factory.makeNewOrGate( name ) ;
		devices.add( device ) ;
		return device ; }

	/** Create a not-gate device.
	 * <p> The new device is added to the network and returned.
	 * @param name a unique name for the device.
	 * @return the new device
	 */
	public DeviceInterface makeNotGate( String name ) {
		Assert.check( getDeviceByName(name)==null, "Device name is not unique." ) ;
		DeviceInterface device = factory.makeNewNotGate( name ) ;
		devices.add( device ) ;
		return device ; }

	/** Create a D-flip-flop device.
	 * <p> The new device is added to the network and returned.
	 * @param name a unique name for the device.
	 * @return the new device
	 */
	public DeviceInterface makeDFlipFlop( String name ) {
		Assert.check( getDeviceByName(name)==null, "Device name is not unique." ) ;
		DeviceInterface device = factory.makeNewDFlipFlop( name ) ;
		devices.add( device ) ;
		return device ; }

	/** Create a net.
	 * <p> The new net is added to the network and returned.
	 * @param name a unique name for the net.
	 * @return the new net
	 */
	public NetInterface makeNet( String name ) {
		Assert.check( getNetByName(name)==null, "Net name is not unique." ) ;
		NetInterface net = factory.makeNewNet( name ) ;
		nets.add( net ) ;
		return net ; }

	/** Get the device with the give name.
	 * 
	 * @param name
	 * @return Null if no device has the name, otherwise the device.
	 */
	public DeviceInterface getDeviceByName( String name ) {
		for( DeviceInterface d : devices ) {
			if( d.getName().equals( name ) ) return d ; }
		return null ;
	}

	/** Get the net with the given name.
	 * 
	 * @param name
	 * @return null if no net has the name, otherwise the net.
	 */
	public NetInterface getNetByName( String name ) {
		for( NetInterface net : nets ) {
			if( net.getName().equals( name ) ) return net ; }
		return null ;
	}

	public Iterator<NetInterface> getNetIterator() {
		return nets.iterator() ;
	}

	/** Simulate the network for a given number of clock cycles.
	 * <p>Precondition: Each net in the network should be connected to
	 * exactly one output port and
	 * the network should be set up so as to always stabilize between clock edges.
	 * <p>Prior to simulation any input devices should have been loaded with
	 * values that will be input into the simulation.
	 * @param clocks The number of clock cycles the simulation will run.
	 * @param consumer An object that is alerted at the end of each clock cycle.
	 */
	public void simulate(int clocks, SimulationResultConsumerI consumer) 
			throws TimeOut {
		for( int c = 0 ; c < clocks ; ++c ) {
			for( DeviceInterface d : devices ) d.clock() ;
			int i = 1000 ;
			while( i > 0 ) {
				boolean change = false ;
				for( NetInterface n : nets ) change = n.update() || change ;
				for( DeviceInterface d : devices ) change = d.update() || change ;
				if( ! change ) break ; 
				i -= 1 ; }
			if( i==0 ) throw new TimeOut() ;
			consumer.finishedCycle( c, getNetIterator() ) ; }
	}

	public static class TimeOut extends Exception { } 
}
