package model.person;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import model.bulletspackage.Bullet;
import model.effekten.Key;
import model.effekten.Truhe;
import model.observerpackage.KeyObserver;
import model.resourceloader.PersonsImageLoader;
import model.rooms.*;
import model.sprite.SpriteSchneider;

public class Spieler {
	private int                x = 400;
	private int                y = 550;
	private int                level;
	public  Room               room;
	private ArrayList<Bullet>  bullets;
	        SpriteSchneider    spriteSchneider;
	        BufferedImage      image;
	private boolean bullet     = false;
	        String richtung    = "south";
	private BufferStrategy     bs;
	        KeyObserver        keyObserver;
	        Truhe              truhe;
	private boolean east       = false;
	private boolean west       = false;
	private boolean north      = false;
	private boolean south      = false ;
	int     speed              = 2;
	int     countSpriteInWidth = 11;
	int     eastSprite         = 3;
	int     westSprite         = 2;
	int     northSprite        = 1;
	int     southSprite        = 0;
	private boolean            killed = false;
	private int killCount      = 0;
	int     spirteWidth ;
	int     spirteHeight;
	        PersonsImageLoader personsImageLoader;
	        Key                key;
	private boolean gibtEsKey  = false;
	private boolean gibtEsTruhe = false;
	public boolean isGibtEsTruhe() {
		return gibtEsTruhe;
	}

	public void setGibtEsTruhe(boolean gibtEsTruhe) {
		this.gibtEsTruhe = gibtEsTruhe;
	}

	private static Spieler spieler = new Spieler(); 
	private Spieler(){
		bullets            = new ArrayList<Bullet>();
		personsImageLoader = PersonsImageLoader.getPersonsImageLoader();
		image              = personsImageLoader.getSpielerImage(); 
		spriteSchneider    = new SpriteSchneider(image, 3, 2, 1, 0, 11);
		key                = Key.getKey();
		keyObserver        = KeyObserver.getKeyObserver();
	}
	
	public boolean isGibtEsKey() {
		return gibtEsKey;
	}

	public void setGibtEsKey(boolean gibtEsKey) {
		this.gibtEsKey = gibtEsKey;
	}

	public void setRoom(Room room, int level) {
		if (level == 1){
			this.room = ((Room1)room);
		}

		if (level == 2){
			this.room = ((Room2)room);
		}
	
		if (level == 3){
			this.room = ((Room3)room);
			this.level = level;
		}
	}
	
	public BufferStrategy getBs() {
		return bs;
	}

	public void setBs(BufferStrategy bs) {
		this.bs = bs;
	}
	
	public ArrayList<Bullet> getBullets() {
		return bullets;
	}

	public static Spieler getSpieler(){
		return spieler;
	}
	
	public int getKillCount() {
		return killCount;
	}

	public void setKillCount(int killCount) {
		this.killCount = killCount;
	}
    
	public void plusKillCount(){
		killCount++;
		bullet = true;
	}
	
	public boolean isKilled() {
		return killed;
	}

	public void setKilled(boolean killed) {
		this.killed = killed;
	}

	
	public int getSpirteHeight() {
		return spirteHeight;
	}

	public void setSpirteHeight(int spirteHeight) {
		this.spirteHeight = spirteHeight;
	}

	public boolean isEast() {
		return east;
	}

	public boolean isWest() {
		return west;
	}

	public boolean isNorth() {
		return north;
	}

	public boolean isSouth() {
		return south;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public BufferedImage getSpielerSprite(){
		if ((x>330)&(x<480)&(y<=60)&(gibtEsKey)){
			this.openTheDoorWithoutCmd();
		}
		
		spriteSchneider.setZahl(5);
		boolean east_ = east;
		boolean west_ = west;
		boolean north_ = north;
		boolean south_ = south;
		
		if (east){
			richtung = "east";
		}
		
		if (west){
			richtung = "west";
		}
		
		if (north){
			richtung = "north";
		}
		
		if (south){
			richtung = "south";
		}
		this.east = false;
		this.west = false;
		this.north = false;
		this.south = false;

		if (spriteSchneider.getCount()>=7){
			spriteSchneider.setCount(0);
		}
		if (bullet){
			spriteSchneider.setCount(7);
			bullet = false;
		}	
		return spriteSchneider.getSchniedeneSprite(east_, west_, north_, south_);
	}
	public void openTheDoorWithoutCmd(){
		if (level == 3){
			return;
		}
		this.gibtEsKey = false;
		room.setOpenDoor(true);
	}

	public void openTheDoor(){
		int x_ = room.getTurX();
		int y_ = room.getTurY();
		
		if (level == 3){
			return;
		}
		
		if (gibtEsKey){
			if (Math.abs((x_-getCenterX()))>=5){
				if (x_>getCenterX()){
					x+=speed;
					east = true;
					return;
				}
				if (x_<getCenterX()){
					x-=speed;
					west = true;
					return;
				}
			}
		
			if ((Math.abs((x_-getCenterX()))<5) & (Math.abs((y_-getCenterY()))>=5)){
				if (y_>getCenterY()){
					y+=speed;
					south = true;
					return;
				}
				if (y_<getCenterY()){
					y-=speed;
					north = true;
					return;
				}
			}
			this.gibtEsKey = false;
			room.setOpenDoor(true);
		}
	}
	
	public void nimmKey(){
		if (keyObserver.getDistance()>60){
			int x_ = key.getCenterX();
			int y_ = key.getCenterY();
			if (Math.abs(x_-getCenterX())>=5){
				if (x_>getCenterX()){
					x+=speed;
					east = true;
				}
				if (x_<getCenterX()){
					x-=speed;
					west = true;
				}
			}
			if (Math.abs(x_-getCenterX())<5){
				if (y_>getCenterY()){
					y+=speed;
					south = true;
				}
				if (y_<getCenterY()){
					y-=speed;
					north = true;
				}
			}
		}
	}
	
	public int getSpeed() {
		return speed;
	}

	public void schnellGehenOn(){
		speed = 4;
	}
	public void schnellGehenOff(){
		speed = 2;
	}
	
	public  void goEast(){
		east = true;
		if (room.isX(x ,y, "east")){
		
			if (!killed){
				x+=speed;
			}	
		}
		
	}

	public void  goWest(){
		west = true;
		if ( room.isX(x, y, "west")){
			if (!killed){
				x-=speed;
			}	
		}
		
	}
	
	public  void goNorth(){
		north = true;
		if (room.isY(x, y, "north")){
		
			if (!killed){
				y-=speed;
			}
		}
	   
	}
	
	public void goSouth(){
		south = true;
		if (room.isY(x,y,"south")){
	
			if (!killed){
				y+=speed;
			}
		}
		
	}
	
	public  void  strike (){
		if (!killed){	
			Bullet b = new Bullet(getCenterX(),getCenterY(),richtung,bs);
			bullets.add(b);
		}
	}
	
	public int getCenterX(){
		return x+spriteSchneider.getSpirteWidth()/2;
	}
	
	public int getCenterY(){
		return y+spriteSchneider.getSpirteHeight()/2;
	}
}
