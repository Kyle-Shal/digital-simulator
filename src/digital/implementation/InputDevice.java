/** This file was prepared by Kyle Shal. It was completed by me alone.
 * Name: Kyle Shal
 * Student Number: 201923810
 * Email: kashal@mun.ca
 */
package digital.implementation;

import digital.interfaces.InputDeviceInterface;
import digital.interfaces.PortInterface;
import digital.interfaces.Value;

/** An input device is a device that serves as a source of input.
 * You can load an input device with a sequence of values.
 * <p>If no sequence has been loaded the value of the sole output
 * port will be UNKNOWN. After the sequence has been loaded the
 * value will be as described under <code>setInputSequence</code> 
 * <p> And input device has no input ports
 * 
 * @author kyles
 *
 */
public class InputDevice extends Device implements InputDeviceInterface{
	
	/** Sequence of values that the input device will be loaded with */
	Value[] values;
	/** Holds the number of times the clock function is called */
	int clockCounter = 0;
	
	/** Create an Input device with the name given
	 * 
	 * @param name The name of the input device.
	 */
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
