package model.bulletspackage;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import model.resourceloader.PersonsImageLoader;
public class FeindsBullet extends BulletsAbstract {
	private int x;
	private int y;
	private BufferStrategy bs;
	private PersonsImageLoader loader;
	private String richtung;
	private Graphics g;
	private BufferedImage image;
	private int width;
	private int height;
	public String getRichtung() {
		return richtung;
	}

	private int speed = 6;
	public FeindsBullet(int x ,int y,String richtung, BufferStrategy bs){
		this.bs = bs;
		this.loader = PersonsImageLoader.getPersonsImageLoader();
		this.image = loader.getEffeckts();
		this.richtung = richtung; 
		this.width = image.getWidth()/13;
		this.height = image.getHeight()/4;
		this.x = x;
		this.y = y;
		this.g = bs.getDrawGraphics(); 
	}
	
	public void setSpeed(int speed){
		this.speed = speed;
	} 

	public void draw (){
		if (richtung == "east"){
			g.drawImage(image.getSubimage(width*5, 0, width, height), x+30, y-15, null);
			x+=speed;
		}
		if (richtung == "west"){
			g.drawImage(image.getSubimage(width*5, 0, width, height), x-30, y-15, null);
			x-=speed;
		}
		if (richtung == "north"){
			g.drawImage(image.getSubimage(width*5, 0, width, height), x-15, y-50, null);
			y-=speed;
		}
		if (richtung == "south"){
			g.drawImage(image.getSubimage(width*5, 0, width, height), x-15, y+30, null);
			y+=speed;
		}
		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
