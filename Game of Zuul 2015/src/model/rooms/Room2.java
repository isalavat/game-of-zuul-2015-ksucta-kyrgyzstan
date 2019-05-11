package model.rooms;

import java.awt.image.BufferedImage;
import model.resourceloader.RoomsImageLoader;

public class Room2 extends Room {
    private BufferedImage image;
    private BufferedImage image2;
    private boolean openDoor = false;
    private int turX = 430;
    private int turY = 100;
    public Room2(){
    	this.image = RoomsImageLoader.getRoomsImageLoader().getRoom2();
    	this.image2 = RoomsImageLoader.getRoomsImageLoader().getOpenroom2();
    }
	@Override
	public boolean isX(int x,int y, String richtung) {
		if (((x==26)|(x==28))&(richtung == "west")){
			return false;
		}
		if (((x==880)|(x==878))&(richtung == "east")){
			return false;
		}
		
		if (((x==230)|(x==228))&(y>=240)&(y<=380)&(richtung == "east")){
			return false;
		}
		
		if (((x==628)|(x==630))&(y>=240)&(y<=380)&(richtung == "west")){
			return false;
		}
		return true;
	}

	@Override
	public boolean isY(int x, int y, String richtung) {
        if (((y==30)|(y==32))&(richtung == "north") ){
			return false;
		}
    	if (((y==584)|(y==586))&(richtung == "south") ){
			return false;
		}
		
		if (((y == 238)|(y == 236))&(x>=231)&(x<=628)&(richtung == "south")){
			return false;
		}
		if (((y == 380)|(y == 382))&(x>=230)&(x<=628)&(richtung == "north")){
			return false;
		}
		return true;
	}

	@Override
	public boolean isDestroy(int x, int y, int speed,String richtung) {
		if (((x+speed)>=925)|((x-speed)<=30)|((y+speed)>=650)|((y-speed<=50))){
			return true;			
		}
		if(((x+speed>=260)&(x+speed<638))&(y>=302)&(y<=390)&(richtung == "east")){
			return true;
		}
		
        if(((x-speed<=638)&(x-speed>260))&(y>=300)&(y<=380)&(richtung == "west")){
			return true;
		}
		
        if ((y+speed >= 300)&(y+speed<360)&(x >= 276)&(x <= 644 )&(richtung == "south")){
        	return true;
        }
        
        if ((y-speed <= 380)&(y+speed>300)&(x >= 276)&(x <= 654 )&(richtung == "north")){
        	return true;
        }
        return false;
	}

	@Override
	public BufferedImage getImage() {
		if (openDoor){
			return image2;
		}
		return image;
	}
	@Override
	public int getTurX() {
		return turX;
	}
	@Override
	public int getTurY() {
		return turY;
	}
	@Override
	public void setOpenDoor(boolean openDoor) {
		this.openDoor = openDoor;
		
	}
	@Override
	public boolean isOpenDoor() {
		return openDoor;
	}
}
