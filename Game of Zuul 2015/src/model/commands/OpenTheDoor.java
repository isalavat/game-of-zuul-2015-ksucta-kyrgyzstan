package model.commands;

import model.person.Spieler;

public class OpenTheDoor implements Command {
	private static OpenTheDoor openTheDoor = new OpenTheDoor();
	private Spieler spieler;
	private OpenTheDoor() {
		this.spieler = Spieler.getSpieler();		
	}
	
	public static OpenTheDoor getOpenTheDoor() {
		return openTheDoor;
	}

	@Override
	public void execute() {
		spieler.openTheDoor();
	}
}
