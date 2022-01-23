package digital.interfaces;

/** A port is a point of connection between
 * a device and an net.
 * <p>
 * Each port is associated with 1 device
 * and with 0 or one net.
 * <p>
 * Each port is either an input port or an output port.
 * 
 * <p> As an invariant: For any port <code>p</code> and net <code>n</code>:
 * <pre>            (p.isConnected() &&  n==p.getNet())
 * exactly if (there is an i in {0,1,..,n.getNumberOfPorts()-1}
 *             such that n.getPort(i)==p) 
 * </pre>
 * @author Theodore Norvell
 *
 */
public interface PortInterface {

	/** Is this port an output port of its device.
	 * 
	 * @return true exactly if this is an output port
	 */
	boolean isOutputPort() ;
	
	/** Change the value of the port.
	 * 
	 * @param v The new value
	 */
	void setValue(Value v) ;
	
	/** Get the current value of the port.
	 * <p> If the value has never been set, the
	 * value will be Value.UNKNOWN.
	 * 
	 * @return The current value of the port.
	 */
	Value getValue() ;
}
