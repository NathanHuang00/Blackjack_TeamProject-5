package clientCommunication;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JPanel;

import clientUI.loginPanel;
import database.database;

public class loginControl implements ActionListener {

	private JPanel container;
	private GameClient client; 
	
	public loginControl(JPanel container, GameClient client) { 
		
		this.container = container;
		this.client = client; 
		
		try 
		{ 
			client.openConnection();
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	
	public void displayError(String error)
	{
		loginPanel loginPanel = (loginPanel) container.getComponent(1);
		loginPanel.setError(error);

	}
	
	public void loginSuccess() { 
		CardLayout cardLayout = (CardLayout)container.getLayout(); 
		cardLayout.show(container, "4");
	}
	
	public void actionPerformed(ActionEvent ae) 
	{ 
		
		String command = ae.getActionCommand(); 
		
		if(command.equals("Cancel"))
		{ 
			CardLayout cardLayout = (CardLayout)container.getLayout(); 
			cardLayout.show(container, "1"); 
			
		}
		else if(command.equals("Submit"))
		{ 
			
			loginPanel login = (loginPanel)container.getComponent(2);
			loginData  data = new loginData(login.getUsername(), login.getPassword()); 
			
			String username = data.getUsername(); 
			String pass = data.getPassword(); 
			
			if (data.getUsername().equals("") || data.getPassword().equals(""))
			{
				login.setError("Must enter a username and password");
			}
			else 
			{
				CardLayout cardLayout = (CardLayout)container.getLayout(); 
				
				try 
				{
					client.sendToServer(data);
				}
				catch(IOException e)
				{ 
					e.printStackTrace();
				}
				
				 
			}

		}
	}
	
}
