package digital.implementation;

import digital.interfaces.InputDeviceInterface;
import digital.interfaces.PortInterface;
import digital.interfaces.Value;

public class InputDevice implements InputDeviceInterface{
	private String name;
	/** Every input device has 0 or at most 1 output port.
	 */	
	PortInterface port;

	Value[] values;
	int clockCounter=0;
	
	
	InputDevice(String name) {
		this.name = name;
		port = new Port(true);
		
		
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int numberOfPorts() {
		return 1;
	}

	@Override
	public PortInterface getPort(int portNumber) {
		return port;
	}

	@Override
	public boolean update() {  
		return false;
	}

	@Override
	public void clock() {
		if (clockCounter < values.length) {
			port.setValue(values[clockCounter]);
			clockCounter =clockCounter +1;
		}else {
			port.setValue(Value.UNKNOWN);
		}	
	}

	@Override
	public void setInputSequence(Value[] values) {
		this.values = values;
	}

}
