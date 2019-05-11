package model.invoker;

import java.util.Observable;
import java.util.Observer;

import model.commands.*;
import model.person.Spieler;
import controller.cmd.KeyHandler;


public class Bewegung implements Observer {
	Spieler spieler;
	private int timer = 0;
	private Strike toStrike;
	private GoSouth goSouth;
	private GoNorth goNorth;
	private GoEast  goEast;
	private GoWest  goWest;
	private NimmKey nimmKey;
	private OpenTheDoor openTheDoor;
	SchnellGehenOn schnellGehenOn;
	SchnellGehenOff schnellGehenOff;
	private boolean east;
	private boolean west;
	private boolean south;
	private boolean north;
	private boolean strike;
	private boolean isSchnellGehenOn;
	private boolean isNimmKey;
	private boolean isOpenTheDoor;
	private static Bewegung bewegung = new Bewegung();
	private Bewegung(){
		this.spieler = Spieler.getSpieler();
		schnellGehenOn = SchnellGehenOn.getSchnellgehenOn();
		schnellGehenOff = SchnellGehenOff.getSchnellgehenOff();
		goSouth   = GoSouth.getGoSouth();
		goNorth   = GoNorth.getGoNorth();
		goEast    = GoEast.getGoEast();
		goWest    = GoWest.getGoWest();
		toStrike  = Strike.getStrike();
		nimmKey   = NimmKey.getNimmKey();
		openTheDoor = OpenTheDoor.getOpenTheDoor();
		north = false;
		west  = false;
		south = false;
		north = false;
		strike = false;
		isNimmKey = false;
		isOpenTheDoor = false;
	} 
	
	public static Bewegung getBewegung(){
		return bewegung;
	}
	
	public void setSpieler(Spieler spieler) {
		this.spieler = spieler;
	}

    public void setSchnellGehenOn(boolean isSchnellGehenOn) {
		this.isSchnellGehenOn = isSchnellGehenOn;
	}

	public void setEast(boolean east) {
		this.east = east;
	}

	public void setWest(boolean west) {
		this.west = west;
	}

	public void setSouth(boolean south) {
		this.south = south;
	}

	public void setNorth(boolean north) {
		this.north = north;
	}

	public void setStrike(boolean strike){
		this.strike = strike;
	}
	
	public boolean isEast() {
		return east;
	}

	public boolean isWest() {
		return west;
	}

	public boolean isSouth() {
		return south;
	}

	public boolean isNorth() {
		return north;
	}
	
	public boolean isStrike(){
		return strike;
	}

	

	public void gehen(){
		if (this.isNimmKey){
			nimmKey.execute();
		}
		
		if (this.isOpenTheDoor){
			openTheDoor.execute();
		}
		
		if (this.isEast()){
			goEast.execute();
		}
		
		if (this.isWest()){
			goWest.execute();
		}
		
		if (this.isNorth()){
			goNorth.execute();
		}
		
		if (this.isSouth()){
			goSouth.execute();
		}
		
		if (isSchnellGehenOn){
			schnellGehenOn.execute();
		}
		
		if (!isSchnellGehenOn){
			schnellGehenOff.execute();
		}
		
		if (isStrike()){
			if (timer == 0){
				toStrike.execute();
			}
			timer++;
			if (timer == 5){
				timer = 0;
			}
			
		}
		
	}

	public void setNimmKey(boolean isNimmKey) {
		this.isNimmKey = isNimmKey;
	}

	public void setOpenTheDoor(boolean isOpenTheDoor) {
		this.isOpenTheDoor = isOpenTheDoor;
	}

	@Override
	public void update(Observable obs, Object arg) {
		KeyHandler key = ((KeyHandler) obs).getKeyHandler();
		this.east =  key.isEast();
		this.west = key.isWest();
		this.south = key.isSouth();
		this.north = key.isNorth();
		this.isSchnellGehenOn = key.isSchnellGehenOn();
		this.strike = key.isStrike();
		this.isNimmKey = key.isNimmKey();
		this.isOpenTheDoor = key.isOpenTheDoor();
	}
}
