package model.effekten;

import java.awt.image.BufferedImage;

import model.resourceloader.PersonsImageLoader;

public class Herz {
	private BufferedImage image;
	private int width;
	private int height;
	private int i = 0;
	private int j = 0;
	private int x = 500;
	private int y = 100;
	private boolean visible = false;
	private boolean verschwinden = false;
	public boolean isVerschwinden() {
		return verschwinden;
	}

	public void setVerschwinden(boolean verschwinden) {
		this.verschwinden = verschwinden;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	private static Herz herz = new Herz();
	public static Herz getHerz() {
		return herz;
	}
	
	private Herz(){
		this.image = PersonsImageLoader.getPersonsImageLoader().getHerz();
		this.width = image.getWidth()/6;
		this.height = image.getHeight();
	}
	
	public int getCenterX(){
		return x+width/2;
	}
	public int getCenterY(){
		return y+height/2;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public BufferedImage getHerzSprite (){
		if (i == 5){
			i = 0;
		}
		if (j == 3){
			i++;
			j = 0;
		}
		j++;
		return image.getSubimage(width*i, 0, width, height);
		
	}
}
