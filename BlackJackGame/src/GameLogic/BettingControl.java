package GameLogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import clientCommunication.GameClient;
import clientUI.BettingPanel;
import clientUI.createPanel;

public class BettingControl implements ActionListener{
	private GameClient client;
	private JPanel container;
	private boolean betUpdate;
	
	public BettingControl(JPanel container, GameClient client) {
		this.client = client;
		this.container = container;
	}
	
	
	public void updateBalance() 
	{
		BettingPanel betPanel = (BettingPanel)container.getComponent(4);
		JTextField betTextField = betPanel.getBalanceTextField();
		betTextField.setText("$" + client.getBalance());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		BettingPanel betPanel = (BettingPanel)container.getComponent(4); 
		JTextField betTextField = betPanel.getBetTextField();
		
		double oldAmount;
		double newAmount;
		switch (command) {
		case "$1":
			updateBet(1);
			break;
		case "$5":
			updateBet(5);
			break;
		case "$10":
			updateBet(10);
			break;
		case "$20":
			updateBet(20);
			break;
		case "$100":
			updateBet(100);
			break;
		case "Place Bet":
			BettingData data = new BettingData(client.getUsername(), betPanel.getBet());
			System.out.println(data.toString());
			betPanel.displayError("");
			client.setBetAmount(betPanel.getBet());
			System.out.println(client.getBetAmount());
			try {
				client.sendToServer(data);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Add Money":
			try {
				betUpdate = true;
				client.sendToServer("addMoney=" + client.getUsername());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		}
	}
	
	private void updateBet(double amtToAdd) {
		BettingPanel betPanel = (BettingPanel)container.getComponent(4); 
		JTextField betTextField = betPanel.getBetTextField();
		double balance = Double.parseDouble(betPanel.getBalanceTextField().getText().substring(1));
		double oldAmount = Double.parseDouble(betTextField.getText().substring(1));
		double newAmount = Math.rint(oldAmount + amtToAdd);
		if (newAmount <= balance) {
			betTextField.setText("$" + Double.toString(newAmount));
		}
	}
	
	public void resetBet()
	{
		if(betUpdate)
		{
			return;
		}
		BettingPanel betPanel = (BettingPanel)container.getComponent(4); 
		JTextField betTextField = betPanel.getBetTextField();
		betTextField.setText("$0.0");
	}
	
	public void displayError(String message)
	{
		BettingPanel betPanel = (BettingPanel)container.getComponent(4); 
		betPanel.displayError(message);
	}
	
	public void displayWaitingMessage() {
		BettingPanel betPanel = (BettingPanel)container.getComponent(4); 
		betPanel.displayError("Waiting for other players...");
	}
	
	public double getBalance() {
		return client.getBalance();
	}
	
	public void setTimerMessage() {
		BettingPanel betPanel = (BettingPanel)container.getComponent(4); 
		betPanel.displayError("Hurry up and bet");
	}
	
	public void betUpdate(boolean update)
	{
		this.betUpdate = update;
	}
	
	
}