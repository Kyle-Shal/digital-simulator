/**
 * 
 */
package digital.implementation;

import java.util.ArrayList;
import java.util.List;

import digital.interfaces.DeviceInterface;
import digital.interfaces.PortInterface;

/**
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
