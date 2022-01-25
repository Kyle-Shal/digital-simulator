/**
 * 
 */
package digital.implementation;

import digital.interfaces.PortInterface;
import digital.interfaces.Value;

/**
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
