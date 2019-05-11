package model.commands;

import model.person.Spieler;

public class SchnellGehenOn implements Command {
	private static SchnellGehenOn schnellGehenOn = new SchnellGehenOn(); 	
	Spieler spieler;
	private SchnellGehenOn(){
		spieler = Spieler.getSpieler();
	}
	@Override
	public void execute() {
		spieler.schnellGehenOn();
	}
	public static SchnellGehenOn getSchnellgehenOn(){
		return schnellGehenOn;
	}
}
