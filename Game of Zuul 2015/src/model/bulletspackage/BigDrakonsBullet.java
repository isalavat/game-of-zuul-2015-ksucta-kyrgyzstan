package model.bulletspackage;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import model.resourceloader.PersonsImageLoader;

public class BigDrakonsBullet {
 	private String richtung ;
	private int x;
	private int y;
	private int count = 0;
	private int speed = 10;
    private boolean plus = false;
	private BufferStrategy bs;
	private BufferedImage image;
	private BufferedImage bulletImage;
	private BufferedImage effekt;
	private Graphics g;
	private int spriteWidth;
	private int spriteHeight;
	public BigDrakonsBullet(int x, int y, String richtung, BufferStrategy bs){
		this.bs = bs;
		this.g = bs.getDrawGraphics(); 
		this.x = x;
		this.y = y;
		this.richtung = richtung;
		this.image = PersonsImageLoader.getPersonsImageLoader().getDrakonFire();
		this.spriteHeight = image.getHeight()/5;
		this.spriteWidth = image.getWidth()/2;
		this.effekt = image.getSubimage(0, 4*spriteHeight, spriteWidth, spriteHeight);
		if (richtung == "east"){
			bulletImage =  image.getSubimage( 0 ,2*spriteHeight, spriteWidth*2, spriteHeight); 
		}
		if (richtung == "west"){
			bulletImage =  image.getSubimage( 0 ,3*spriteHeight, spriteWidth*2, spriteHeight); 
		}
		if (richtung == "north"){
			bulletImage =  image.getSubimage( 0 ,spriteHeight, spriteWidth*2, spriteHeight); 
		}
		if (richtung == "south"){
			bulletImage =  image.getSubimage( 0 , 0, spriteWidth*2, spriteHeight); 
		}
	}

	public void draw(){
		if (count == 2){
			count = 0;
		}
		if (richtung == "east"){
			if (!plus){
				y-=50;
				plus = true;
			}
			x+=speed;
			g.drawImage(bulletImage.getSubimage(spriteWidth*count, 0, spriteWidth, spriteHeight), x, y, null);
		}
		
		if (richtung == "west"){
			if (!plus){
				x-=50;
				y-=50;
				plus = true;
			}
			x-=speed;
			g.drawImage(bulletImage.getSubimage(spriteWidth*count, 0, spriteWidth, spriteHeight), x, y, null);
		}
		
		if (richtung == "north"){
			if (!plus){
				x-=30;
				y-=60;
				plus = true;
			}
			y-=speed;
			g.drawImage(bulletImage.getSubimage(spriteWidth*count, 0, spriteWidth, spriteHeight), x, y, null);
		}
		
		if (richtung == "south"){
			if (!plus){
				x-=30;
				plus = true;
			}
			y+=speed;
			g.drawImage(bulletImage.getSubimage(spriteWidth*count, 0, spriteWidth, spriteHeight), x, y, null);
		}
		
		count++;
	}

	public String getRichtung() {
		return richtung;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getCenterX(){
		return x+spriteWidth/2;
	}

	public int getCenterY(){
		return y+spriteHeight/2;
	}
}
