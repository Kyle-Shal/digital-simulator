/** This file was prepared by Kyle Shal. It was completed by me alone.
 * Name: Kyle Shal
 * Student Number: 201923810
 * Email: kashal@mun.ca
 */
package digital.implementation;

import digital.interfaces.PortInterface;
import digital.interfaces.Value;

/** Each Or Gate is a device with two input ports and one output port.
 * Or Gates ignore clock edges.
 * <p>In response to each update message, they update their output ports
 * according to the following truth table:
 * 
 *   F U T
 * F|F|U|T
 * U|U|U|T
 * T|T|T|T
 * @author kyles
 *
 */
public class OrGate extends Device {
	/** An Or gate has two input ports*/
	PortInterface inputPort1;
	PortInterface inputPort2;
	
	/** Create an Or Gate with a name, two input ports and an output port
	 * 
	 * @param name The name of the Or Gate.
	 */
	public OrGate(String name) {
		super(name);
		inputPort1 = new Port(false);
		ports.add(inputPort1);	
		inputPort2 = new Port(false);
		ports.add(inputPort2);	}

	@Override
	public boolean update() {
		/** Temporarily hold the values of the input and output ports*/
		Value tempValue = inputPort1.getValue();
		Value tempValue2 = inputPort2.getValue();
		Value oldOutputValue = outputPort.getValue();

		/**Compare the values of the input ports for the output value based on the Or truth table */
		if (tempValue == Value.TRUE || tempValue2 == Value.TRUE) {
			outputPort.setValue(Value.TRUE);
			if (oldOutputValue != Value.TRUE) {
				return true;
			}
		}else if(tempValue == Value.FALSE && tempValue2 == Value.FALSE) {
			outputPort.setValue(Value.FALSE);
			if (oldOutputValue != Value.FALSE) {
				return true;
			}
			
		}else if (tempValue == Value.UNKNOWN || tempValue2 == Value.UNKNOWN) {
			outputPort.setValue(Value.UNKNOWN);
			if (oldOutputValue != Value.UNKNOWN) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void clock() {}

}
