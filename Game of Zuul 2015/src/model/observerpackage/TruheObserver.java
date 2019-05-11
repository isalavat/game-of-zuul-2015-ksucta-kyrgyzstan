package model.observerpackage;

import model.effekten.Truhe;
import model.person.Spieler;


public class TruheObserver {
	
	private static TruheObserver truheObserver = new TruheObserver();	
    Spieler spieler;
    Truhe truhe;
    private TruheObserver() {
		this.spieler = Spieler.getSpieler();
		this.truhe   = Truhe.getTruhe();
	}//ok, es funktioniert, die anderen können es jetzt neu importieren und haben dann ein java Projekt.
     //ich trenne die Verbindung jetzt
	public void method(){
		int spielerX = spieler.getCenterX();
		int spielerY = spieler.getCenterY();
		int truheX = truhe.getCenterX();
		int truheY = truhe.getCenterY();
		double distance = Math.sqrt(Math.pow((spielerX-truheX), 2)+Math.pow((spielerY-truheY), 2));
		if ((distance <= 60)&(spieler.isGibtEsKey())){
			truhe.setOffen(true);
			spieler.setGibtEsTruhe(true);
			spieler.setGibtEsKey(false);
		}
	}

	public static TruheObserver getTruheObserver() {
		return truheObserver;
	}

}
