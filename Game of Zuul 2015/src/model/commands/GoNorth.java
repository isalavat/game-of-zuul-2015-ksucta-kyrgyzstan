package model.commands;

import model.person.Spieler;

public class GoNorth implements Command {
	Spieler spieler;
	private static GoNorth goNorth = new GoNorth();
	private GoNorth(){
		this.spieler = Spieler.getSpieler();
	}

	public static GoNorth getGoNorth (){
		return goNorth;
	}
	
	@Override
	public void execute(){
		spieler.goNorth();
	}
}
