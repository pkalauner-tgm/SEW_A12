package hambergerkalaunerorosz;

/**
 * View Klasse zu A12
 * @author	Philip Orosz
 * @version	20140212
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View extends JFrame {
	Control c;

	private JPanel buttons;
	private JPanel center;
	private JPanel screen;

	private JButton encrypt;
	private JButton decrypt;

	private JTextField keyword;

	private JTextArea input;
	private JTextArea output;

	private JComboBox<String> optionlist;
	private String[] options;

	/**
	 * Konstruktor der View Klasse
	 * 
	 * @param c
	 *            Objekt der Control Klasse
	 */
	
	public View(Control c){
		this.c = c;
		
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setTitle("SuperCipher");
		
		this.keyword = new JTextField();
		
		this.input = new JTextArea();
		this.output = new JTextArea();
		
		this.options = new String[4];
		this.options[0] = "Substition"; 
		this.options[1] = "Shift";
		this.options[2] = "Monoalphabetic";
		this.options[3] = "Keyword";
		
		this.optionlist = new JComboBox<String>(options);
		
		this.encrypt = new JButton("Verschluesseln");
		this.decrypt = new JButton("Entschlüsseln");
		
		this.buttons = new JPanel();
		this.buttons.setLayout(new GridLayout(0,2));
		this.buttons.add(encrypt);
		this.buttons.add(decrypt);
		
		this.center = new JPanel();
		this.center.setLayout(new BorderLayout());
		this.center.add(keyword, BorderLayout.NORTH);
		this.center.add(optionlist, BorderLayout.CENTER);
		
		this.screen = new JPanel();
		this.screen.setLayout(new GridLayout(0,3));
		this.screen.add(input);
		this.screen.add(center);
		this.screen.add(output);
		
		this.add(buttons, BorderLayout.SOUTH);
		this.add(screen, BorderLayout.CENTER);
	
		
		this.setVisible(true);
		
		
		
		
		
		
	}
	
}