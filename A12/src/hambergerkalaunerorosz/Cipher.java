package hambergerkalaunerorosz;

/**
 * Cipher
 * 
 * @author Paul Kalauner 3AHIT
 * 
 */
public interface Cipher {

	/**
	 * Verschlüsselungsmethode
	 * 
	 * @param text
	 *            der zu verschlüsselnde Text
	 * @return verschlüsselter Text
	 */
	public String encrypt(String text);

	/**
	 * Entschlüsselungsmethode
	 * 
	 * @param text
	 *            der zu entschlüsselnde Text
	 * @return entschlüsselnter Text
	 */
	public String decrypt(String text);
}
