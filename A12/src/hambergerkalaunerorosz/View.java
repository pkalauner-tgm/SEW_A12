package hambergerkalaunerorosz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * View Klasse zu A12
 * 
 * @author Philip Orosz
 * @version 20140212
 */
public class View extends JFrame {

	private static final long serialVersionUID = 1L;

	private Control control;
	private SubstitutionCipher substC;
	private ShiftCipher shiftC;
	private KeywordCipher keyC;

	private JPanel buttons;
	private JPanel center;
	private JPanel north;

	/**
	 * Encrypt-Button public Accessmodifier für Unittests
	 */
	public JButton encr;

	/**
	 * Decrypt-Button public Accessmodifier für Unittests
	 */
	public JButton decr;

	/**
	 * Textfeld zur Eingabe des Geheimalphabets, Keywords oder der Shiftvalue
	 * public Accessmodifier für Unittests
	 */
	public JTextField keyword;

	/**
	 * Inputtext public Accessmodifier für Unittests
	 */
	public JTextArea input;

	/**
	 * Outputtext public Accessmodifier für Unittests
	 * 
	 */
	public JTextArea output;

	/**
	 * Auswahl der Verschlüsselungsmethode public Accessmodifier für Unittests
	 */
	public JComboBox<String> optionlist;

	private JLabel type;

	/**
	 * Konstruktor der View Klasse
	 * 
	 * @param c
	 *            Objekt der Control Klasse
	 */

	public View(Control c) {
		super("SuperCipher");
		this.control = c;

		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);

		this.north = new JPanel();
		this.keyword = new JTextField(30);
		this.type = new JLabel("Geheimalphabet: ");

		this.north.add(type);
		this.north.add(keyword);

		this.input = new JTextArea();
		this.output = new JTextArea();

		this.input.setWrapStyleWord(true);
		this.input.setLineWrap(true);

		this.output.setEditable(false);
		this.output.setBackground(Color.LIGHT_GRAY);
		this.output.setLineWrap(true);
		this.output.setWrapStyleWord(true);

		String[] options = { "Substitution", "Shift", "Keyword" };
		this.optionlist = new JComboBox<String>(options);

		this.encr = new JButton("Verschlüsseln");
		this.decr = new JButton("Entschlüsseln");

		this.optionlist.addActionListener(control);
		this.encr.addActionListener(control);
		this.decr.addActionListener(control);

		this.buttons = new JPanel();
		this.buttons.setLayout(new GridLayout(0, 3));
		this.buttons.add(encr);
		this.buttons.add(optionlist);
		this.buttons.add(decr);

		this.center = new JPanel();
		this.center.setLayout(new GridLayout(1, 2));
		this.center.add(new JScrollPane(input));
		this.center.add(new JScrollPane(output));

		this.add(north, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		this.add(buttons, BorderLayout.SOUTH);

		this.shiftC = new ShiftCipher(0);
		this.substC = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäöüß");
		this.keyC = new KeywordCipher("keyword");
		
		this.setVisible(true);

	}

	/**
	 * Ändert den Text des Labels entsprechend der ausgewählten Methode
	 */
	public void setTextType() {
		switch (this.optionlist.getSelectedIndex()) {
		case 0:
			this.type.setText("Geheimalphabet: ");
			break;
		case 1:
			this.type.setText("Verschiebung: ");
			break;

		case 2:
			this.type.setText("Keyword: ");
			break;
		}
	}

	/**
	 * Initialisiert die Cipher entsprechend der Auswahl und ruft die encrypt()
	 * Methode auf
	 * 
	 * @throws IllegalArgumentException
	 *             falls der Benutzer ein ungültiges Alphabet, Keyword oder eine
	 *             ungültige Verschiebungszahl eingegeben hat.
	 */
	public void encrypt() throws IllegalArgumentException {
		switch (this.optionlist.getSelectedIndex()) {
		case 0:
			this.substC.setSecretAlphabet(this.keyword.getText());
			this.output.setText(substC.encrypt(this.input.getText()));
			break;
		case 1:
			try {
				this.shiftC.setShiftAmount(Integer.parseInt(this.keyword.getText()));
				this.output.setText(shiftC.encrypt(this.input.getText()));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Ungültige Zahl");
			}
			break;
		case 2:
			this.keyC.setKeyword(this.keyword.getText());
			this.output.setText(keyC.encrypt(this.input.getText()));
			break;
		}
	}

	/**
	 * Initialisiert die Cipher entsprechend der Auswahl und ruft die decrypt()
	 * Methode auf
	 * 
	 * @throws IllegalArgumentException
	 *             falls der Benutzer ein ungültiges Alphabet, Keyword oder eine
	 *             ungültige Verschiebungszahl eingegeben hat.
	 */
	public void decrypt() throws IllegalArgumentException {
		switch (this.optionlist.getSelectedIndex()) {
		case 0:
			this.substC.setSecretAlphabet(this.keyword.getText());
			this.output.setText(substC.decrypt(this.input.getText()));
			break;
		case 1:
			try {
				this.shiftC.setShiftAmount(Integer.parseInt(this.keyword.getText()));
				this.output.setText(shiftC.decrypt(this.input.getText()));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Ungültige Zahl");
			}
			break;
		case 2:
			this.keyC.setKeyword(this.keyword.getText());
			this.output.setText(keyC.decrypt(this.input.getText()));
			break;
		}
	}

	/**
	 * Prüft ob der "Encrypt" Button gedrückt wurde
	 * 
	 * @param e
	 *            ActionEvent
	 * @return true falls gedrückt
	 */
	public boolean isEncr(ActionEvent e) {
		if (e.getSource() == this.encr) {
			return true;
		}
		return false;
	}

	/**
	 * Prüft ob der "Decrypt" Button gedrückt wurde
	 * 
	 * @param e
	 *            ActionEvent
	 * @return true falls gedrückt
	 */

	public boolean isDecr(ActionEvent e) {
		if (e.getSource() == this.decr) {
			return true;
		}
		return false;
	}

	/**
	 * Prüft ob die Auswahl der ComboBox geändert wurde
	 * 
	 * @param e
	 *            ActionEvent
	 * @return true falls gedrückt
	 */
	public boolean isOptionList(ActionEvent e) {
		if (e.getSource() == this.optionlist) {
			return true;
		}
		return false;
	}

}