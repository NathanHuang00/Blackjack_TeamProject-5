package clientUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import clientCommunication.initialControl;

public class initialPanel extends JPanel {

	private JFrame frame;
	private JLabel backgroundLabel; 
	private JLabel title;
	/**
	 * Create the panel.
	 */
	public initialPanel(initialControl ic) {
		// initialize JPanel
		
		this.setBounds(0, 0, 1084, 601);
		this.setLayout(null);
		
	    // create the "login" button
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(ic);
		loginButton.setBounds(496, 191, 89, 23);
		this.add(loginButton);
		
		//create the "create account" button
		JButton createButton = new JButton("Create Account");
		createButton.addActionListener(ic);
		createButton.setBounds(465, 239, 150, 23);
		this.add(createButton);
		
		// import the background image as a JLabel and pin it to this JPanel
		backgroundLabel = new JLabel(new ImageIcon("images/gameBackground.png"));
		backgroundLabel.setBounds(0, 0, 1084, 601);
		this.add(backgroundLabel);
		
		// create the label for the game title (look into getting a better font)
		title = new JLabel("Blackjack: Java Edition");
		title.setForeground(new Color(128, 0, 0));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 33));
		title.setBounds(300, 50, 500, 50);
		backgroundLabel.add(title);
	
	 
		
	}

}
