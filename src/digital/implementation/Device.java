/**
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
	protected String name;
	protected List<PortInterface> ports = new ArrayList<PortInterface>() ;
	protected PortInterface outputPort;
	
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
