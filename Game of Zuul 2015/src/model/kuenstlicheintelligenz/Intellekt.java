package model.kuenstlicheintelligenz;

import model.person.Spieler;
import model.rooms.*;
public class Intellekt {
	Spieler spieler = Spieler.getSpieler();
	private int speed = 1;
	int zahl = 0;
	public void setZahl(int zahl) {
		this.zahl = zahl;
	}

	private int speed2 = 10;
	private boolean east = true;
	private boolean west = false;
	private boolean north = false ;
	private boolean south = false;
	private int x = 200;
	private int y = 200;
	public void setX(int x) {
		this.x = x;
	}

	private boolean isNull = false;
    private  Room room ;
	private double distance = 1000;
	public void setRoom(Room room, int level) {
		
		if (level == 1){
			this.room = ((Room1)room);
		}
		if (level == 2){
			this.room = ((Room2)room);
		}
		if (level == 3){
			this.room = ((Room3)room);
		}
	}
	public double getDistance() {
		return distance;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getX(){
		return x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public boolean isEast() {
		return east;
	}

	public void setEast(boolean east) {
		this.east = east;
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

	public int getY() {
		return y;
	}

	public void klug(){
		
		if ((east)&(x >= 100) & (x < 700)){
			x+=speed2;
		}
		if ((x == 700)&(east )){
			east = false;
			west = true;
			north = false;
			south = false;
			x-=speed2;
		}
		if ((west)&(x < 700)&(x > 100)){
			x-=speed2;
		}
		
		if ((west)&(x == 100)){
			east = true;
			west = false;
			north = false;
			south = false;
			x+=speed2;
		}
		
	}
	
	public void klug2(){
		int x_ = spieler.getX();
		int y_ = spieler.getY();
		distance = Math.sqrt(Math.pow((x_-x), 2)+Math.pow((y_-y), 2));
		if (distance > 90){
		int distanseX =  Math.abs(x-x_);
		int distanseY =  Math.abs(y-y_);
		if (distanseX == distanseY){
			isNull = true;
			if (x_ < x){
				east = false;
				west = true;
				north = false;
				south = false;
			}
			if (x_ > x){
				east = true;
				west = false;
				north = false;
				south = false;
			}
		}
		if (Math.abs(distanseY-distanseX)>=64){
			isNull = false;
		}
		if (isNull){
			if (west){
				if (room.isX(x,y,"west")){
					x-=speed;
				}
			}
			if (east){
				if (room.isX(x, y, "east")){
					x+=speed;
				}


			}
		}
		if (isNull){
			return;
		}	
		if (distanseX > distanseY){
			if (x_ < x ){
				east = false;
				west = true;
				north = false;
				south = false;
				if (room.isX(x, y, "west")){
					x-=speed;
					return;
				}
				
			}
			if (x_ > x ){
				east = true;
				west = false;
				north = false;
				south = false;
				if (room.isX(x, y, "east")){
					x+=speed;
					return;
				}
				
			}
			
				if (y_<y){
					east = false;
					west = false;
					north = true;
					south = false;
					y-=speed;
					
				}
				if (y_>y){
					east = false;
					west = false;
					north = false;
					south = true;
					y+=speed;
				}
		}
		
		if (distanseY >distanseX ){
			if (y_ > y){
				east = false;
				west = false;
				north = false;
				south = true;
				if (room.isY(x, y-zahl, "south")){
					y+=speed;
					return;
				}	
			}
			
			if(y_ < y){
				east = false;
				west = false;
				north = true;
				south = false;
				if (room.isY(x, y, "north")){
					y-=speed;
					return;
				}
			}
			
				if (x_>x){
					east = true;
					west = false;
					north = false;
					south = false;
					x+=speed;
				}
				if (x_<x){
					east = false;
					west = true;
					north = false;
					south = false;
					x-=speed;
				}
			
			
		}
	  }
	}
	
	public void klug3(){
		int x_ = spieler.getX();
		int y_ = spieler.getY();
		distance = Math.sqrt(Math.pow((x_-x), 2)+Math.pow((y_-y), 2));
		if (distance > 90){
		if (Math.abs(x_-x)>=5){
			if (x_>x){
				
				east = true;
				west = false;
				north = false;
				south = false;
				if (room.isX(x, y, "east")){
					x+=speed;
				}	
			}
			if (x_<x){
				east = false;
				west = true;
				north = false;
				south = false;
				if (room.isX(x, y, "west")){
					x-=speed;
				}
			}
		}
		if (Math.abs(x_-x)<5){

			if (y_>y){
				y+=speed;
				east = false;
				west = false;
				north = false;
				south = true;

			}
			if (y_<y){
				y-=speed;
				east = false;
				west = false;
				north = true;
				south = false;

			}
		
		}	
		}
	}
}







