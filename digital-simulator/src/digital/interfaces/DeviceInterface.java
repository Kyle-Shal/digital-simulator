package digital.interfaces;

/** Each DeviceInterface object represents some physical device in a network.
 * <p>Each device is associated with a fixed set of ports.
 * <p>Each device connects to other devices via nets via its ports.
 * @author Theodore Norvell
 *
 */
public interface DeviceInterface {
	
	/** The name of this device */
	String getName() ;
	
	/** How many ports does this device have */
	int numberOfPorts() ;
	
	/** Get the given port.
	 * <p>Precondition: 0 <= portNumber < numberOfPorts() 
	 * @param portNumber
	 * @return The port
	 */
	PortInterface getPort( int portNumber ) ;
	
	/** Update the output in response to asynchronous changes to
	 * its inputs.
	 * 
	 * @return True if the call results in a change to the value of any output port.
	 * Otherwise, if no output ports change value, false. 
	 */
	boolean update() ;
	
	/** Update the output in response to a clock edge.
	 * 
	 */
	void clock() ;
}
