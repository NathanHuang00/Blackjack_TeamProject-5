package clientCommunication;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import clientUI.GamePanel;
import clientUI.StartPanel;

public class StartControl implements ActionListener {
	JPanel container;
	GameClient client;
	
	public StartControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client;
	}

	
	public void updateUsername() {
		StartPanel sgp = (StartPanel) container.getComponent(3);
		JLabel usernameField = sgp.getUsername();
		usernameField.setText("Username: " + client.getUsername());
	}
//	
//	public void updateBalance() {
//		StartPanel sgp = (StartPanel) container.getComponent(3);
//		JLabel balanceLabel = sgp.getBalance();
//		balanceLabel.setText("Balance: $" + client.getBalance());
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String message = e.getActionCommand();
		
		switch (message) {
		case "StartGame":
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "5");
			break;
		}
	}

}