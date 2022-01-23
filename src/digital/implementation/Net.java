package digital.implementation;

import java.util.ArrayList;
import java.util.List;

import digital.interfaces.NetInterface ;
import digital.interfaces.PortInterface;
import digital.interfaces.Value;

import util.Assert;

/** Nets carry information between devices' ports.
 * You can think of a Net as being an ideal wire. 
 * 
 * @author Theodore Norvell
 *
 */
public class Net implements NetInterface {

	/** Every net has a name. */
	private String name ;
	
	/** Every net is connected to a set of ports.
	 * At most one of these can be an output port.
	 */
	private List<PortInterface> ports = new ArrayList<PortInterface>() ;
	
	/** outputPortindex indicates which port, if any, is the output port.
	 * A value of -1 indicates that there is no connected output port.
	* It is an invariant that there are 0 or 1 output ports.
	* <p>Class Invariant: <code>outputPortIndex == -1 or
	*                           (0 <= outputPortIndex
	*                            and outputPortIndex < ports.size())</code>
	*/
	private int outputPortIndex = -1 ;
	
	/** Create a net with the given name and, initially, connected to no ports. 
	 * 
	 * @param name The name of the net.
	 */
	Net(String name ) {
		this.name = name ;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getNumberOfPorts() {
		return ports.size() ;
	}

	@Override
	public PortInterface getPort(int i) {
		return ports.get(i) ;
	}

	@Override
	public boolean update() {
		Assert.check( outputPortIndex != -1, "No output port set for net "+name ) ;
		Value value = ports.get( outputPortIndex ).getValue() ;
		boolean change = false ;
		for( int i=0 ; i < ports.size(); ++i ) {
			if( i != outputPortIndex ) {
				Value oldValue = ports.get(i).getValue() ;
				ports.get(i).setValue( value ) ;
				change = change || oldValue != value ; } }
		return change ;
	}
	
	@Override
	public void addPort( PortInterface p ) {
		Assert.check( outputPortIndex == -1 || ! p.isOutputPort(),
				"Net "+name+" already has an output port." ) ;
		if( p.isOutputPort() ) outputPortIndex = ports.size() ;
		ports.add( p ) ;
	}

	@Override
	public Value getValue() {
		Assert.check( outputPortIndex != -1,
				"Net "+name+" does not have an output port." ) ;
		return ports.get( outputPortIndex ).getValue() ;
	}
}
