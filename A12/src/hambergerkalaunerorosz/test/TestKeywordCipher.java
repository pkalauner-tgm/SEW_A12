package hambergerkalaunerorosz.test;

import static org.junit.Assert.*;
import hambergerkalaunerorosz.KeywordCipher;

import org.junit.Test;

/**
 * Testklasse für den KeywordCipher
 * @author Philip Orosz
 *
 */

public class TestKeywordCipher {

	/**
	 * Testet den Konstruktor
	 */
	@Test
	public void testKeywordCipher() {
		KeywordCipher kc = new KeywordCipher("hund");
		assertEquals("hundabcefgijklmopqrstvwxyzäöüß", kc.getSecretAlphabet());
	}

	/**
	 * Testet die Exception falls ein mehr als 30-stelliges keyword angegeben wurde
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testException(){
		new KeywordCipher("dieseskeywordistgrößeralsdreissigzeichen");
	}
	
	/**
	 * Testet die Verschlüsselungsmethode
	 * 
	 * eingabe: affe
	 * keyword: hund
	 * erwartete ausgabe: hbba
	 */
	@Test
	public void testEncrypt() {
		KeywordCipher kc = new KeywordCipher("hund");
		assertEquals("hbba", kc.encrypt("affe"));
	}
	
	/**
	 * Testet die Entschlüsselungsmethode
	 * 
	 * eingabe: hbba
	 * keyword: hund
	 * erwartete ausgabe: affe
	 */
	@Test
	public void testDecrypt() {
		KeywordCipher kc = new KeywordCipher("hund");
		assertEquals("affe", kc.decrypt("hbba"));
	}
}
