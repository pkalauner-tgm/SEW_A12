package hambergerkalaunerorosz;

/**
 * @author Paul Kalauner 3AHIT
 * 
 */
public class MonoalphabeticCipher implements Cipher {
	private String originalAlhabet = "abcdefghijklmnopqrstuvwxyzäöüß";
	private String secretAlphabet;

	/**
	 * Default Konstruktor Geheimalphabet wird auf das Ausgangsalphabet gesetzt
	 */
	public MonoalphabeticCipher() {
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
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
		text.toLowerCase();
		char[] arrText = text.toCharArray();
		char[] arrOrrAlp = originalAlhabet.toCharArray();
		char[] arrSecretAlp = this.secretAlphabet.toCharArray();
		
		for (int i = 0; i < arrText.length; i++) {
			
			if (arrText[i] > 'a' && arrText[i] < 'z') {
				System.out.println(arrText[i] - 'a');
				arrText[i] = arrSecretAlp[arrText[i] - 'a'];
			}
		}
		return new String(arrText);
	}

	/**
	 * @see hambergerkalaunerorosz.Cipher
	 */
	@Override
	public String decrypt(String text) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		MonoalphabeticCipher cipher = new MonoalphabeticCipher();
		System.out.println(cipher.encrypt("Test"));
	}

}
