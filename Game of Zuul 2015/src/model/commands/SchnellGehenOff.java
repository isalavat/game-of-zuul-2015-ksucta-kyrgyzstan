package model.commands;

import model.person.Spieler;

public class SchnellGehenOff implements Command{
	private static SchnellGehenOff schnellGehenOff = new SchnellGehenOff();
	Spieler spieler;
	private SchnellGehenOff(){
		this.spieler = Spieler.getSpieler();
	}
	
	@Override
	public void execute() {
		spieler.schnellGehenOff();
	}
	
	public static SchnellGehenOff getSchnellgehenOff(){
		return schnellGehenOff;
	}
}
