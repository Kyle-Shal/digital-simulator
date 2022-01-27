/**
 * Name: Kyle Shal
 * Student Number: 201923810
 * Email: kashal@mun.ca
 */
package digital.implementation;

import digital.interfaces.PortInterface;
import digital.interfaces.Value;

/**D stands for Delay. D-flip-flops have one output port (port 0) and one input port (port 1).
 *  On each clock edge, the input value is transferred to the output. 
 *  On update, there is no change to the output.
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
