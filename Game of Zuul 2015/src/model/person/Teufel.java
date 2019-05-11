package model.person;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import model.bulletspackage.FeindsBullet;
import model.resourceloader.PersonsImageLoader;
import model.rooms.Room1;
import model.sprite.SpriteSchneider;
import model.kuenstlicheintelligenz.Intellekt;

public class Teufel extends Feind {
	private static Teufel   teufel = new Teufel();
	private BufferedImage   image;
	        String          richtung = "north";
	        int             timer = 0;
	        Spieler         spieler ;
	        Intellekt       intellekt;
	        SpriteSchneider spriteSchneider ;
	private BufferStrategy  bs;
	private int             killCount = 0;
	private boolean         killed = false;
	private ArrayList<FeindsBullet> bullets;
	
	private Teufel(){
		intellekt = new Intellekt();
		intellekt.setSpeed(2);
		intellekt.setRoom(new Room1(), 1);
		this.image = PersonsImageLoader.getPersonsImageLoader().getTeufelImage();
		spriteSchneider = new SpriteSchneider(image, 2, 1, 3, 0, 3);
		bullets = new ArrayList<>();
		spieler = Spieler.getSpieler();
	}
	
	public static Teufel getTeufel() {
		return teufel;
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
	public int getKillCount() {
		return killCount;
	}
	
	@Override
	public void setKillCount(int killCount) {
		this.killCount = killCount;
	}

	public  boolean isKilled() {
		return killed;
	}

	public  void setKilled(boolean killed) {
		this.killed = killed;
	}

	@Override
	public  void plusKillCount(){
		if (killCount == 30){
			killed = true;
			killCount = 0;
		}
		if (!killed){
			killCount++;
		}
	}	
		
	@Override
	public BufferedImage getFeindSprite(){
		if (timer == 30){
			timer = 0;
		}	
	
		if (timer == 0){
			if (!spieler.isKilled()){
				strike();
			}
		}
		timer++;
		return spriteSchneider.getSchniedeneSprite(intellekt.isEast(), intellekt.isWest(), intellekt.isNorth(), intellekt.isSouth());
	}
	
	@Override
	public int getX(){
		if (!spieler.isKilled()){
			intellekt.klug3();
		}
		return intellekt.getX();
	}
	
	@Override
	public int getY(){
		return intellekt.getY();
	}
	
	@Override
	public int getCenterX(){
		return intellekt.getX()+spriteSchneider.getSpirteWidth()/2;
	}
	
	public ArrayList<FeindsBullet> getBullets() {
		return bullets;
	}
	
	@Override
	public int getCenterY(){
		return intellekt.getY()+spriteSchneider.getSpirteHeight()/2;
	}
	
	@Override
	public void strike(){
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
			if (Math.abs(y - spielerY) <= 50){
					FeindsBullet bullet = new FeindsBullet (getX()+spriteSchneider.getSpirteWidth()/2,getY()+spriteSchneider.getSpirteHeight()/2, richtung, bs);
					bullets.add(bullet);
				}
			}
		
		if ((richtung == "north")|(richtung == "south")){
			if (Math.abs(x - spielerX) <= 50){
					FeindsBullet bullet = new FeindsBullet (getX()+spriteSchneider.getSpirteWidth()/2,getY()+spriteSchneider.getSpirteHeight()/2, richtung, bs);
					bullets.add(bullet);
			}
		}
	}
}
