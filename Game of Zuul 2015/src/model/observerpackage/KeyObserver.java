package model.observerpackage;

import model.effekten.Key;
import model.invoker.Bewegung;
import model.person.Spieler;

public class KeyObserver {
	private static KeyObserver keyObserver = new KeyObserver();
	private Key key;
	private double distance = 1000;
	public double getDistance() {
		return distance;
	}

	private Spieler spieler;
	private KeyObserver(){
		this.key = Key.getKey();
		this.spieler = Spieler.getSpieler();
	}
	
	public static KeyObserver getKeyObserver() {
		return keyObserver;
	}
	
	public void method(){
		this.spieler = Spieler.getSpieler();	
		int spielerY = spieler.getCenterY();
		int keyX = key.getCenterX();
		int keyY = key.getCenterY();
		int spielerX = spieler.getCenterX();
	    distance = Math.sqrt(Math.pow((spielerX-keyX), 2)+Math.pow((spielerY-keyY), 2));
		if (distance <= 60){
			key.setVisible(false);
			spieler.setGibtEsKey(true);
			Bewegung.getBewegung().setNimmKey(false);
		}
	}
}
