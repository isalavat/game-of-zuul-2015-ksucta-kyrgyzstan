package model.person;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
public abstract class Feind {
	public abstract BufferStrategy getBs();
	public abstract void setBs(BufferStrategy bs);
	public abstract boolean isKilled();
	public abstract void setKilled(boolean killed); 
	public abstract int getKillCount();
	public abstract void setKillCount(int killCount);
	public abstract void plusKillCount();
	public abstract BufferedImage getFeindSprite();
	public abstract int getX();
	public abstract int getY();
	public abstract int getCenterX();
	public abstract int getCenterY();
	public abstract void strike();
}
