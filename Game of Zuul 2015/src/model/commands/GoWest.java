package model.commands;

import model.person.Spieler;

public class GoWest implements Command {
	private static GoWest goWest = new GoWest();
	Spieler spieler;
	private GoWest(){
		this.spieler = Spieler.getSpieler();
	}
	
	public static GoWest getGoWest(){
		return goWest;
	}
	
	@Override
	public void execute() {
		spieler.goWest();	
	}
}
