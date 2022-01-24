package digital.implementation;

import digital.interfaces.InputDeviceInterface;
import digital.interfaces.PortInterface;
import digital.interfaces.Value;

/** Design for an input device
 */	
public class InputDevice extends Device implements InputDeviceInterface{
	
	Value[] values;
	int clockCounter = 0;
	
	public InputDevice(String name) {
		super(name);
	}

	@Override
	public void setInputSequence(Value[] values) {
		this.values = values;		
	}

	@Override
	public boolean update() {
		return false;
	}

	@Override
	public void clock() {
		if (clockCounter < values.length) {
			outputPort.setValue(values[clockCounter]);
			clockCounter =clockCounter +1;
		}else {
			outputPort.setValue(Value.UNKNOWN);
		}		
	}
	

}
