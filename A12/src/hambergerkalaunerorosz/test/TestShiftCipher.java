package hambergerkalaunerorosz.test;

import static org.junit.Assert.*;
import hambergerkalaunerorosz.ShiftCipher;

import org.junit.Test;

/**
 * Testklasse für dens ShiftCipher
 * @author Philip Orosz
 *
 */

public class TestShiftCipher {

	/**
	 * Test des Konstruktors mit der Zahl 3
	 */
	@Test
	public void testNormal1() {
		ShiftCipher sc = new ShiftCipher(1);
		assertEquals("bcdefghijklmnopqrstuvwxyzäöüßa", sc.getSecretAlphabet());
	}
	
	/**
	 * Test des Konstruktors mit der Zahl 13
	 */
	@Test
	public void testNormal13(){
		ShiftCipher sc = new ShiftCipher(13);
		assertEquals("nopqrstuvwxyzäöüßabcdefghijklm", sc.getSecretAlphabet());
	}
	
	/**
	 * Test des Konstruktors mit der Zahl 31
	 */
	@Test
	public void testNormal31() {
		ShiftCipher sc = new ShiftCipher(31);
		assertEquals("bcdefghijklmnopqrstuvwxyzäöüßa", sc.getSecretAlphabet());
	}
	
	/**
	 * Testet die Exception falls ein Wert kleiner 0 eingegeben wird
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testException(){
		new ShiftCipher(-3);
	}
	
	/**
	 * Testet die set Methode 
	 */
	@Test
	public void testSetShiftAmount(){
		ShiftCipher sc = new ShiftCipher(1);
		sc.setShiftAmount(13);
		assertEquals("nopqrstuvwxyzäöüßabcdefghijklm", sc.getSecretAlphabet());
	}
	
	/**
	 * Testet die Verschlüsselungsmethode
	 * 
	 * eingabe: hallo
	 * verschiebung: 3
	 * erwartete ausgabe: kdoor
	 */
	@Test
	public void testEncrypt(){
		ShiftCipher sc = new ShiftCipher(3);
		assertEquals("kdoor", sc.encrypt("hallo"));
	}
	
	/**
	 * Testet die Entschlüsselungsmethode
	 * 
	 * eingabe: kdoor
	 * verschiebung: 3
	 * erwartete ausgabe: hallo
	 */
	@Test
	public void testDecrypt(){
		ShiftCipher sc = new ShiftCipher(3);
		assertEquals("hallo", sc.decrypt("kdoor"));
	}
	
	

}
