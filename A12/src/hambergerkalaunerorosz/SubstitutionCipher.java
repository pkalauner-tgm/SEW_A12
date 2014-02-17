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
		this.setSecretAlphabet(secretalphabet);
	}

	/**
	 * setzt das Geheimalphabet
	 * @param secretAlphabet Geheimalphabet
	 */
	public void setSecretAlphabet(String secretAlphabet) {
		super.setSecretAlphabet(secretAlphabet);
	}
}
