package hambergerkalaunerorosz.test;

import static org.junit.Assert.*;
import hambergerkalaunerorosz.MonoalphabeticCipher;
import hambergerkalaunerorosz.SubstitutionCipher;

import org.junit.Test;

/**
 * Testklasse für den SubstitutionCipher
 * @author Gregor Hamberger
 *
 */
public class TestSubstitutionCipher {

	// Testfälle - Richtiges erwartet
	
	//Konstruktor mit Parameter, Standard Alphabet
	@Test
	public void alpha1() {
		SubstitutionCipher a = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäüöß");
		assertEquals("abcdefghijklmnopqrstuvwxyzäüöß",a.getSecretAlphabet());	
	}

	//Konstruktor mit Parameter, verändertes Alphabet
	@Test
	public void alpha2() {
		SubstitutionCipher a = new SubstitutionCipher("ßacbdefghijklmnopqrstuvwxyzäüö");
		assertEquals("ßacbdefghijklmnopqrstuvwxyzäüö",a.getSecretAlphabet());	
	}

	//Testfälle - Exception erwartet
	
	//Zu kurzes Alphabet
	@Test (expected=IllegalArgumentException.class)
	public void alpha3() {
		SubstitutionCipher a = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäüö");
	}

	//Zu langes Alphabet
	@Test (expected=IllegalArgumentException.class)
	public void alpha4() {
		SubstitutionCipher a = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäüößa");
	}

	//Alphabet mit Zahlen - Anfang
	@Test (expected=IllegalArgumentException.class)
	public void alpha5() {
		SubstitutionCipher a = new SubstitutionCipher("5bcdefghijklmnopqrstuvwxyzäüöß");
	}

	//Alphabet mit Zahlen - Mitte
	@Test (expected=IllegalArgumentException.class)
	public void alpha6() {
		SubstitutionCipher a = new SubstitutionCipher("abcdefghijklm5opqrstuvwxyzäüöß");
	}

	//Alphabet mit Zahlen - Ende
	@Test (expected=IllegalArgumentException.class)
	public void alpha7() {
		SubstitutionCipher a = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäüö4");
	}

	//Alphabet mit anderem ungültigen Zeichen
	@Test (expected=IllegalArgumentException.class)
	public void alpha8() {
		SubstitutionCipher a = new SubstitutionCipher("abcdefghijklmn&pqrstuvwxyzäüöß");
	}
}
