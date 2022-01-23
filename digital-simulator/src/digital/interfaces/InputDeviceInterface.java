package digital.interfaces;

/** An input device is a device that serves as a source of input.
 * You can load an input device with a sequence of values.
 * <p>If no sequence has been loaded the value of the sole output
 * port will be UNKOWN. After the sequence has been loaded the
 * value will be as described under <code>setInputSequence</code> 
 * 
 * @author Theodore Norvell
 *
 */
public interface InputDeviceInterface extends DeviceInterface {
	/** Load  the input device with a sequence of values.
	 * <p>
	 * Immediately after the sequence has been loaded, the value of the sole
	 * output port will be UNKNOWN.
	 * <p>
	 * After the first clock edge,
	 * the value of the output port will be <code>values[0]</code>, after the
	 * second clock edge, the value of the output port will be
	 * <code>values[1]</code>, and so on.
	 * <p>
	 * Once the values in the <code>values</code> array
	 * are exhausted, the value on the output port will be UNKNOWN.
	 * 
	 * @param values
	 */
	void setInputSequence( Value[] values ) ;
}
