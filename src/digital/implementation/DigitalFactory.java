package digital.implementation;

import util.Assert;
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
		//Creates an in instance of the InputDevice Class
		InputDevice iDevice = new InputDevice(name);
		//Assert.toBeDone() ; return null ;
		return iDevice;
	}

	public DeviceInterface makeNewAndGate(String name) {
		AndGate andGate = new AndGate(name);
		return andGate;
	}

	public DeviceInterface makeNewNotGate(String name) {
		Assert.toBeDone() ; return null ;
	}

	public DeviceInterface makeNewOrGate(String name) {
		Assert.toBeDone() ; return null ;
	}

	public DeviceInterface makeNewDFlipFlop(String name) {
		//Creates an instance of the DFLipFLop
		DFlipFlop flipFlop = new DFlipFlop(name);
		return flipFlop ;
	}
}
