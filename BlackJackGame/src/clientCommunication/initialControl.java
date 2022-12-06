package clientCommunication;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class initialControl implements ActionListener {

	private JPanel container;
	
	public initialControl(JPanel container)
	{ 
		this.container = container; 
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String command = e.getActionCommand(); 
		
		if(command.equals("Login"))
		{ 
//			System.out.println("unimplemented portion: create loginPanel"); 
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container,  "3");
		}
		else if (command.equals("Create Account"))
		{ 
			CardLayout cardLayout = (CardLayout)container.getLayout(); 
			cardLayout.show(container, "2");
		}
	}
}
