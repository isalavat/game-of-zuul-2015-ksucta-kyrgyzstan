package model.effekten;

import java.awt.image.BufferedImage;

import model.resourceloader.PersonsImageLoader;

public class Key {
	private BufferedImage image;
	private int x = 500;
	private int y = 500;
	private boolean visible = false;
	private int width;
	private int height;
	private int i = 0;
	private int j = 0;
	private boolean verschwinden = false;
	public boolean isVerschwinden() {
		return verschwinden;
	}

	public void setVerschwinden(boolean verschwinden) {
		this.verschwinden = verschwinden;
	}

	public int getCenterX() {
		return x+width/2;
	}
	
	public int getCenterY() {
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

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	private static Key key = new Key();
	private Key(){
		this.image = PersonsImageLoader.getPersonsImageLoader().getKey();
		this.width = image.getWidth()/11;
		this.height = image.getHeight();
	}
	
	public static Key getKey() {
		return key;
	}
	
	public BufferedImage getKeySprite (){
		if (i == 10){
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
