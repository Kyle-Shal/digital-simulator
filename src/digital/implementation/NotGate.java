/**
 * Name: Kyle Shal
 * Student Number: 201923810
 * Email: kashal@mun.ca
 */
package digital.implementation;

import digital.interfaces.PortInterface;
import digital.interfaces.Value;

/** Each Not Gate is a device with one input port and one output port.
 * Not Gates ignore clock edges.
 * <p>In response to each update message, they update their output ports
 * according to the following truth table:
 * 
 * F|T
 * U|U
 * T|F
 * @author kyles
 *
 */
public class NotGate extends Device {
	PortInterface inputPort;
	
	public NotGate(String name) {
		super(name);
		inputPort = new Port(false);
		ports.add(inputPort);
	}

	@Override
	public boolean update() {
		if (inputPort.getValue() == Value.TRUE) {
			outputPort.setValue(Value.FALSE);
			return true;
		}else if (inputPort.getValue() == Value.FALSE) {
			outputPort.setValue(Value.TRUE);
			return true;
		}else if(inputPort.getValue() == Value.UNKNOWN) {
			outputPort.setValue(Value.UNKNOWN);
			return true;
		}
		return false;
	}

	@Override
	public void clock() {

	}

}
