/**
 * 
 */
package digital.interfaces;

/** An enumeration of boolean values for simulation.
 * <p>While ordinary boolean logic uses 2 values.
 * It is common in simulation to use at least 3 values.
 * The third value that we use is UNKNOWN, which
 * simply means that we don't know the actual value.
 * 
 * @author Theodore Norvell
 *
 */
public enum Value {
	FALSE,
	UNKNOWN,
	TRUE
}
