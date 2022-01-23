package digital.interfaces;

/** A net connects a number of devices together.
 * Each net is connected to 0 or more ports on
 * 0 or more devices.
 * 
 * <p> Information travels over nets instantaneously
 * and without degradation.
 * 
 * @author Theodore Norvell
 *
 */
public interface NetInterface {
	
	/** The name of the net.
	 * <p>Within one network, nets should have unique names.
	 * <p>Net names should follow the following conventions
	 * <ul><li>Names are nonempty and begin with a letter.
	 *     <li>Each character is either a letter or a digit.
	 * </ul>
	 * 
	 * @return
	 */
	String getName() ;

	/** The number of ports that the net is currently connected to.
	 * 
	 * @return
	 */
	int getNumberOfPorts() ;
	
	/** A port that is connected to the net.
	 * <p>Precondition: 0 <= i && i < getNumberOfPorts()
	 * <p>Postcondition: result.getNet() == this
	 * @param i
	 * @return A port that is connected to the net.
	 */
	PortInterface getPort( int i ) ;
	
	/** Update the state of the net
	 * <p>Precondition: Exactly one port is an output port.
	 * <p>Effect: The value of the output port is transferred to all input ports.
	 * @return true if there is any change to the value of any connected input port.
	 */
	boolean update() ;

	/** Add a port.
	 * <p>Precondition: If the net is already connected to an output port,
	 * p must not be an output port. I.e. each net is connected to at most
	 * one output port. 
	 * 
	 * @param p
	 */
	void addPort(PortInterface p);

	/** Get the current value of the net.
	 * <p>Precondition: Exactly one port is an output port.
	 * @return the value of the net's output port.
	 */
	Value getValue();
}
