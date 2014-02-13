package hambergerkalaunerorosz;

/**
 * Cipher
 * 
 * @author Paul Kalauner 3AHIT
 * 
 */
public interface Cipher {

	/**
	 * Verschl�sselungsmethode
	 * 
	 * @param text
	 *            der zu verschl�sselnde Text
	 * @return verschl�sselter Text
	 */
	public String encrypt(String text);

	/**
	 * Entschlüsselungsmethode
	 * 
	 * @param text
	 *            der zu entschl�sselnde Text
	 * @return entschl�sselnter Text
	 */
	public String decrypt(String text);
}
