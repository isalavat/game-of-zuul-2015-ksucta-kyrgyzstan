package model.person;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import model.bulletspackage.BigDrakonsBullet;
import model.resourceloader.PersonsImageLoader;
import model.rooms.Room3;
import model.sprite.SpriteSchneider;
import model.kuenstlicheintelligenz.Intellekt;

public class BigDrakon extends Feind {
	private ArrayList <BigDrakonsBullet> bullets;
	private String          richtung = "south";
	private boolean         killed  =  true;
	private int             killCount = 0;
	private int             timer = 0;
	private BufferStrategy  bs;
	        Intellekt       intellekt ; 
	        SpriteSchneider spriteSchneider ;
	        Spieler         spieler ;
	    PersonsImageLoader  personsImageLoader;
	private  BufferedImage  image;
	private static BigDrakon bigDrakon = new BigDrakon();
	public ArrayList<BigDrakonsBullet> getBullets() {
		return bullets;
	}
	
	private BigDrakon (){
		intellekt = new Intellekt();
		intellekt.setRoom(new Room3(), 3);
		intellekt.setX(300);
		intellekt.setY(200);
		this.personsImageLoader = PersonsImageLoader.getPersonsImageLoader();
		this.image = PersonsImageLoader.getPersonsImageLoader().getBigDrakonImage();
		this.spriteSchneider = new SpriteSchneider(image, 2, 3, 1, 0, 5);
		this.bullets = new ArrayList<>();
		this.spieler = Spieler.getSpieler();
		spriteSchneider.setZahl(2);
	}
	
	public static BigDrakon getBigDrakon() {
		return bigDrakon;
	}
	
	@Override
	public BufferStrategy getBs() {
		return bs;
	}

	@Override
	public void setBs(BufferStrategy bs) {
		this.bs = bs;
		
	}

	@Override
	public boolean isKilled() {
		return killed;
	}

	@Override
	public void setKilled(boolean killed) {
		this.killed = killed;
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
		if (killCount == 40){
			killed = true;
			killCount = 0;
		}
		if (!killed){
			killCount++;
		}
	}

	@Override
	public BufferedImage getFeindSprite() {
		timer ++;
		if (timer == 20){
			if (!spieler.isKilled()){
				strike();
			}
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
		return intellekt.getY() + spriteSchneider.getSpirteHeight()/2;
	}

	@Override
	public void strike() {
		if (intellekt.isEast()){
			richtung = "east";
		}
		if (intellekt.isWest()){
			richtung = "west";
		}
		if (intellekt.isNorth()){
			richtung = "north";
		}
		if (intellekt.isSouth()){
			richtung = "south";
		}
		int x = getCenterX();
		int y = getCenterY();
		int spielerX = spieler.getCenterX();
		int spielerY = spieler.getCenterY();
		if ((richtung == "west")|(richtung == "east")){
		if (Math.abs(y - spielerY) <= 60){
		BigDrakonsBullet bullet = new BigDrakonsBullet(getCenterX(), getCenterY(), richtung, bs);
		bullets.add(bullet);
		}
		}
		if ((richtung == "north")|(richtung == "south")){
			if (Math.abs(x - spielerX) <= 60){
			BigDrakonsBullet bullet = new BigDrakonsBullet(getCenterX(), getCenterY(), richtung, bs);
			bullets.add(bullet);
			}
		}
	}
}
