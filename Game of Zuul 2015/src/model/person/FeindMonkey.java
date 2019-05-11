package model.person;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import model.bulletspackage.FeindsBullet;
import model.resourceloader.PersonsImageLoader;
import model.rooms.Room1;
import model.sprite.SpriteSchneider;
import model.kuenstlicheintelligenz.Intellekt;

public class FeindMonkey extends Feind{
	private static FeindMonkey feindMonkey = new FeindMonkey();
	private ArrayList<FeindsBullet> bullets;
	private boolean             killed = true;
	private int                 killCount = 0;
	private int                 timer = 0;
	private String              richtung;
	private BufferStrategy      bs;
	        Intellekt           intellekt ; 
	        SpriteSchneider     spriteSchneider ;
	        Spieler             spieler ;
	        PersonsImageLoader  personsImageLoader;
	private BufferedImage       image;
	
	private FeindMonkey(){
		personsImageLoader = PersonsImageLoader.getPersonsImageLoader();
		image              = personsImageLoader.getFeindMonkeyImage();
		intellekt          = new Intellekt(); 
		spriteSchneider    = new SpriteSchneider(image, 2, 1, 3, 0, 4);
		spieler            = Spieler.getSpieler();
		bullets            = new ArrayList<>();
		intellekt.setRoom(new Room1(), 1);
	}
	
	public static FeindMonkey getFeindMonkey(){
		return feindMonkey;
	}
	
	@Override
	public void setBs(BufferStrategy bs) {
		this.bs = bs;
	}
	
	public boolean isKilled() {
		return killed;
	}
	
	@Override
	public void plusKillCount(){
		if (killCount == 50){
			killed = true;
		}
		
		if (!killed){
			killCount++;
		}
		
	}	
	
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
	   
	public ArrayList<FeindsBullet> getBullets() {
		return bullets;
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
			intellekt.klug();
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

	@Override
	public int getCenterY(){
		return intellekt.getY()+spriteSchneider.getSpirteHeight()/2;
	}

	@Override
	public void  strike(){
		if (intellekt.isEast()){
			richtung = "east";
		}
		if (intellekt.isWest()){
			richtung = "west";
		}
		
			if (timer == 19){
				timer = 0;
				FeindsBullet bullet = new FeindsBullet(getCenterX(), getCenterY(), richtung, bs);
				bullet.setSpeed(20);
				bullets.add(bullet);
				bullet.draw();
			}
		timer ++;
	}
	
	@Override
	public BufferStrategy getBs() {
		return bs;
	}
}










