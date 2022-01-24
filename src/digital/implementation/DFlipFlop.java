/**
 * 
 */
package digital.implementation;

import java.util.ArrayList;
import java.util.List;

import digital.interfaces.DeviceInterface;
import digital.interfaces.PortInterface;
import digital.interfaces.Value;
import util.Assert;

/**
 * @author kyles
 *
 */
public class DFlipFlop implements DeviceInterface{
	private String name;
	private int outputPortIndex = 0;
	private int inputPortIndex = 1;
	PortInterface outputPort;
	PortInterface inputPort;
	
	
	DFlipFlop(String name){
		this.name = name;
		outputPort = new Port(true);
		inputPort = new Port(false);		
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int numberOfPorts() {
		return 2;
	}

	@Override
	public PortInterface getPort(int portNumber) {
		PortInterface tempPort;
		
		if (portNumber == 0) {
			tempPort = outputPort;
		}else {
			tempPort = inputPort;
		}
		return tempPort;
	}

	@Override
	public boolean update() {
		return false;	
	}

	@Override
	public void clock() {
		Value value1 = inputPort.getValue();
		outputPort.setValue(value1);
		
	}

}
