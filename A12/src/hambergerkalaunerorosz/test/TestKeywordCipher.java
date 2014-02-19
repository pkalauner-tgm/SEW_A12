package hambergerkalaunerorosz.test;

import static org.junit.Assert.*;
import hambergerkalaunerorosz.KeywordCipher;

import org.junit.Test;

/**
 * Testklasse für den KeywordCipher
 * @author Philip Orosz
 *
 */
@SuppressWarnings("javadoc")
public class TestKeywordCipher {

	@Test
	public void testKeywordCipher() {
		KeywordCipher kc = new KeywordCipher("hund");
		assertEquals("hundabcefgijklmopqrstvwxyzäöüß", kc.getSecretAlphabet());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testException(){
		new KeywordCipher("dieseskeywordistgrößeralsdreissigzeichen");
	}
	
	@Test
	public void testEncrypt() {
		KeywordCipher kc = new KeywordCipher("hund");
		assertEquals("hbba", kc.encrypt("affe"));
	}
	
	@Test
	public void testDecrypt() {
		KeywordCipher kc = new KeywordCipher("hund");
		assertEquals("affe", kc.decrypt("hbba"));
	}
}
