package model.observerpackage;

import model.effekten.Herz;
import model.person.Spieler;

public class HerzObserver {
	private static HerzObserver herzObserver = new HerzObserver();
	private Herz herz;
	private Spieler spieler;
	private HerzObserver(){
		this.herz = herz.getHerz();
		this.spieler = Spieler.getSpieler();
	}
	
	public static HerzObserver getHerzObserver() {
		return herzObserver;
	}
	
	public void method(){
		int spielerX = spieler.getCenterX();
		int spielerY = spieler.getCenterY();
		int herzX = herz.getCenterX();
		int herzY = herz.getCenterY();
		double distance = Math.sqrt(Math.pow((spielerX-herzX), 2)+Math.pow((spielerY-herzY), 2));
		if (distance <= 60){
			herz.setVisible(false);
			Spieler.getSpieler().setKillCount(0);
		}
	}
}
