package hambergerkalaunerorosz.test;

import static org.junit.Assert.*;
import hambergerkalaunerorosz.ShiftCipher;

import org.junit.Test;

/**
 * Testklasse für dens ShiftCipher
 * @author Philip Orosz
 *
 */
@SuppressWarnings("javadoc")
public class TestShiftCipher {

	
	@Test
	public void testNormal1() {
		ShiftCipher sc = new ShiftCipher(1);
		assertEquals("bcdefghijklmnopqrstuvwxyzäöüßa", sc.getSecretAlphabet());
	}
	
	@Test
	public void testNormal13(){
		ShiftCipher sc = new ShiftCipher(13);
		assertEquals("nopqrstuvwxyzäöüßabcdefghijklm", sc.getSecretAlphabet());
	}
	
	@Test
	public void testNormal31() {
		ShiftCipher sc = new ShiftCipher(31);
		assertEquals("bcdefghijklmnopqrstuvwxyzäöüßa", sc.getSecretAlphabet());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testException(){
		new ShiftCipher(-3);
	}
	
	@Test
	public void testSetShiftAmount(){
		ShiftCipher sc = new ShiftCipher(1);
		sc.setShiftAmount(13);
		assertEquals("nopqrstuvwxyzäöüßabcdefghijklm", sc.getSecretAlphabet());
	}
	
	@Test
	public void testEncrypt(){
		ShiftCipher sc = new ShiftCipher(3);
		assertEquals("kdoor", sc.encrypt("hallo"));
	}
	
	@Test
	public void testDecrypt(){
		ShiftCipher sc = new ShiftCipher(3);
		assertEquals("hallo", sc.decrypt("kdoor"));
	}
	
	

}
