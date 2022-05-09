/* This file was prepared by Kyle Shal. It was completed by me alone.
 * Name: Kyle Shal
 * Student Number: 201923810
 * Email: kashal@mun.ca
 */
package digital.implementation;

import digital.interfaces.DeviceInterface;
import digital.interfaces.InputDeviceInterface;
import digital.interfaces.NetInterface;

/** A factory class for various types of devices and nets.
 * <p>This is not a public class, it is intended to be used
 * by the Network class, which will take care of adding the
 * devices and nets to a network.
 * 
 * @author Theodore Norvell
 *
 */
class DigitalFactory {

	public NetInterface makeNewNet(String name) {
		return new Net( name ) ;
	}

	public InputDeviceInterface makeNewInput(String name) {
		InputDevice iDevice = new InputDevice(name);
		return iDevice;
	}

	public DeviceInterface makeNewAndGate(String name) {
		AndGate andGate = new AndGate(name);
		return andGate;
	}

	public DeviceInterface makeNewNotGate(String name) {
		NotGate notGate = new NotGate(name);
		return notGate;
	}

	public DeviceInterface makeNewOrGate(String name) {
		OrGate orGate = new OrGate(name);
		return orGate;	}

	public DeviceInterface makeNewDFlipFlop(String name) {
		//Creates an instance of the DFLipFLop
		DFlipFlop flipFlop = new DFlipFlop(name);
		return flipFlop ;
	}
}
