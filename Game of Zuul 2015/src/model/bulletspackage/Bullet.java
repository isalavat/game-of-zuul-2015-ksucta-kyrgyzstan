package model.bulletspackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Bullet extends BulletsAbstract {
	private String richtung;
	private int x;
	private int y;
	private int speed = 10;
	private BufferStrategy bs;
	private Graphics g;
    private boolean b = true;    
	public Bullet(int x , int y,String richtung, BufferStrategy bs){
		this.x = x;
		this.y = y;
		this.bs = bs;
		this.richtung = richtung;
		g = bs.getDrawGraphics();
	}
	
	public void draw(){
		if (richtung == "east"){
			if (b){
				b = false;
				y+=20;
				x+=20;
				g.setColor(Color.red);
				g.fillOval(x+=speed-10, y-3,15, 15);
			}
			g.setColor(Color.WHITE);
			g.fillOval(x+=speed, y, 10, 10);
		}
		
		if (richtung == "west"){
			if (b){
				b = false;
				y+=20;
				x-=45;
				g.setColor(Color.red);
				g.fillOval(x+=speed, y-3,15, 15);
			}
			g.setColor(Color.WHITE);
			g.fillOval(x-=speed, y, 10, 10);
		}
		if (richtung == "south"){
			if (b){
				b = false;
				y+=20;
				x-=20;
				g.setColor(Color.red);
				g.fillOval(x, y+=speed,15, 15);
				
			}
			g.setColor(Color.WHITE);
			g.fillOval(x, y+=speed, 10, 10);
		}
		if (richtung == "north"){
			if (b){
				b = false;
				y-=20;
			}
			g.setColor(Color.WHITE);
			g.fillOval(x, y-=speed, 10, 10);
		}
	}

	public String getRichtung() {
		return richtung;
	}

	public int getSpeed() {
		return speed;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
		
	}
}
