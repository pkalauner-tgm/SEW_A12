package hambergerkalaunerorosz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * View Klasse zu A12
 * 
 * @author Philip Orosz
 * @version 20140212
 */
public class View extends JFrame {
	private Control c;

	private JPanel buttons;
	private JPanel center;
	private JPanel north;

	private JButton encr;
	private JButton decr;

	private JTextField keyword;

	private JTextArea input;
	private JTextArea output;

	private JComboBox<String> optionlist;
	
	private JLabel type;

	/**
	 * Konstruktor der View Klasse
	 * 
	 * @param c	Objekt der Control Klasse
	 */

	public View(Control c) {
		this.c = c;

		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setTitle("SuperCipher");

		this.north = new JPanel();
		this.keyword = new JTextField();
		this.keyword.setColumns(30);
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
		
		this.optionlist.addActionListener(c);
		this.encr.addActionListener(c);
		this.decr.addActionListener(c);

		this.buttons = new JPanel();
		this.buttons.setLayout(new GridLayout(0, 3));
		this.buttons.add(encr);
		this.buttons.add(optionlist);
		this.buttons.add(decr);

		this.center = new JPanel();
		this.center.setLayout(new GridLayout(1, 2));
		this.center.add(input);
		this.center.add(output);

		this.add(north, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		this.add(buttons, BorderLayout.SOUTH);

		this.setVisible(true);

	}
	
	public void setTextType() {
		switch (this.optionlist.getSelectedItem().toString()) {
		case "Substitution":
			this.type.setText("Geheimalphabet: ");
			break;
		case "Keyword":
			this.type.setText("Keyword: ");
			break;
		case "Shift":
			this.type.setText("Verschiebung: ");
			break;
			default:
		}
	}
	/**
	 * ActionListener des "Encrypt" Buttons
	 * 
	 * @param e ActionEvent
	 * @return true falls gedrückt
	 */
	public boolean isEncr(ActionEvent e){
		if(e.getSource() == this.encr){
			return true;
		}
		return false;
	}
	/**
	 * Actionlistener des "Decrypt" Buttons
	 * 
	 * @param e ActionEvent
	 * @return	true falls gedrückt
	 */
	
	public boolean isDecr(ActionEvent e){
		if(e.getSource() == this.decr){
			return true;
		}
		return false;
	}
	
	/**
	 * Actionlistener des "Decrypt" Buttons
	 * 
	 * @param e ActionEvent
	 * @return	true falls gedrückt
	 */
	public boolean isOptionList(ActionEvent e){
		if(e.getSource() == this.optionlist){
			return true;
		}
		return false;
	}
	

}