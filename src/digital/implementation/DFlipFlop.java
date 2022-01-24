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
public class DFlipFlop extends Device{
	PortInterface inputPort;
	
	public DFlipFlop(String name) {
		super(name);
		this.inputPort = new Port(false);
		ports.add(inputPort);
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
