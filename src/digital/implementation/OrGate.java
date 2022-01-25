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
public class OrGate extends Device {
	PortInterface inputPort1;
	PortInterface inputPort2;
	
	public OrGate(String name) {
		super(name);
		inputPort1 = new Port(false);
		ports.add(inputPort1);	
		inputPort2 = new Port(false);
		ports.add(inputPort2);	}

	@Override
	public boolean update() {
		Value tempValue = inputPort1.getValue();
		Value tempValue2 = inputPort2.getValue();
		Value oldOutputValue = outputPort.getValue();

		
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
