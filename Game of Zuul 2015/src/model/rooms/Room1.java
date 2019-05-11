package model.rooms;

import java.awt.image.BufferedImage;
import model.invoker.Bewegung;
import model.resourceloader.RoomsImageLoader;
public class Room1 extends Room {
	
	private BufferedImage image;
    private BufferedImage image2;
    private boolean openDoor = false;
	public boolean isOpenDoor() {
		return openDoor;
	}

	public void setOpenDoor(boolean openDoor) {
		Bewegung.getBewegung().setOpenTheDoor(false);
		this.openDoor = openDoor;
	}

	private int turX = 430;
    private int turY = 100;	
	public Room1(){
		this.image = RoomsImageLoader.getRoomsImageLoader().getRoom1();
		this.image2 = RoomsImageLoader.getRoomsImageLoader().getOpenroom1();
	}
	
	@Override
	public BufferedImage getImage() {
		if (openDoor){
			return image2;
		}
		return image;
	}
	
	@Override
	public boolean isX (int x, int y, String richtung ){
		
		if (((x==26)|(x==28))&(richtung == "west")){
			
			return false;
		}
		if (((x==880)|(x==878))&(richtung == "east")){
			
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean isY(int x, int y, String richtung){
		if (((y==30)|(y==32))&(richtung == "north") ){
			
			return false;
		}
		if (((y==584)|(y==586))&(richtung == "south") ){
			
			return false;
		}
		return true;
	}
	
	@Override
	public boolean isDestroy(int x, int y, int speed, String richtung){
		if (((x+speed)>=945)|((x-speed)<=35)|((y+speed)>=645)|((y-speed<=35))){
			return true;			
		}
		
		return false;
	}

	@Override
	public int getTurX() {
		
		return turX;
	}

	@Override
	public int getTurY() {
		
		return turY;
	}
}
