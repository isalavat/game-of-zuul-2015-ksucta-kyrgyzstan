package model.sprite;

import java.awt.image.BufferedImage;
public class SpriteSchneider {
	private String richtung = "south";
	private  int count = 0;
	public void setCount(int count) {
		this.count = count;
	}

	private BufferedImage personSprite;
	private BufferedImage defaultSprite;
	private BufferedImage defaultSprite2;
	public int getCount() {
		return count;
	}

	private int countSpriteInWidth ;
	private int eastSprite ;
	private int westSprite ;
	private int northSprite ;
	private int southSprite;
	int spirteWidth ;
	int spirteHeight;
	int aufenhalt = 0;
	private int zahl = 1;
	public void setZahl(int zahl) {
		this.zahl = zahl;
	}

	public SpriteSchneider(BufferedImage image , int eastSprite, int westSprite, int northSprite, int southSprite, int countSpriteInWidth){
		
		this.eastSprite = eastSprite;
		this.westSprite = westSprite;
		this.southSprite = southSprite;
		this.northSprite = northSprite;
		this.countSpriteInWidth = countSpriteInWidth;
		this.personSprite = image;
		spirteWidth = personSprite.getWidth() / countSpriteInWidth;
		spirteHeight = personSprite.getHeight() / 4;
		defaultSprite = personSprite.getSubimage(0, 0,  spirteWidth, spirteHeight);
	}
	
	public int getSpirteWidth() {
		return spirteWidth;
	}

	public int getSpirteHeight() {
		return spirteHeight;
	}

	private int aufenhalsGrenze = 3;
	public void setAufenhalsGrenze(int aufenhalsGrenze) {
		this.aufenhalsGrenze = aufenhalsGrenze;
	}
	
	public BufferedImage getSchniedeneSprite(boolean east, boolean west, boolean north, boolean south) {
		if (east){
			richtung = "east";
			aufenhalt++;
			if (count == countSpriteInWidth-zahl ){
				count = 0;
			}
			defaultSprite = personSprite.getSubimage(count*spirteWidth, eastSprite*spirteHeight,  spirteWidth, spirteHeight);
			
			if (aufenhalt == aufenhalsGrenze){
			count++;
			aufenhalt = 0;
			}
			east = false;
			return personSprite.getSubimage(count*spirteWidth, eastSprite*spirteHeight, spirteWidth, spirteHeight );
		}
		
		if (west){
			richtung = "west";
			aufenhalt++;
			if (count == countSpriteInWidth-zahl ){
				count = 0;
			}
			defaultSprite = personSprite.getSubimage(count*spirteWidth, westSprite*spirteHeight,  spirteWidth, spirteHeight);
			
			if (aufenhalt == aufenhalsGrenze){
			count++;
			aufenhalt = 0;
			}
			west = false;
			return personSprite.getSubimage(count*spirteWidth, westSprite*spirteHeight,  spirteWidth, spirteHeight);
		}
		
		if (north){
			richtung = "north";
			aufenhalt++;
			if (count == countSpriteInWidth - zahl ){
				count = 0;
			}
			defaultSprite = personSprite.getSubimage(count*spirteWidth, northSprite*spirteHeight,  spirteWidth, spirteHeight);
			if (aufenhalt == aufenhalsGrenze){
			count++;
			aufenhalt = 0;
			}
			north = false;
			return personSprite.getSubimage(count*spirteWidth, northSprite*spirteHeight,  spirteWidth, spirteHeight);
		}
		
		if (south){
			richtung = "south";
			aufenhalt++;
			if (count == countSpriteInWidth-zahl ){
				count = 0;
			}
			defaultSprite = personSprite.getSubimage(count*spirteWidth, southSprite*spirteHeight,  spirteWidth, spirteHeight);
			if (aufenhalt == aufenhalsGrenze){
			count++;
			aufenhalt = 0;
			}
			south = false;
			return personSprite.getSubimage(count*spirteWidth, southSprite*spirteHeight,  spirteWidth, spirteHeight);
			
		}
		if (count == 7){
			if (richtung == "east"){
				defaultSprite2 = personSprite.getSubimage(count*spirteWidth, eastSprite*spirteHeight, spirteWidth, spirteHeight);
			}
			if (richtung == "west"){
				defaultSprite2 = personSprite.getSubimage(count*spirteWidth, westSprite*spirteHeight, spirteWidth, spirteHeight);
			}
			if (richtung == "north"){
				defaultSprite2 = personSprite.getSubimage(count*spirteWidth, northSprite*spirteHeight, spirteWidth, spirteHeight);
			}
			if (richtung == "south"){
				defaultSprite2 = personSprite.getSubimage(count*spirteWidth, southSprite*spirteHeight, spirteWidth, spirteHeight);
			}
			return defaultSprite2;
		}
		return defaultSprite;//argen dastan salavat  GAME Z-1 2016 ig-14
	}
}
