package hambergerkalaunerorosz;

import javax.swing.JOptionPane;

/**
 * Klasse zum Starten der GUI
 * 
 * @author Paul Kalauner
 * 
 */
public class StartCipher {
	/**
	 * ruft die Control Klasse auf
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Control();
		JOptionPane.showMessageDialog(null, "Herzlich Willkommen beim SuperCipher!!\n"
				+ "Bitte beachten Sie, dass der Output zum Entschlüsseln wieder in den Input kopiert werden muss. ");
	}
}
