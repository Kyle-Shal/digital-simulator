package digital.implementation;
import digital.interfaces.*;

public class Port implements PortInterface{
	boolean isOutputPort;
	private Value portValue;
	
	Port(boolean isOutputPort){
		this.isOutputPort = isOutputPort;
		
	}
	@Override
	public boolean isOutputPort() {
		return isOutputPort;
	}

	@Override
	public void setValue(Value v) {
		this.portValue = v;
		
	}

	@Override
	public Value getValue() {
		return portValue;
	}

}
