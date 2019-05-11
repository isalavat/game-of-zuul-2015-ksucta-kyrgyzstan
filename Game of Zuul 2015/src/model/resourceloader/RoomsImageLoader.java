package model.resourceloader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RoomsImageLoader {
	private  BufferedImage room1;
	private  BufferedImage room2;
	private  BufferedImage openroom1;
	private  BufferedImage openroom2;
    public BufferedImage getOpenroom1() {
		return openroom1;
	}

	public void setOpenroom1(String path) {
		try {
			this.openroom1 = ImageIO.read(new File ("res/"+path));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public BufferedImage getOpenroom2() {
		return openroom2;
	}

	public void setOpenroom2(String path) {
		try {
			this.openroom2 = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getRoom2() {
		return room2;
	}

	public void setRoom2(String path) {
		try {
			this.room2 = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static RoomsImageLoader roomsImageLoader = new RoomsImageLoader();
	private RoomsImageLoader(){
    	
    }
	
	public static RoomsImageLoader getRoomsImageLoader(){
		return roomsImageLoader;
	}
	
	public void setRoom1(String path) {
		try {
			this.room1 = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public BufferedImage getRoom1(){
		
		return room1;
	}
}
