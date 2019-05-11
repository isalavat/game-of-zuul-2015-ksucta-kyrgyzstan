package model.commands;

import model.person.Spieler;

public class NimmKey implements Command {
	private static NimmKey nimmKey = new NimmKey();
	private Spieler spieler;
	private  NimmKey() {
		spieler = Spieler.getSpieler();
	}
	
	public static NimmKey getNimmKey() {
		return nimmKey;
	}

	@Override
	public void execute() {
		spieler.nimmKey();
	}
}
