package hambergerkalaunerorosz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * Control Klasse zu A12
 * 
 * @author Philip Orosz
 * @version 20140212
 * 
 */

public class Control implements ActionListener {

	/**
	 * View
	 * public Accessmodifier für Unittests
	 */
	public View v;

	/**
	 * Konstruktor der Control Klasse
	 */
	public Control() {
		JOptionPane.showMessageDialog(null, "Herzlich Willkommen beim SuperCipher!!\n"
				+ "Bitte beachten Sie, dass der Output zum Entschlüsseln wieder in den Input kopiert werden muss. ");
		this.v = new View(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (v.isEncr(e)) {
				v.encrypt();
			}
			if (v.isDecr(e)) {
				v.decrypt();
			}
		} catch (IllegalArgumentException iae) {
			JOptionPane.showMessageDialog(null, iae.getMessage());
		}

		if (v.isOptionList(e)) {
			v.setTextType();
		}

	}
}
