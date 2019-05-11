package model.person;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import model.bulletspackage.FeindsBullet;
import model.resourceloader.PersonsImageLoader;
import model.rooms.Room1;
import model.sprite.SpriteSchneider;
import model.kuenstlicheintelligenz.Intellekt;

public class Hexe extends Feind {
	private ArrayList <FeindsBullet> bullets;
	private String             richtung = "south";
    private boolean            killed = true;
    private int                killCount = 0;
	private int                timer = 0;
	private BufferStrategy     bs;
	        Intellekt          intellekt ; 
	        SpriteSchneider    spriteSchneider ;
	        Spieler            spieler ;
	        PersonsImageLoader personsImageLoader;
	private BufferedImage      image;
	private static Hexe        hexe = new Hexe();
    
	private Hexe (){
		intellekt = new Intellekt();
		intellekt.setRoom(new Room1(), 1);
		this.personsImageLoader = PersonsImageLoader.getPersonsImageLoader();
		this.image = PersonsImageLoader.getPersonsImageLoader().getHexeImage();
		this.spriteSchneider = new SpriteSchneider(image, 2, 1, 3, 0, 4);
		this.bullets = new ArrayList<>();
		this.spieler = Spieler.getSpieler();
	}
	
	public static Hexe getHexe() {
		return hexe;
	}
	
	public ArrayList<FeindsBullet> getBullets() {
		return bullets;
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
		if (timer == 15){
			timer = 0;
		if (!spieler.isKilled()){
			strike();
		}
		}
		timer++;
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
					FeindsBullet bullet = new FeindsBullet (getX()+spriteSchneider.getSpirteWidth()/2,getY()+spriteSchneider.getSpirteHeight()/2, richtung, bs);
					bullets.add(bullet);
			}
		}
		if ((richtung == "north")|(richtung == "south")){
			if (Math.abs(x - spielerX) <= 60){
				
					FeindsBullet bullet = new FeindsBullet (getX()+spriteSchneider.getSpirteWidth()/2,getY()+spriteSchneider.getSpirteHeight()/2, richtung, bs);
					bullets.add(bullet);
				
			}
		}
		
	}
}
