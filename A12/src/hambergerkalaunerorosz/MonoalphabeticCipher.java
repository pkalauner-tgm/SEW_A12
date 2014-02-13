package hambergerkalaunerorosz;

/**
 * MonoalphabeticCipher
 * 
 * @author Paul Kalauner 3AHIT
 * 
 */
public class MonoalphabeticCipher implements Cipher {
	private String secretAlphabet;
	private char[] alpha = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z', 'ä', 'ö', 'ü', 'ß' };

	/**
	 * Default Konstruktor Geheimalphabet wird auf das Ausgangsalphabet gesetzt
	 */
	public MonoalphabeticCipher() {
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
	}

	/**
	 * Konstruktor mit Definition des Geheimalphabets
	 * 
	 * @param secretAlphabet
	 *            Geheimalphabet
	 */
	public MonoalphabeticCipher(String secretAlphabet) {
		setSecretAlphabet(secretAlphabet);
	}

	/**
	 * Setzt das Geheimalphabet
	 * 
	 * @param secretAlphabet
	 *            Geheimalphabet
	 */
	public void setSecretAlphabet(String secretAlphabet) {
		this.secretAlphabet = secretAlphabet;
	}

	/**
	 * Liefert das Geheimalphabet zurück
	 * 
	 * @return secretAlphabet
	 */
	public String getSecretAlphabet() {
		return secretAlphabet;
	}

	/**
	 * @see hambergerkalaunerorosz.Cipher
	 */
	@Override
	public String encrypt(String text) {
		char[] arrText = text.toLowerCase().toCharArray();
		char[] arrSecretAlp = this.secretAlphabet.toCharArray();

		for (int i = 0; i < arrText.length; i++) {
			if (arrText[i] >= 'a' && arrText[i] <= 'z') {
				// [arrText[i] - 'a' berechnet die Stelle des Buchstabens im Alphabet (bzw.im char-Array)
				// Danach wird der aktuelle Buchstabe auf den dazugehörigen des Geheimalphabet gesetzt
				arrText[i] = arrSecretAlp[arrText[i] - 'a'];
			} else {
				//Umlaute müssen seperat behandelt werden, da die ASCII Codes nicht direkt nach dem normalen Alphabet liegen.
				switch (arrText[i]) {
				case 'ä':
					arrText[i] = arrSecretAlp[26];
					break;
				case 'ö':
					arrText[i] = arrSecretAlp[27];
					break;
				case 'ü':
					arrText[i] = arrSecretAlp[28];
					break;
				case 'ß':
					arrText[i] = arrSecretAlp[29];
					break;
				default:
				}
			}
		}
		return new String(arrText);
	}

	/**
	 * @see hambergerkalaunerorosz.Cipher
	 */
	@Override
	public String decrypt(String text) {
		char[] arrText = text.toLowerCase().toCharArray();

		for (int i = 0; i < arrText.length; i++) {
			if ((arrText[i] >= 'a' && arrText[i] <= 'z') || arrText[i] == 'ä' || arrText[i] == 'ö' || arrText[i] == 'ü' || arrText[i] == 'ß') {
				// Diesmal  wird mittels indexOf() die Stelle im Geheimalphabet herausgefunden, da ja diesmal die Reihenfolge nicht bekannt ist.
				// Danach wird der aktuelle Buchstabe auf den dazugehörigen des Original-Alphabets gesetzt
				arrText[i] = alpha[secretAlphabet.indexOf(arrText[i])];
			}
		}
		return new String(arrText);
	}
}
