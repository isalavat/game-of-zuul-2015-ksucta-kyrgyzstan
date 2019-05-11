package model.commands;

import model.person.Spieler;

public class GoSouth implements Command{
	Spieler spieler;
	private static GoSouth goSouth = new GoSouth();
	
	private GoSouth(){
		this.spieler = Spieler.getSpieler();
	}
	
	public static GoSouth getGoSouth(){
		return goSouth;
	}
	
	@Override
	public void execute() {
		spieler.goSouth();
	}
}
