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
public class AndGate extends Device {
	PortInterface inputPort1;
	PortInterface inputPort2;

	public AndGate(String name) {
		super(name);
		inputPort1 = new Port(false);
		ports.add(inputPort1);	
		inputPort2 = new Port(false);
		ports.add(inputPort2);
	}

	@Override
	public boolean update() {
		Value tempValue = inputPort1.getValue();
		Value tempValue2 = inputPort2.getValue();
		
		if(tempValue == tempValue2) {
			outputPort.setValue(tempValue);
		}
		else if(((tempValue == Value.TRUE ) & (tempValue2 == Value.UNKNOWN)) || ((tempValue == Value.UNKNOWN ) & (tempValue2 == Value.TRUE))) {
			outputPort.setValue(Value.UNKNOWN);
		}else {
			outputPort.setValue(Value.FALSE);
		}
		return false;
	}

	@Override
	public void clock() {

	}

}
