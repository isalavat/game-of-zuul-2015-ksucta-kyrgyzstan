package model.person;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import model.bulletspackage.Bullet;
import model.resourceloader.PersonsImageLoader;
import model.rooms.Room2;
import model.sprite.SpriteSchneider;
import model.kuenstlicheintelligenz.Intellekt;

public class Soldat extends Feind {
	private ArrayList <Bullet> bullets;
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
	private static Soldat      soldat = new Soldat();
	private Soldat (){
		intellekt               = new Intellekt();
		this.personsImageLoader = PersonsImageLoader.getPersonsImageLoader();
		this.image              = PersonsImageLoader.getPersonsImageLoader().getSoldatImage();
		this.spriteSchneider    = new SpriteSchneider(image, 3, 2, 1, 0, 11);
		this.bullets            = new ArrayList<>();
		this.spieler            = Spieler.getSpieler();
		intellekt.setRoom(new Room2(), 2);
		intellekt.setZahl(10);
		spriteSchneider.setZahl(5);
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
		killCount++;		
		if (killCount == 40){
			killed = true;
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
		if (timer == 20){
			timer = 0;
		}
		return spriteSchneider.getSchniedeneSprite(intellekt.isEast(), intellekt.isWest(), intellekt.isNorth(), intellekt.isSouth());
	}

	public ArrayList<Bullet> getBullets() {
		return bullets;
	}

	public void setBullets(ArrayList<Bullet> bullets) {
		this.bullets = bullets;
	}

	public static Soldat getSoldat() {
		return soldat;
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

	@Override
	public void strike() {
		if (intellekt.isNorth()){
			richtung = "north";
		}
		if (intellekt.isSouth()){
			richtung = "south";
		}
		if (intellekt.isEast()){
			richtung = "east";
		}
		if (intellekt.isWest()){
			richtung = "west";
		}
		int x_ = spieler.getCenterX();
		int y_ = spieler.getCenterY();
		if ((Math.abs((x_-getCenterX()))<=50)&((richtung == "south")|(richtung == "north"))){
			Bullet bullet = new Bullet(getCenterX(), getCenterY(), richtung, bs);
			bullets.add(bullet);
		}
		
		if ((Math.abs((y_-getCenterY()))<=50)&((richtung == "west")|(richtung == "east"))){
			Bullet bullet = new Bullet(getCenterX(), getCenterY(), richtung, bs);
			bullets.add(bullet);
		}

	}

}
