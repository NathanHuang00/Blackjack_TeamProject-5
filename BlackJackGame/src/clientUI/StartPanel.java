package clientUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import clientCommunication.StartControl;

public class StartPanel extends JPanel 
{
	JLabel backgroundLabel; 
	JLabel title; 
	public StartPanel(StartControl sc) 
	{
		this.setBounds(0, 0, 1084, 601);
		setLayout(null); 
	    
		title = new JLabel("Welcome to Blackjack!");
		title.setForeground(new Color(128, 0, 0));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 33));
		title.setBounds(300, 50, 500, 50);
	    this.add(title);
	    
	    
	    JButton startGameButton  = new JButton("StartGame");
	    startGameButton.setHorizontalAlignment(SwingConstants.CENTER);
	    startGameButton.setBounds(425, 400, 250, 50);
	    startGameButton.addActionListener(sc);   
	    add(startGameButton);
	   
		ImageIcon image = new ImageIcon("images/gameBackground.png");
		backgroundLabel = new JLabel(image);
		backgroundLabel.setBounds(0, 0, 1084, 601);
		this.add(backgroundLabel); 
	    

	}
	
}