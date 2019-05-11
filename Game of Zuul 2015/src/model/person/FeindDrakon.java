package model.person;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import model.bulletspackage.FeindsBullet;
import model.resourceloader.PersonsImageLoader;
import model.rooms.Room2;
import model.sprite.SpriteSchneider;
import model.kuenstlicheintelligenz.Intellekt;

public class FeindDrakon extends Feind {
	private static FeindDrakon feindDrakon = new FeindDrakon();
	private BufferedImage      image;
    private int                timer = 0;
	private BufferStrategy     bs;
	private int                killCount = 0;
	private boolean            killed = true;
	        Spieler            spieler ;
	        Intellekt          intellekt;
	        SpriteSchneider    spriteSchneider ;
	        PersonsImageLoader personsImageLoader;
	private ArrayList<FeindsBullet> bullets;
	
	private FeindDrakon(){
		personsImageLoader = PersonsImageLoader.getPersonsImageLoader();
		image              = personsImageLoader.getFeindDrakonImage();
		spieler            = Spieler.getSpieler();
		intellekt          = new Intellekt();
		spriteSchneider    = new SpriteSchneider(image, 2, 1, 3, 0, 4);
		bullets            = new ArrayList<>();
		intellekt.setY(100);
		intellekt.setX(600);
		intellekt.setSpeed(2);
		intellekt.setRoom(new Room2(), 2);
	}
	
	public static FeindDrakon getFeindDrakon(){
		return feindDrakon;
	}
	
	@Override
	public int getKillCount() {
		return killCount;
	}

	public void setKillCount(int killCount) {
		this.killCount = killCount;
	}

	public boolean isKilled() {
		return killed;
	}

	public void setKilled(boolean killed) {
		this.killed = killed;
	}
	
	@Override
	public  void plusKillCount(){
		if (killCount == 50){
			killed = true;			
		}
		if (!killed){
			killCount++;
		}
	} 

	@Override
	public BufferedImage getFeindSprite(){
		if (!spieler.isKilled()){
			strike();
		}
		return spriteSchneider.getSchniedeneSprite(intellekt.isEast(), intellekt.isWest(), intellekt.isNorth(), intellekt.isSouth());    
	}
	
	@Override
	public int getX(){
		if (!spieler.isKilled()){
			intellekt.klug2();
		}
		
		return  intellekt.getX();
	}
	
	@Override
	public int getY(){
		return  intellekt.getY();
	}
	
	@Override
	public int getCenterX(){
		return intellekt.getX()+spriteSchneider.getSpirteWidth()/2;
	}
	
	@Override
	public int getCenterY(){
		return intellekt.getY()+spriteSchneider.getSpirteHeight()/2;
	}

	@Override
	public BufferStrategy getBs() {
		
		return null;
	}

	@Override
	public void setBs(BufferStrategy bs) {
		this.bs = bs;
		
	}

	public ArrayList<FeindsBullet> getBullets() {
		return bullets;
	}

	@Override
	public void strike(){
		int x = getCenterX();
		int y = getCenterY();
		String richtung = "west";
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
		
		int spielerX = spieler.getCenterX();
		int spielerY = spieler.getCenterY();
		if ((richtung == "west")|(richtung == "east")){
			if (Math.abs(y - spielerY) <= 60){
				if (timer == 40){
					timer = 0;
					FeindsBullet bullet = new FeindsBullet (getX()+spriteSchneider.getSpirteWidth()/2,getY()+spriteSchneider.getSpirteHeight()/2, richtung, bs);
					bullets.add(bullet);
				}
				timer++;
			}
		}
		if ((richtung == "north")|(richtung == "south")){
			if (Math.abs(x - spielerX) <= 60){
				if (timer == 40){
					timer = 0;
					FeindsBullet bullet = new FeindsBullet (getX()+spriteSchneider.getSpirteWidth()/2,getY()+spriteSchneider.getSpirteHeight()/2, richtung, bs);
					bullets.add(bullet);
				}
				timer++;
			}
		}
	}
}
