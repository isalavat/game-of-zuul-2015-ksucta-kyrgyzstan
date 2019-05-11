package model.observerpackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import model.effekten.Herz;
import model.effekten.Key;
import model.person.BigDrakon;
import model.person.FeindDrakon;
import model.person.FeindMonkey;
import model.person.Hexe;
import model.person.Pferd;
import model.person.Soldat;
import model.person.Spieler;
import model.person.Teufel;
import model.resourceloader.PersonsImageLoader;
import model.rooms.*;

public class BulletsObserver  {
    private Spieler spieler ;
    private BufferStrategy bs; 
    private int width;
    private int height;
    private Teufel teufel;
    private FeindDrakon drakon;
    private Pferd pferd;
    private FeindMonkey monkey;
    private Soldat soldat;
    private BigDrakon bigDrakon;
	private BufferedImage image;
    private Graphics g;
    private Room room; 
    private int level;
    private Key key;
    private Hexe hexe;
    private static BulletsObserver bulletsObserver = new BulletsObserver();
    public static BulletsObserver getBulletsObserver() {
		return bulletsObserver;
	}

	private BulletsObserver (){
		this.spieler = Spieler.getSpieler();
		this.teufel = Teufel.getTeufel();
		this.monkey = FeindMonkey.getFeindMonkey();
		this.drakon = FeindDrakon.getFeindDrakon();
		this.pferd = pferd.getPferd();
		this.soldat = Soldat.getSoldat();
		this.hexe = Hexe.getHexe();
		this.bigDrakon = BigDrakon.getBigDrakon();
		this.image = PersonsImageLoader.getPersonsImageLoader().getEffeckts();
		this.key = Key.getKey();
		
	}
	
	public void setRoom(Room room, int level) {
		if (level == 1){
			this.room = ((Room1)room);
			this.level = level;
		}
		
		if (level == 2){
			this.level = level;
			this.room = ((Room2)room);
		}
		if (level == 3){
			this.level = level;
			this.room = ((Room3)room);
		}
		
	}
	public void metod(){
		
		if (!spieler.getBullets().isEmpty()){
			for (int i = 0; i < spieler.getBullets().size(); i++){
				int x = spieler.getBullets().get(i).getX();
				int y = spieler.getBullets().get(i).getY();
				if (level == 1){
					int teufelX = teufel.getCenterX();
					int teufelY = teufel.getCenterY();
					int monkeyX = monkey.getCenterX();
					int monkeyY = monkey.getCenterY();
					double teufelDistance = Math.sqrt(Math.pow((x-teufelX), 2)+Math.pow((y-teufelY), 2));
					double monkeyDistance = Math.sqrt(Math.pow((x-monkeyX), 2)+Math.pow((y-monkeyY), 2));
					if ((!teufel.isKilled())&(teufelDistance <= 40)){
						teufel.plusKillCount();
						
						if (teufel.getKillCount()==30){
							Herz.getHerz().setVisible(true);
							monkey.setKilled(false);
						}
						g = bs.getDrawGraphics();
						this.width = image.getWidth()/13;
						this.height = image.getHeight()/4;
						destroy(i);
						return;
					}
				
					if ((!monkey.isKilled())&(monkeyDistance <= 50)){
						if (monkey.getKillCount() == 50){
							hexe.setKilled(false);
						}
						monkey.plusKillCount();
						g = bs.getDrawGraphics();
						this.width = image.getWidth()/13;
						this.height = image.getHeight()/4;
						destroy(i);
						return;
					}
					
					
					int hexeX = hexe.getCenterX();
					int hexeY = hexe.getCenterY();
					double hexeDistance = Math.sqrt(Math.pow((x-hexeX), 2)+Math.pow((y-hexeY), 2));
					if ((!hexe.isKilled())&(hexeDistance<=30)){
						if (hexe.getKillCount()== 40){
							key.setVisible(true);
						}
						hexe.plusKillCount();
						g = bs.getDrawGraphics();
						this.height = image.getWidth()/13;
						this.height = image.getHeight()/4;
						destroy(i);
						return;

					}
					
				}
			
				if (level == 2){
					int drakonX = drakon.getCenterX();
					int drakonY = drakon.getCenterY();
					double drakonDistance = Math.sqrt(Math.pow((x-drakonX), 2)+Math.pow((y-drakonY), 2));
					
					if ((!drakon.isKilled())&(drakonDistance<=60)){
						drakon.plusKillCount();
						if (drakon.getKillCount() == 50 ){
							pferd.setKilled(false);
						}
						g = bs.getDrawGraphics();
						this.width = image.getWidth()/13;
						this.height = image.getHeight()/4;
						destroy(i);
						return;
						
					}
					int pferdX = pferd.getCenterX();
					int pferdY = pferd.getCenterY();
					double pferdDistance = Math.sqrt(Math.pow((x-pferdX), 2)+Math.pow((y-pferdY), 2));
					if ((pferdDistance<=60)&(!pferd.isKilled())){
						pferd.plusKillCount();
						if (pferd.getKillCount() == 50){
							soldat.setKilled(false);
						}
						g = bs.getDrawGraphics();
						this.width = image.getWidth()/13;
						this.height = image.getHeight()/4;
						destroy(i);
						return;
					}	
				
					int soldatX = soldat.getCenterX();
					int soldatY = soldat.getCenterY()+15;
					double soldatDistance = Math.sqrt(Math.pow((x-soldatX), 2)+Math.pow((y-soldatY), 2));	
					if ((!soldat.isKilled())&(soldatDistance <=20)){
						
						soldat.plusKillCount();
						if (soldat.getKillCount() == 40){
							key.setVisible(true);
							
						}
						g = bs.getDrawGraphics();
						g.setColor(Color.white);
						g.fillRect(soldatX, soldatY, 5, 5);
						this.width = image.getWidth()/13;
						this.height = image.getHeight()/4;
						destroy(i);
						return;
					}
					
				}
					
				if (level == 3){
					int bigDrakonX = bigDrakon.getCenterX();
					int bigDrakonY = bigDrakon.getCenterY();
					double bigDrakonDistance = Math.sqrt(Math.pow((x-bigDrakonX), 2)+Math.pow((y-bigDrakonY), 2));	
                    if ((!bigDrakon.isKilled())&(bigDrakonDistance <=20)){
				       	bigDrakon.plusKillCount();
						if (bigDrakon.getKillCount()  == 40){
							key.setVisible(true);
						}
						g = bs.getDrawGraphics();
						this.width = image.getWidth()/13;
						this.height = image.getHeight()/4;
						destroy(i);
						return;
					}
				}
				
				if (room.isDestroy(spieler.getBullets().get(i).getX()-5, spieler.getBullets().get(i).getY(), spieler.getBullets().get(i).getSpeed(), spieler.getBullets().get(i).getRichtung())){
					g = bs.getDrawGraphics();
					this.width = image.getWidth()/13;
					this.height = image.getHeight()/4;
					destroy(i);
					return;
				}
			}
		}
		
	}
	
	public void destroy(int i){
		
		for (int j = width * 9; j >= 0; j-=width ){
			g.drawImage(image.getSubimage(j, 0, width, height), spieler.getBullets().get(i).getX(),spieler.getBullets().get(i).getY()-10 ,null);
		}
		spieler.getBullets().remove(i);
		return;
	}
	
	public void setBs(BufferStrategy bs) {
		this.bs = bs;
	}

}
