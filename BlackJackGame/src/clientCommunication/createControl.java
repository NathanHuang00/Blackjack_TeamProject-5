package clientCommunication;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JPanel;

import clientUI.loginPanel;
import clientUI.createPanel;
import database.database;

public class createControl implements ActionListener {

	private JPanel container;
	private GameClient client; 
	
	public createControl(JPanel container, GameClient client) { 
		
		this.container = container;
		this.client = client; 
		
		try 
		{ 
			client.openConnection(); 
		}
		catch (IOException e)
		{ 
			e.printStackTrace();
		}
	}
		
	public void displayError(String error){
		createPanel create = (createPanel) container.getComponent(1);
		create.setError(error);
		
	}
	
	public void createSuccess() { 
		CardLayout cardLayout = (CardLayout)container.getLayout(); 
		cardLayout.show(container, "4");
	}
	
	public void actionPerformed(ActionEvent ae) 
	{ 
		
		String command = ae.getActionCommand(); 

		createPanel create = (createPanel)container.getComponent(1);
		
		if(command.equals("Cancel"))
		{ 
			CardLayout cardLayout = (CardLayout)container.getLayout(); 
			cardLayout.show(container, "1"); 
			create.setError(""); 
		}
		
		else if(command.equals("Submit"))
		{ 
			System.out.println("unimplemented: need to implement jdbc with mysql db");
			

			CreateData  data = new CreateData(create.getUsername(), create.getPassword()); 
			
			String username = data.getUsername(); 
			String pass = data.getPassword(); 
			System.out.println("INSERT INTO user VALUES (\"" +username+ "\", \"" +pass+ "\")");
			if (data.getUsername().equals("") || data.getPassword().equals(""))
	    	{
	            displayError("You must enter a username and password.");
	            return;
	    	}
	    	else if (data.getPassword().length() < 6) {
	    		displayError("Password must be at least 6 characters");
	    		return;
	    	}
	    	
	    	
	    	try
			{
				client.sendToServer(data);
			} catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	    }

		}
	}

