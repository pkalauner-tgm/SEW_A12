package hambergerkalaunerorosz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

/**
 * Control Klasse zu A12
 * 
 * @author Philip Orosz
 * @version 20140212
 * 
 */

public class Control implements ActionListener, KeyListener {

	/**
	 * View
	 * public Accessmodifier für Unittests
	 */
	public View v;

	/**
	 * Konstruktor der Control Klasse
	 */
	public Control() {
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (v.getIndex() == 2 && v.getKeyWordText().indexOf(e.getKeyChar())!=-1) {
			JOptionPane.showMessageDialog(null, "Das Keyword sollte zu Ihrer eigenen Sicherheit keine doppelten Buchstaben haben!");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
