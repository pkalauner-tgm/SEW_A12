package hambergerkalaunerorosz.test;

import static org.junit.Assert.assertEquals;
import hambergerkalaunerorosz.MonoalphabeticCipher;

import org.junit.Test;

/**
 * Testklasse für den MonoalpabeticCipher
 * @author Gregor Hamberger
 *
 */
@SuppressWarnings("javadoc")
public class TestMonoalphabeticCipher {


	// Testfälle für IllegalArgumentException:

	/**
	 * Test mit doppeltem "a" im Alphabet
	 */
	@Test (expected=IllegalArgumentException.class)
	public void alpha1() {
		MonoalphabeticCipher a = new MonoalphabeticCipher();
		a.setSecretAlphabet("aabcdefghijklmnopqrstuvwxyzäüöß");
	}

	/**
	 * Alphabet besteht nur aus drei Buchstaben
	 */
	@Test (expected=IllegalArgumentException.class)
	public void alpha2() {
		MonoalphabeticCipher a = new MonoalphabeticCipher();
		a.setSecretAlphabet("xyz");
	}

	/**
	 * Zu kurzes Alphabet, ein Buchstabe fehlt
	 */
	@Test (expected=IllegalArgumentException.class)
	public void alpha3() {
		MonoalphabeticCipher a = new MonoalphabeticCipher();
		a.setSecretAlphabet("abcdefghijklmnopqrstuvwxyzäüö");
	}

	/**
	 * Alphabet mit Zahlen an mehreren Stellen
	 */
	@Test (expected=IllegalArgumentException.class)
	public void alpha4() {
		MonoalphabeticCipher a = new MonoalphabeticCipher();
		a.setSecretAlphabet("abcdefgh3jklmno8qrstuvwxyzäüö5");
	}
	
	/**
	 * Ungültiges Zeichen - Anfang
	 */
	@Test (expected=IllegalArgumentException.class)
	public void alpha5a() {
		MonoalphabeticCipher a = new MonoalphabeticCipher();
		a.setSecretAlphabet("%bcdefghijklmnopqrstuvwxyzäüöß");
	}

	/**
	 * Ungültiges Zeichen - Mitte
	 */
	@Test (expected=IllegalArgumentException.class)
	public void alpha5b() {
		MonoalphabeticCipher a = new MonoalphabeticCipher();
		a.setSecretAlphabet("abcdefgh%jklmnopqrstuvwxyzäüöß");
	}

	/**
	 * Ungültiges Zeichen - Ende
	 */
	@Test (expected=IllegalArgumentException.class)
	public void alpha5c() {
		MonoalphabeticCipher a = new MonoalphabeticCipher();
		a.setSecretAlphabet("abcdefghijklmnopqrstuvwxyzäüö%");
	}
	
	/**
	 * Zu kurzes Alphabet per .setSecretAlphabet
	 */
	@Test (expected=IllegalArgumentException.class)
	public void alpha5d() {
		MonoalphabeticCipher a = new MonoalphabeticCipher();
		a.setSecretAlphabet("acbdefghijklmnopqrstuvwxyzäüö");
	}
	

	//Sonstige Testfälle

	/**
	 * Per Konstruktor, ohne Parameter
	 */
	@Test
	public void alpha7a(){
		MonoalphabeticCipher a = new MonoalphabeticCipher();
		assertEquals("abcdefghijklmnopqrstuvwxyzäöüß",a.getSecretAlphabet());
	}

	/**
	 * Per Konstruktor mit Parameter
	 */
	@Test
	public void alpha7b(){
		MonoalphabeticCipher a = new MonoalphabeticCipher("ßbcdefghijklmnopqrstuvwxyzäöüa");
		assertEquals("ßbcdefghijklmnopqrstuvwxyzäöüa",a.getSecretAlphabet());
	}

	/**
	 * Setzten eines Alphabets per .setSecretAlphabet
	 */
	@Test
	public void alpha6() {
		MonoalphabeticCipher a = new MonoalphabeticCipher();
		a.setSecretAlphabet("acbdefghijklmnopqrstuvwxyzäüöß");
		assertEquals("acbdefghijklmnopqrstuvwxyzäüöß",a.getSecretAlphabet());	
	}

	/**
	 * Test der encrypt Methode - Alphabet 1
	 */
	@Test
	public void alpha8() {
		MonoalphabeticCipher a = new MonoalphabeticCipher();
		a.setSecretAlphabet("ßabcdefghijklmnopqrstuvwxyzäüö");
		assertEquals(a.encrypt("Hallo"), "gßkkn");
	}

	/**
	 * Test der encrypt Methode - Alphabet 2
	 */
	@Test
	public void alpha9() {
		MonoalphabeticCipher a = new MonoalphabeticCipher();
		a.setSecretAlphabet("bcdefghijklmnopqrstuvwxyzäüößa");
		assertEquals(a.encrypt("Hallo"), "ibmmp");
	}

	/**
	 * Test der encrypt Methode - Alphabet 1
	 */
	@Test
	public void alpha11() {
		MonoalphabeticCipher a = new MonoalphabeticCipher();
		a.setSecretAlphabet("ßabcdefghijklmnopqrstuvwxyzäüö");
		assertEquals(a.decrypt("gßkkn"), "hallo");
	}

	/**
	 * Test der decrypt Methode - Alphabet 2
	 */
	@Test
	public void alpha10() {
		MonoalphabeticCipher a = new MonoalphabeticCipher();
		a.setSecretAlphabet("bcdefghijklmnopqrstuvwxyzäüößa");
		assertEquals(a.decrypt("ibmmp"), "hallo");
	}

	/**
	 * Test der encrypt Methode mit mehreren Wörtern - Alphabet 1
	 */
	@Test
	public void alpha12() {
		MonoalphabeticCipher a = new MonoalphabeticCipher();
		a.setSecretAlphabet("bcdefghijklmnopqrstuvwxyzäüößa");
		assertEquals(a.encrypt("Hallo wie gehts"), "ibmmp xjf hfiut");
	}

	/**
	 * Test der decrypt Methode mit mehreren Wörtern - Alphabet 1
	 */
	@Test
	public void alpha13() {
		MonoalphabeticCipher a = new MonoalphabeticCipher();
		a.setSecretAlphabet("ßabcdefghijklmnopqrstuvwxyzäüö");
		assertEquals(a.encrypt("ibmmp xjf hfiut"), "hallo wie gehts");
	}

}
