/** This file was prepared by Kyle Shal. It was completed by me alone.
 * Name: Kyle Shal
 * Student Number: 201923810
 * Email: kashal@mun.ca
 */
package digital.implementation;

import java.util.ArrayList;
import java.util.List;

import digital.interfaces.DeviceInterface;
import digital.interfaces.PortInterface;

/** Each Device object represents some physical device in a network.
 * <p>Each device is associated with a fixed set of ports.
 * <p>Each device connects to other devices via nets via its ports.
 * @author kyles
 *
 */
public abstract class Device implements DeviceInterface {
	
	/** The name of the device*/
	protected String name;
	/** The list of ports that a device has*/
	protected List<PortInterface> ports = new ArrayList<PortInterface>() ;
	/** All devices have an output port*/
	protected PortInterface outputPort;
	
	/** Create a device with a name and an output port
	 * 
	 * @param name The name of the device
	 */
	public Device(String name) {
		this.name = name;
		outputPort = new Port(true);
		ports.add(outputPort);
	}
	
	public String getName() {
		return name;
	}

	public int numberOfPorts() {
		return ports.size();
	}

	public PortInterface getPort(int portNumber) {
		return ports.get(portNumber);
	}

	public abstract boolean update();

	public abstract void clock();

}
