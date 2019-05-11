package model.observerpackage;

import model.person.*;
import model.rooms.*;

public class FeindsBulletObserver {
	private static FeindsBulletObserver feindBulletsObserver = new FeindsBulletObserver();
	public static FeindsBulletObserver getFeindBulletsObserver() {
		return feindBulletsObserver;
	}

	Pferd pferd;
	Spieler spieler;
	Teufel teufel;
	FeindMonkey monkey;
	FeindDrakon drakon;
	Soldat soldat;
	Hexe hexe;
	BigDrakon bigDrakon;
	int level = 1;
	Room room ;
	private FeindsBulletObserver(){
		spieler = Spieler.getSpieler();
		teufel = Teufel.getTeufel();
		monkey = FeindMonkey.getFeindMonkey();
		drakon = FeindDrakon.getFeindDrakon();
		pferd = Pferd.getPferd();
		soldat = Soldat.getSoldat();
		hexe = Hexe.getHexe();
		bigDrakon = BigDrakon.getBigDrakon();
	}

	public void setRoom(Room room, int level) {
		this.level = level;
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

	public void destroy (){
		int spielerX = spieler.getCenterX();
		int spielerY = spieler.getCenterY();
		if (level == 1){
			if ((!teufel.isKilled())&(!teufel.getBullets().isEmpty())){
				for (int i = 0; i < teufel.getBullets().size(); i++){
					int x = teufel.getBullets().get(i).getX();
					int y = teufel.getBullets().get(i).getY();
					double distance = Math.sqrt(Math.pow((x-spielerX), 2)+Math.pow((y-spielerY), 2));
					if (distance <=60){
						spieler.plusKillCount();
						if (spieler.getKillCount() == 20){
							spieler.setKilled(true);
						}
						teufel.getBullets().remove(i);
						return;
					}
					if (room.isDestroy(x, y, 40, teufel.getBullets().get(i).getRichtung())){
						teufel.getBullets().remove(i);
						return;
					} 
     			}
			}
			
			if ((!monkey.isKilled())&(!monkey.getBullets().isEmpty())){
				
				for (int i = 0; i < monkey.getBullets().size(); i++){
					int x = monkey.getBullets().get(i).getX();
					int y = monkey.getBullets().get(i).getY();
					double distance = Math.sqrt(Math.pow((x-spielerX), 2)+Math.pow((y-spielerY), 2));
					if (distance <=60){
						spieler.plusKillCount();
						if (spieler.getKillCount() == 20){
							spieler.setKilled(true);
						}
						monkey.getBullets().remove(i);
						return;
					}
					if (room.isDestroy(x, y, 40, monkey.getBullets().get(i).getRichtung())){
						monkey.getBullets().remove(i);
						return;
					} 
					
				}
				
				
			}
			
			
            if ((!hexe.isKilled())&(!hexe.getBullets().isEmpty())){
				
				for (int i = 0; i < hexe.getBullets().size(); i++){
					int x = hexe.getBullets().get(i).getX();
					int y = hexe.getBullets().get(i).getY();
					double distance = Math.sqrt(Math.pow((x-spielerX), 2)+Math.pow((y-spielerY), 2));
					if (distance <=60){
						spieler.plusKillCount();
						if (spieler.getKillCount() == 20){
							spieler.setKilled(true);
						}
						hexe.getBullets().remove(i);
						return;
					}
					if (room.isDestroy(x, y, 40,hexe.getBullets().get(i).getRichtung())){
						
						hexe.getBullets().remove(i);
						
						return;
					} 
					
				}
				
				
			}
			
		}
		
		if (level == 2){
			if ((!drakon.isKilled())&(!drakon.getBullets().isEmpty())){
				for (int i = 0; i < drakon.getBullets().size(); i++ ){
					int x = drakon.getBullets().get(i).getX();
					int y = drakon.getBullets().get(i).getY();
					double distance = Math.sqrt(Math.pow((x-spielerX), 2)+Math.pow((y-spielerY), 2));
					if (distance <=60){
						spieler.plusKillCount();
						if (spieler.getKillCount() == 20){
							spieler.setKilled(true);
						}
						drakon.getBullets().remove(i);
						return;
					}
					if (room.isDestroy(x, y, 40, drakon.getBullets().get(i).getRichtung())){
						drakon.getBullets().remove(i);
						return;
					} 
				}
			}
			
			if ((!pferd.isKilled())&(!pferd.getSchwerts().isEmpty())){
				for (int i = 0; i < pferd.getSchwerts().size(); i++){
					int x = pferd.getSchwerts().get(i).getX();
					int y = pferd.getSchwerts().get(i).getY();
					double distance = Math.sqrt(Math.pow((x-spielerX), 2)+Math.pow((y-spielerY), 2));
					if (distance <= 60){
						spieler.plusKillCount();
						if (spieler.getKillCount() == 20){
							spieler.setKilled(true);
						}
						pferd.getSchwerts().remove(i);
						return;
					}
					if (room.isDestroy(x, y, 40, pferd.getSchwerts().get(i).getRichtung())){
						pferd.getSchwerts().remove(i);
						return;
					}
					
				}
			}
			
			if (!soldat.isKilled()&!soldat.getBullets().isEmpty()){
				for (int i = 0; i < soldat.getBullets().size(); i++){
					int x = soldat.getBullets().get(i).getX();
					int y = soldat.getBullets().get(i).getY();
					double distance = Math.sqrt(Math.pow((x-spielerX), 2)+Math.pow((y-spielerY), 2));
					if (distance <= 40){
						spieler.plusKillCount();
						if (spieler.getKillCount() == 20){
							spieler.setKilled(true);
						}
						soldat.getBullets().remove(i);
						return;
					}
					if (room.isDestroy(x, y, 40, soldat.getBullets().get(i).getRichtung())){
						soldat.getBullets().remove(i);
						return;
					}
					
				}
			}
		}
		
		if (level == 3){
			if (!bigDrakon.isKilled()&!bigDrakon.getBullets().isEmpty()){
				for (int i = 0; i < bigDrakon.getBullets().size(); i++){
					int x = bigDrakon.getBullets().get(i).getCenterX();
					int y = bigDrakon.getBullets().get(i).getCenterY();
					double distance = Math.sqrt(Math.pow((x-spielerX), 2)+Math.pow((y-spielerY), 2));
					if (distance <= 40){
						spieler.plusKillCount();
						if (spieler.getKillCount() == 20){
							spieler.setKilled(true);
						}
						bigDrakon.getBullets().remove(i);
						return;
					}
					if (room.isDestroy(x, y, 40, bigDrakon.getBullets().get(i).getRichtung())){
						bigDrakon.getBullets().remove(i);
						return;
					}
					
				}
			}
		}
	}
}
