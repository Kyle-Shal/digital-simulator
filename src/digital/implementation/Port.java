/**
 * Name: Kyle Shal
 * Student Number: 201923810
 * Email: kashal@mun.ca
 */
package digital.implementation;
import digital.interfaces.*;

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
 * @author kyles
 *
 */
public class Port implements PortInterface{
	boolean isOutputPort;
	private Value portValue = Value.UNKNOWN;
	
	Port(boolean isOutputPort){
		this.isOutputPort = isOutputPort;
		
	}
	@Override
	public boolean isOutputPort() {
		return isOutputPort;
	}

	@Override
	public void setValue(Value v) {
		this.portValue = v;
		
	}

	@Override
	public Value getValue() {
		return portValue;
	}

}
