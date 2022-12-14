
package GameLogic;

import java.io.Serializable;

public class BettingData implements Serializable
{
	private double betAmount;
	private String username;
	
	public BettingData(String username, double betAmount) {
		this.username = username;
		this.betAmount = betAmount;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public double getBetAmount() {
		return betAmount;
	}
	
	public void setBetAmount(double amount) {
		this.betAmount = amount;
	}

}
