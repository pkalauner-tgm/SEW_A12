package hambergerkalaunerorosz;

/**
 * SubstitutionCipher
 * 
 * @author Paul Kalauner 3AHIT
 *
 */
public class SubstitutionCipher extends MonoalphabeticCipher {
	/**
	 * Konstruktor mit Definition des Geheimalphabets
	 * @param secretalphabet Geheimalphabet
	 */
	public SubstitutionCipher(String secretalphabet) {
		super(secretalphabet);
	}

	/**
	 * setzt das Geheimalphabet
	 * @param secretAlphabet Geheimalphabet
	 */
	public void setSecretAlphabet(String secretAlphabet) {
		super.setSecretAlphabet(secretAlphabet);
	}
	
	/**
	 * Testmethode
	 * @param args
	 */
	public static void main(String[] args) {
		Cipher sc = new SubstitutionCipher("bcdefghijklmnopqrstuvwxyzäöüßa");
		String encrypted = sc.encrypt("abcdefghijklmnopqrstuvwxyzäöüß");
		System.out.println(encrypted);
		System.out.println(sc.decrypt(encrypted));
	}
}
