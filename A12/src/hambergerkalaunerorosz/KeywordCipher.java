package hambergerkalaunerorosz;

import java.util.LinkedHashSet;

/**
 * KeywordCipher
 * @author Gregor Hamberger
 *
 */
public class KeywordCipher extends MonoalphabeticCipher {
	private String keyword;
	private char[] alpha = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z', 'ä', 'ö', 'ü', 'ß' };

	/**
	 * Konstruktor mit Definition des Keywords
	 * @param keyword
	 */
	public KeywordCipher(String keyword) {
		setKeyword(keyword);
	}
	
	/**
	 * Setzt das Keyword und berechnet das daraus entstehende Geheimalphabet
	 * @param keyword
	 */
	public void setKeyword(String keyword) {
		if (keyword.length() > 30) {
			throw new IllegalArgumentException("Das Keyword darf maximal 30 Zeichen lang sein");
		}
		this.keyword = keyword.toLowerCase();
		LinkedHashSet<Character> lhs = new LinkedHashSet<Character>();
		
		// Fügt alle Buchstaben des Keywords zum Set hinzu
		for (int i = 0; i < this.keyword.length(); i++) {
			lhs.add(this.keyword.charAt(i));
		}
		
		// Fügt die restlichen Buchstaben des Alphabets zum Set hinzu
		// Da ein Set verwendet wird, werden bereits im Keyword enthaltene Buchstaben nicht hinzugefügt
		for (char c : alpha) {
			lhs.add(c);
		}

		StringBuilder sb = new StringBuilder();

		// Wandelt das Character-LinkedHashSet in einen String um
		for (char c : lhs) {
			sb.append(c);
		}
		super.setSecretAlphabet(sb.toString());
	}

	/**
	 * Testmethode
	 * @param args
	 */
	public static void main(String[] args) {
		Cipher kc = new KeywordCipher("keyword");
		String encrypted = kc.encrypt("abcdefghijklmnopqrstuvwxyzäöüß");
		System.out.println(encrypted);
		System.out.println(kc.decrypt(encrypted));
	}

}
