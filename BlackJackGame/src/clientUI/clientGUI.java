package clientUI;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.SwingConstants;

import GameLogic.BettingControl;
import GameLogic.GameControl;
import clientCommunication.GameClient;
import clientCommunication.StartControl;
import clientCommunication.createControl;
import clientCommunication.initialControl;
import clientCommunication.loginControl;
import database.database;

public class clientGUI extends JFrame{

	
	private static String ip = "";  

	
	public static void main(String[] args) {
		
		new clientGUI();
		
	}
	
	public clientGUI() {
	// initialize frame 
		this.setResizable(false);
		this.setTitle("Blackjack");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CardLayout cardLayout = new CardLayout();
	    JPanel container = new JPanel(cardLayout);
	    GameClient client = new GameClient(ip); 
	    
	// create the controllers
	    initialControl ic = new initialControl(container); 
	    loginControl lc = new loginControl(container, client); 
	    createControl cc = new createControl(container, client);
	    StartControl sc = new StartControl(container, client); 
	    GameControl gc = new GameControl(container, client); 
	    BettingControl bc = new BettingControl(container, client); 
	    
	// assign controllers to client
	    client.setCreateAccountControl(cc);
	    client.setLoginControl(lc);
	    client.setGameControl(gc);
	    client.setStartControl(sc);
	    client.setBetControl(bc);
	    
	// Create the views for the clientGUI (initialPanel, loginPanel, createPanel, ...)    
	    JPanel view1 = new initialPanel(ic); 
	    JPanel view2 = new createPanel(cc);
	    JPanel view3 = new loginPanel(lc); 
	    JPanel view4 = new StartPanel(sc);
	    JPanel view5 = new GamePanel(gc); 
	    
	    container.add(view1, "1"); 
	    container.add(view2, "2");
	    container.add(view3, "3");
	    container.add(view4, "4"); 
	    container.add(view5, "5"); 
	    
	    cardLayout.show(container, "1");
	    
	    this.add(container, BorderLayout.CENTER); 
	    
	    this.setSize(1084, 601);
	    this.setVisible(true); 
	    
	}

}
