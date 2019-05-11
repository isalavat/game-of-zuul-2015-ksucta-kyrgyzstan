package model.rooms;

import java.awt.image.BufferedImage;

public abstract class Room {
	public abstract void setOpenDoor(boolean openDoor);
	public abstract  boolean isOpenDoor() ;
	public abstract BufferedImage getImage ();
	public abstract boolean isX(int x, int y, String richtung);
	public abstract boolean isY(int x, int y, String richtung);
	public abstract boolean isDestroy(int x, int y, int speed, String richtung);
	public abstract int getTurX();
	public abstract int getTurY();
	
}

