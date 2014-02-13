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
			'x', 'y', 'z', '�', '�', '�', '�' };

	/**
	 * Default Konstruktor Geheimalphabet wird auf das Ausgangsalphabet gesetzt
	 */
	public MonoalphabeticCipher() {
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyz����";
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
	 * Liefert das Geheimalphabet zur�ck
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
				arrText[i] = arrSecretAlp[arrText[i] - 'a'];
			} else {
				switch (arrText[i]) {
				case '�':
					arrText[i] = arrSecretAlp[26];
					break;
				case '�':
					arrText[i] = arrSecretAlp[27];
					break;
				case '�':
					arrText[i] = arrSecretAlp[28];
					break;
				case '�':
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
		char firstLetter = secretAlphabet.charAt(0);

		for (int i = 0; i < arrText.length; i++) {
			if (arrText[i] >= 'a' && arrText[i] <= 'z') {
				int index = arrText[i] - firstLetter;
				arrText[i] = alpha[index == -1 ? 29 : index];
			} else {
				switch (arrText[i]) {
				case '�':
				case '�':
				case '�':
				case '�':
					arrText[i] = alpha[secretAlphabet.indexOf(arrText[i])];
					break;
				default:
				}
			}
		}
		return new String(arrText);
	}
}
