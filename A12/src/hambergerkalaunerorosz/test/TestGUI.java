package hambergerkalaunerorosz.test;

import static org.junit.Assert.assertEquals;
import hambergerkalaunerorosz.Control;
import hambergerkalaunerorosz.View;

import org.junit.Before;
import org.junit.Test;

/**
 * Testklasse für die GUI
 * @author Paul Kalauner
 *
 */
public class TestGUI {
	private Control c;
	private View v;
	
	/**
	 * Initialisiert das Control und View Objekt vor jedem Testcase
	 */
	@Before
	public void init() {
		this.c = new Control();
		this.v = c.v;
	}
	
	/**
	 * Testet die Encrypt Methode mit dem Substitution-Verfahren 
	 */
	@Test
	public void testEncryptSubstitution() {
		v.input.setText("hallo!");
		v.optionlist.setSelectedIndex(0);
		v.keyword.setText("ßäöüzyxwvutsrqponmlkjihgfedcba");
		v.encr.doClick();
		assertEquals("wßssp!", v.output.getText());
	}
	
	/**
	 * Testet die Encrypt Methode mit dem Shift-Verfahren
	 */
	@Test
	public void testEncryptShift() {
		v.input.setText("hallo!");
		v.optionlist.setSelectedIndex(1);
		v.keyword.setText("12");
		v.encr.doClick();
		assertEquals("tmxxä!", v.output.getText());
	}
	
	/**
	 * Testet die Encrypt Methode mit dem Keyword-Verfahren
	 */
	@Test
	public void testEncryptKeyword() {
		v.input.setText("hallo!");
		v.optionlist.setSelectedIndex(2);
		v.keyword.setText("keyword");
		v.encr.doClick();
		assertEquals("akggj!", v.output.getText());
	}
	
	/**
	 * Testet die Decrypt Methode mit dem Substitution-Verfahren 
	 */
	@Test
	public void testDecryptSubstitution() {
		v.input.setText("wßssp!");
		v.optionlist.setSelectedIndex(0);
		v.keyword.setText("ßäöüzyxwvutsrqponmlkjihgfedcba");
		v.decr.doClick();
		assertEquals("hallo!", v.output.getText());
	}
	
	/**
	 * Testet die Decrypt Methode mit dem Shift-Verfahren
	 */
	@Test
	public void testDecryptShift() {
		v.input.setText("tmxxä!");
		v.optionlist.setSelectedIndex(1);
		v.keyword.setText("12");
		v.decr.doClick();
		assertEquals("hallo!", v.output.getText());
	}
	
	/**
	 * Testet die Decrypt Methode mit dem Keyword-Verfahren
	 */
	@Test
	public void testDecryptKeyword() {
		v.input.setText("akggj!");
		v.optionlist.setSelectedIndex(2);
		v.keyword.setText("keyword");
		v.decr.doClick();
		assertEquals("hallo!", v.output.getText());
	}
}
