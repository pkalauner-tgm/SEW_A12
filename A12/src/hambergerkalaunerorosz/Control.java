package hambergerkalaunerorosz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Control Klasse zu A12
 * 
 * @author Philip Orosz
 * @version 20140212
 *
 */

public class Control implements ActionListener{

	private View v;
	/**
	 * Konstruktor der Control Klasse
	 */
	public Control(){
		this.v = new View(this);
	}
	/**
	 * Main Methode
	 * @param args
	 */
	public static void main(String[] args){
		new Control();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (v.isEncr(e)) {
			
		}
		
		if (v.isDecr(e)) {
			
		}
		
		if (v.isOptionList(e)) {
			v.setTextType();
		}
		
	}
}
