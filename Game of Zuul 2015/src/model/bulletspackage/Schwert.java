package model.bulletspackage;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import model.resourceloader.PersonsImageLoader;

public class Schwert extends BulletsAbstract {
    private int zahl = 0;
	private int x;
	private int y;
	private BufferStrategy bs;
	private PersonsImageLoader loader;
	private String richtung;
	private Graphics g;
	private boolean first = false;
	private BufferedImage image;
	private int width;
	private int height;
	private int speed = 8;
	private int count = 0;
	
	public Schwert(int x ,int y,String richtung, BufferStrategy bs){
		this.bs = bs;
		this.loader = PersonsImageLoader.getPersonsImageLoader();
		this.image = loader.getSchwertImage();
		this.richtung = richtung; 
		this.width = image.getWidth()/5;
		this.height = image.getHeight()/4;
		this.x = x;
		this.y = y;
		this.g = bs.getDrawGraphics(); 
	}
	
	@Override
	public void setSpeed(int speed) {
		this.speed = speed;	
	}

	@Override
	public void draw() {
		
		if (count == 5){
			count = 0;
		}
		
		if (richtung == "east"){
			x+=speed;
			g.drawImage(image.getSubimage(count*width, height, width, height),x,y,null);
		}
		
		if (richtung == "west"){
			x-=speed;
			g.drawImage(image.getSubimage(count*width, width, width, height),x,y,null);
		}
	
		if (richtung == "north"){
			y-=speed;
			g.drawImage(image.getSubimage(count*width, 3*height, width, height),x,y,null);
		}
		
		if (richtung == "south"){
			y+=speed;
			g.drawImage(image.getSubimage(count*width, 2*height, width, height),x,y,null);
		}
        
		if (zahl == 3){
	       count ++;
	       zahl = 0;
		}
        zahl++;
	}

	public String getRichtung() {
		return richtung;
	}

	public void setY(int y) {
		this.y = y;
	}
	@Override

	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
}
