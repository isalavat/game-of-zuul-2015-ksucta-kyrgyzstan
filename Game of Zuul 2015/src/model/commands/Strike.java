package model.commands;

import model.person.Spieler;

public class Strike implements Command{
    private static Strike strike = new Strike();
    Spieler spieler;
	private Strike(){
		spieler = Spieler.getSpieler();		
	}
	
	public static Strike getStrike(){
		return strike;
	} 
	
	@Override
	public void execute() {
		spieler.strike();
	}
}
