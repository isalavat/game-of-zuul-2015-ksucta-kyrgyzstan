package model.effekten;

import java.awt.image.BufferedImage;

import model.resourceloader.PersonsImageLoader;

public class Truhe {
	private static Truhe truhe = new Truhe();
	private int x = 800;
	private int y = 100;
	private BufferedImage image;
	private boolean offen = false;
	private boolean visible = true;
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isOffen() {
		return offen;
	}

	public void setOffen(boolean offen) {
		this.offen = offen;
	}

	private int width;
	private int height;
	private Truhe (){
		this.image = PersonsImageLoader.getPersonsImageLoader().getTruheImage();
		this.width = image.getWidth()/2;
		this.height = image.getHeight();
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
	
	public int getCenterX(){
		return x+width/2;
	}
	
	public int getCenterY(){
		return y+height/2;
	}

	public BufferedImage getTruheImage(){
		if (offen){
			return image.getSubimage(width, 0, width, height);
		}
		return image.getSubimage(0, 0, width, height);
	}

	public static Truhe getTruhe() {
		return truhe;
	}
}
