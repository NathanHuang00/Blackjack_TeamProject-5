package clientUI;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import clientCommunication.createControl;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class createPanel extends JPanel {
	
	private JTextField usernameInput;
	private JTextField passInput;

    private JLabel backgroundLabel;
    private JLabel title;
    private JLabel createAccountLabel;
    private JLabel err;


    public String getUsername()
    {
    	return usernameInput.getText(); 
    }
    
    public String getPassword()
    {
    	return passInput.getText(); 
    }
    
	public void setError(String error) { 
		err.setText(error);
	}
    
	/**
	 * Create the panel.
	 */
	
	public createPanel(createControl cc) {
		
		this.setBounds(0, 0, 1084, 601);
		setLayout(null);	
	
		title = new JLabel("Blackjack: Java Edition");
		title.setForeground(new Color(128, 0, 0));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 33));
		title.setBounds(300, 49, 500, 50);
	    this.add(title); 
	    
		createAccountLabel = new JLabel("Create Account");
		createAccountLabel.setBounds(470, 110, 155, 15);
		createAccountLabel.setForeground(new Color(128, 0, 0));
		createAccountLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 25));
		add(createAccountLabel);
	    
		// create JLabel to label username text field
		JLabel username = new JLabel("Username: ");
		username.setBounds(388, 147, 75, 15);
		username.setForeground(new Color(128, 0, 0));
		username.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 18));
		add(username);
		
		// create JLabel to label password text field
		JLabel pass = new JLabel("Password: "); 
		pass.setBounds(388, 214, 75, 15);
		pass.setForeground(new Color(128, 0, 0));
		pass.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 18));
		add(pass);
		
		// create error label
		
		err = new JLabel(); 
		err.setBackground(Color.BLACK);
		err.setForeground(Color.RED);
		err.setHorizontalAlignment(SwingConstants.CENTER);
		err.setText("");
		err.setLocation(614, 259);
		err.setSize(250, 40);
		add(err); 
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(cc);
		submitButton.setBounds(388, 268, 89, 23);
		add(submitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(cc);
		cancelButton.setBounds(502, 268, 89, 23);
		add(cancelButton);
		
		usernameInput = new JTextField();
		usernameInput.setColumns(10);
		usernameInput.setBounds(502, 147, 165, 20);
		add(usernameInput);
		
		passInput = new JTextField();
		passInput.setColumns(10);
		passInput.setBounds(502, 214, 165, 20);
		add(passInput);
		
		
		// set background image 
		ImageIcon image = new ImageIcon("images/gameBackground.png");
		backgroundLabel = new JLabel(image);
		backgroundLabel.setBounds(0, 0, 1084, 601);
		this.add(backgroundLabel);
		

	}
	

}
