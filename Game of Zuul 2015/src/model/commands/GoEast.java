package model.commands;

import model.person.Spieler;

public class GoEast implements Command {
	private static GoEast goEast = new GoEast();
	Spieler spieler;
	
	private GoEast(){
		this.spieler = Spieler.getSpieler();
	}
	
	public static GoEast getGoEast(){
		return goEast;
	}
	
	@Override
	public void execute() {
		spieler.goEast();
	}
}
