package model.person;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import model.bulletspackage.Schwert;
import model.resourceloader.PersonsImageLoader;
import model.rooms.Room2;
import model.sprite.SpriteSchneider;
import model.kuenstlicheintelligenz.Intellekt;

public class Pferd extends Feind {
	private ArrayList<Schwert> schwerts;
	private boolean            killed = true;
	private int                killCount = 0;
	private int                timer = 0;
	private BufferStrategy     bs;
	        Intellekt          intellekt ; 
	        SpriteSchneider    spriteSchneider ;
	        Spieler            spieler ;
	        PersonsImageLoader personsImageLoader;
	private static Pferd       pferd = new Pferd();
	private BufferedImage      image;
	private Pferd(){
		intellekt       = new Intellekt();
		this.image      = PersonsImageLoader.getPersonsImageLoader().getZwergImage();
		spriteSchneider = new SpriteSchneider(image, 2, 1, 3, 0, 4);
		spieler         = Spieler.getSpieler();
		schwerts        = new ArrayList<>();
		intellekt.setRoom(new Room2(), 2);
		intellekt.setSpeed(2);
		intellekt.setX(700);
		intellekt.setY(150);
	}
	public static Pferd getPferd(){
		return pferd;
	}
	@Override
	public void setBs(BufferStrategy bs) {
		this.bs = bs;
	}

	@Override
	public int getKillCount() {
		return killCount;
	}

	@Override
	public void setKillCount(int killCount) {
		this.killCount = killCount;
		
	}

	@Override
	public void plusKillCount() {
		if (killCount == 50){
			killed = true;
			killCount = 0;
		}
		if (!killed){
			killCount++;
		}
		
	}

	@Override
	public BufferedImage getFeindSprite() {
		if (timer == 0){
			
			if (!spieler.isKilled()){
				strike();
			}
		}
		timer ++;
		if (timer == 25){
			timer = 0;
		}
		return spriteSchneider.getSchniedeneSprite(intellekt.isEast(), intellekt.isWest(), intellekt.isNorth(), intellekt.isSouth());
	}

	@Override
	public int getX() {
		
		if (!spieler.isKilled()){
			intellekt.klug2();
		}
		return intellekt.getX();
	}

	@Override
	public int getY() {
		return intellekt.getY();
	}

	@Override
	public int getCenterX() {
		return intellekt.getX()+spriteSchneider.getSpirteWidth()/2;
	}

	@Override
	public int getCenterY() {
		return intellekt.getY()+spriteSchneider.getSpirteHeight()/2;
	}

	public ArrayList<Schwert> getSchwerts() {
		return schwerts;
	}

	@Override
	public void strike() {
	    int x_=spieler.getCenterX();
	    int y_=spieler.getCenterY();
		if (Math.abs(y_-getCenterY()) <= 50){
		    if (intellekt.isEast()){
		    	Schwert schwert = new Schwert(getCenterX()+50, getCenterY()-30, "east", bs);
		    	schwerts.add(schwert);
		    }

		    if (intellekt.isWest()){
		    	Schwert schwert = new Schwert(getCenterX()-50, getCenterY()-30, "west", bs);
		    	schwerts.add(schwert);
		    }
		}
		
		if (Math.abs(x_-getCenterX()) <= 50){
			
			if (intellekt.isNorth()){
				Schwert schwert = new Schwert(getCenterX()-20, getCenterY()-50, "north", bs);
				schwerts.add(schwert);
			}
		
			if (intellekt.isSouth()){
				Schwert schwert = new Schwert(getCenterX()-10, getCenterY()-10, "south", bs);
				schwerts.add(schwert);
			}
		}
		
	}

	@Override
	public BufferStrategy getBs() {
		return bs;
	}

	@Override
	public boolean isKilled() {
		return killed;
	}

	@Override
	public void setKilled(boolean killed) {
		this.killed = killed;
	}
}
