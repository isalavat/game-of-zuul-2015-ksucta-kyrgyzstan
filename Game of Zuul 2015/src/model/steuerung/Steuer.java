package model.steuerung;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import model.person.*;
import model.effekten.*;
import model.invoker.Bewegung;
import model.rooms.*;
import model.observerpackage.*;
import model.resourceloader.PersonsImageLoader;
import model.resourceloader.RoomsImageLoader;
import controller.cmd.KeyHandler;
import model.kuenstlicheintelligenz.Intellekt;

public  class Steuer {
	    private static Steuer steuer = new Steuer();
	    public static Steuer getSteuer() {
			return steuer;
		}
	    private int timer = 0;
                boolean a = false;
                boolean b = false;
                boolean c = false; 
                private int k = 0;
                private int j = 0;
                int x = 0;
	            int count = 0;
	            int speedGame = 30;
	            boolean init = false;
	            int p = 0;
	            int m = 0;
	    public 	static Canvas canvas;
	    public 	static BufferStrategy bs;
	    private BufferedImage      gameOver;
	    private BufferedImage      gameOver0;
	    private BufferedImage      gameOver1;
		private BufferedImage      gameOver2;
		private BufferedImage      gameOver3;
		private BufferedImage      gameOver4;
		private BufferedImage      gameOver5;
		private BufferedImage      gameOver6;
		private BufferedImage      gameOver7;
		private BufferedImage []   gameOvers; 
		private BufferedImage      cong1;
		private BufferedImage      cong2;
		private BufferedImage      cong3;
		private BufferedImage      cong4;
		private BufferedImage      cong5;
		private BufferedImage      smallKey;
		private BufferedImage []   congratulation;
				RoomsImageLoader   roomsImageLoader;
				PersonsImageLoader personsImageLoader;
				Teufel             teufel;
				Spieler            spieler;
				BulletsObserver    bulletsObserver;
				FeindMonkey        monkey;
				Pferd              pferd;
				int                keyWidth;
				int                keyHeight;
				Bewegung           bewegung;
				KeyHandler         keyHandler;
				Herz               herz;
				Key                key;
				TruheObserver      truheObserver;
				Truhe              truhe;
				HerzObserver       herzObserver;
				KeyObserver        keyObserver;
			 FeindsBulletObserver  feindsBulletObserver;
				FeindDrakon        drakon;
				Soldat             soldat;
				Hexe               hexe;
				BigDrakon          bigDrakon;
				Intellekt          intellekt;
				Room1              room1;
				Room2              room2;
				Room3              room3;
		private int                level = 1;
		
		public  int getLevel(){
			return level;
		}
		
		public void setLevel(int level) {
			this.level = level;
		}

		private Steuer(){
			roomsImageLoader = RoomsImageLoader.getRoomsImageLoader(); 
			roomsImageLoader.setRoom1("room1.png");
			roomsImageLoader.setRoom2("room2.png");
			roomsImageLoader.setOpenroom1("openroom1.png");
			roomsImageLoader.setOpenroom2("openroom2.png");
			room1 = new Room1();
			room2 = new Room2();
			room3 = new Room3();
			personsImageLoader = PersonsImageLoader.getPersonsImageLoader();
			
			personsImageLoader.setKey("key.png");
			personsImageLoader.setTeufelImage("teufel.png");
			personsImageLoader.setSpielerImage("player.png");
			personsImageLoader.setFeindDrakonImage("monster16.png");
			personsImageLoader.setFeindMonkeyImage("monster2.png");
			personsImageLoader.setEffeckts("FireSt2.png");
			personsImageLoader.setHerz("HERZ2.png");
			personsImageLoader.setTruheImage("truhe.jpg");
			personsImageLoader.setSoldatImage("soldat.png");
			personsImageLoader.setSchwertImage("schwert.png");
			personsImageLoader.setHexeImage("Monster8.png");
			personsImageLoader.setBigDrakonImage("drakon3.png");
			personsImageLoader.setZwergImage("pferd.png");
			personsImageLoader.setGameOver("go1.png");
			personsImageLoader.setGameOver0("go.png");
			personsImageLoader.setGameOver1("go0.png");
			personsImageLoader.setGameOver2("go2.png");
			personsImageLoader.setGameOver3("go3.png");
			personsImageLoader.setGameOver4("go4.png");
			personsImageLoader.setGameOver5("go5.png");
			personsImageLoader.setGameOver6("go6.png");
			personsImageLoader.setGameOver7("go7.png");
			personsImageLoader.setCong1("cong1.png");
			personsImageLoader.setCong2("cong2.png");
			personsImageLoader.setCong3("cong3.png");
			personsImageLoader.setCong4("cong4.png");
			personsImageLoader.setCong5("cong5.png");
			personsImageLoader.setDrakonFire("drakonFire.png");
			personsImageLoader.setSmallKkey("smallKey.png");
			this.gameOver        = personsImageLoader.getGameOver1();
			this.gameOver0       = personsImageLoader.getGameOver();
			this.gameOver1       = personsImageLoader.getGameOver0();
			this.gameOver2       = personsImageLoader.getGameOver2();
			this.gameOver3 	     = personsImageLoader.getGameOver3();
			this.gameOver4 		 = personsImageLoader.getGameOver4();
			this.gameOver5       = personsImageLoader.getGameOver5();
			this.gameOver6       = personsImageLoader.getGameOver6();
			this.gameOver7       = personsImageLoader.getGameOver7();
			gameOvers            = new BufferedImage[]{gameOver,gameOver0,gameOver1,gameOver2,gameOver3,gameOver4,gameOver5,gameOver6,gameOver7};
			this.cong1           = personsImageLoader.getCong1();
			this.cong2           = personsImageLoader.getCong2();
			this.cong3           = personsImageLoader.getCong3();
			this.cong4           = personsImageLoader.getCong4();
			this.cong5           = personsImageLoader.getCong5();
			this.smallKey        = personsImageLoader.getSmallKkey();
			congratulation       = new BufferedImage[]{cong1, cong2, cong3, cong4, cong5};
			spieler              = Spieler.getSpieler();
			spieler.setRoom(room1, 1);
			bulletsObserver      = BulletsObserver.getBulletsObserver();
			bulletsObserver.setRoom(room1, 1);
			feindsBulletObserver = FeindsBulletObserver.getFeindBulletsObserver();
		   	feindsBulletObserver.setRoom(room1, 1);
			drakon               = FeindDrakon.getFeindDrakon();
			teufel               = Teufel.getTeufel();
			monkey               = FeindMonkey.getFeindMonkey();
			pferd                = pferd.getPferd();
			soldat               = Soldat.getSoldat();
			hexe                 = Hexe.getHexe();
			bigDrakon            = BigDrakon.getBigDrakon();
			bewegung             = Bewegung.getBewegung();
			keyHandler           = KeyHandler.getKeyHandler();
		    herz                 = Herz.getHerz();
		    key                  = Key.getKey();
		    truhe                = Truhe.getTruhe();
		    keyObserver          = KeyObserver.getKeyObserver();
			herzObserver         = HerzObserver.getHerzObserver();
			truheObserver        = TruheObserver.getTruheObserver();
		}

		public void init(Canvas canvas, BufferStrategy bs){
			this.canvas = canvas;
			this.bs     = bs;
		}
			
		public void draw( ){
			bs = canvas.getBufferStrategy();
			if (bs == null){
				canvas.createBufferStrategy(2);
				canvas.requestFocus();
				return;
			}
			bulletsObserver.setBs(bs);
			spieler.setBs(bs);
			teufel.setBs(bs);
			monkey.setBs(bs);
			drakon.setBs(bs);
			soldat.setBs(bs);
			hexe.setBs(bs);
			bigDrakon.setBs(bs);
			Graphics g = bs.getDrawGraphics();
			
			if (level == 1){
				g.drawImage(room1.getImage(), 0, 0, null);
				g.setColor(Color.black);
				g.fillRect(50, 0, 100, 30);
				g.fillRect(160, 0, 120, 30);
				if (!teufel.isKilled()){
					g.drawImage(teufel.getFeindSprite(), teufel.getX(), teufel.getY(), null);
					g.setColor(Color.GREEN);
					g.drawString("TEUFEL", 60, 27);
					g.setColor(Color.GREEN);
					g.fillRect(60, 5, 30, 10);
					g.setColor(Color.RED);
					g.fillRect(60, 5, teufel.getKillCount(), 9);
		
					if (!teufel.getBullets().isEmpty()){
						for (int i = 0; i < teufel.getBullets().size(); i++){
							teufel.getBullets().get(i).draw();
						}
					}
					
					feindsBulletObserver.destroy();
				}
							
				if ((teufel.isKilled())&(!monkey.isKilled())){
					g.setColor(Color.black);
					g.fillRect(50, 0, 100, 30);
					g.fillRect(160, 0, 100, 30);
					g.drawImage(monkey.getFeindSprite(),monkey.getX(),monkey.getY(), null);
					g.setColor(Color.GREEN);
					g.drawString("MONKEY", 60, 27);
					g.setColor(Color.GREEN);
					g.fillRect(60, 5, 50, 10);
					g.setColor(Color.RED);
					g.fillRect(60, 5, monkey.getKillCount(), 9);
					if (!monkey.getBullets().isEmpty()){
						for (int i = 0; i < monkey.getBullets().size(); i++){
							monkey.getBullets().get(i).draw();
						}
					}
					 feindsBulletObserver.destroy();
				}
				
				if (!hexe.isKilled()){
					g.setColor(Color.black);
					g.fillRect(50, 0, 100, 30);
					g.fillRect(160, 0, 100, 30);
					g.drawImage(hexe.getFeindSprite(),hexe.getX(),hexe.getY(), null);
					g.setColor(Color.GREEN);
					g.drawString("HEXE", 60, 27);
					g.setColor(Color.GREEN);
					g.fillRect(60, 5, 40, 10);
					g.setColor(Color.RED);
					g.fillRect(60, 5, hexe.getKillCount(), 9);
					if (!hexe.getBullets().isEmpty()){
						for (int i = 0; i < hexe.getBullets().size(); i++){
							hexe.getBullets().get(i).draw();
						}
					}
					 feindsBulletObserver.destroy();
				}
				
				if ((teufel.isKilled())&(monkey.isKilled())&(hexe.isKilled())&(!spieler.isGibtEsKey())){
					String text ="Verwenden Sie die Command 'nimm key' oder kommen Sie zu Schlüss heran";
					g.setColor(Color.WHITE);
					g.drawString(text, 300, 200);
				}
				
				if ((teufel.isKilled())&(monkey.isKilled())&(hexe.isKilled())&spieler.isGibtEsKey()){
					String text ="Verwenden Sie die Command 'open the door' oder kommen Sie zur Tür heran";
					g.setColor(Color.WHITE);
					g.drawString(text, 300, 200);
				}
				if (room1.isOpenDoor()){
					timer ++;
				}
			    if (timer == 30){
			    	level = 2;
			    	spieler.setRoom(room2, 2);
			    	bulletsObserver.setRoom(room2, 2);
			    	feindsBulletObserver.setRoom(room2, 2);
			    	spieler.setX(500);
			    	spieler.setY(500);
			    	drakon.setKilled(false);
					c = true;
			    	timer = 0;
			    }
				
			}
			if (level == 2){
				if (!c){
					spieler.setRoom(room2, 2);
			    	bulletsObserver.setRoom(room2, 2);
			    	feindsBulletObserver.setRoom(room2, 2);
			    	spieler.setX(500);
			    	spieler.setY(500);
			    	drakon.setKilled(false);
			    	c = true;
				}
				
				g.drawImage(room2.getImage(), 0, 0, null);
				g.setColor(Color.black);
				g.fillRect(50, 0, 100, 30);
				g.fillRect(160, 0, 120, 30);
						
				if (!drakon.isKilled()){
					g.setColor(Color.GREEN);
					g.drawString("DRAKON", 60, 27);
					g.setColor(Color.GREEN);
					g.fillRect(60, 5, 50, 10);
					g.setColor(Color.RED);
					g.fillRect(60, 5, drakon.getKillCount(), 9);
					g.drawImage(drakon.getFeindSprite(), drakon.getX(), drakon.getY(), null);
					if (!drakon.getBullets().isEmpty()){
						for (int i = 0; i < drakon.getBullets().size(); i++){
							drakon.getBullets().get(i).draw();
						}
						feindsBulletObserver.destroy();
					}
				}
				
				if ((drakon.isKilled())&(!pferd.isKilled())){
					pferd.setBs(bs);
					g.setColor(Color.GREEN);
					g.drawString("PFERD", 60, 27);
					g.setColor(Color.GREEN);
					g.fillRect(60, 5, 50, 10);
					g.setColor(Color.RED);
					g.fillRect(60, 5, pferd.getKillCount(), 9);
				    g.drawImage(pferd.getFeindSprite(),pferd.getX(),pferd.getY(), null);
				    if (!pferd.getSchwerts().isEmpty()){
						for (int i = 0; i < pferd.getSchwerts().size(); i++){
							pferd.getSchwerts().get(i).draw();
						}
						 feindsBulletObserver.destroy();
					}
				}

				if ((drakon.isKilled())&(pferd.isKilled())&(!soldat.isKilled())){
					g.setColor(Color.GREEN);
					g.drawString("SOLDAT", 60, 27);
					g.setColor(Color.GREEN);
					g.fillRect(60, 5, 40, 10);
					g.setColor(Color.RED);
					g.fillRect(60, 5, soldat.getKillCount(), 9);
					g.drawImage(soldat.getFeindSprite(), soldat.getX(), soldat.getY(), null);
					if (!soldat.getBullets().isEmpty()){
						for (int i = 0; i < soldat.getBullets().size(); i++){
							soldat.getBullets().get(i).draw();
						}
						feindsBulletObserver.destroy();
					}
				}
				
				if (drakon.isKilled()&pferd.isKilled()&soldat.isKilled()&!spieler.isGibtEsKey()){
					String text ="Verwenden Sie die Command 'nimm key' oder kommen Sie zu Schlüss heran";
					g.setColor(Color.WHITE);
					g.drawString(text, 300, 200);
				}
				if (drakon.isKilled()&pferd.isKilled()&soldat.isKilled()&spieler.isGibtEsKey()){
					String text ="Verwenden Sie die Command 'open the door' oder kommen Sie zur Tür heran";
					g.setColor(Color.WHITE);
					g.drawString(text, 300, 200);
				}
				if (room2.isOpenDoor()){
					timer ++;
				}
			    if (timer == 30){
			    	level = 3;
			    	spieler.setRoom(room3, 3);
			    	bulletsObserver.setRoom(room3, 3);
			    	feindsBulletObserver.setRoom(room3, 3);
			    	spieler.setX(400);
			    	spieler.setY(550);
			    	bigDrakon.setKilled(false);
					b = true;
			    	timer = 0;
			    }
			}
		
			if (level == 3){
				if (!b){
					spieler.setRoom(room3, 3);
			    	bulletsObserver.setRoom(room3, 3);
			    	feindsBulletObserver.setRoom(room3, 3);
			    	spieler.setX(400);
			    	spieler.setY(580);
			    	bigDrakon.setKilled(false);
			    	b = true;
				}
				
				g.drawImage(room3.getImage(),0, 0, null);
				g.setColor(Color.black);
				g.fillRect(50, 0, 100, 30);
				g.fillRect(160, 0, 120, 30);
				if (!bigDrakon.isKilled()){
					g.setColor(Color.GREEN);
					g.drawString("Drakon", 60, 27);
					g.setColor(Color.GREEN);
					g.fillRect(60, 5, 40, 10);
					g.setColor(Color.RED);
					g.fillRect(60, 5, bigDrakon.getKillCount(), 9);
					g.drawImage(bigDrakon.getFeindSprite(), bigDrakon.getX(), bigDrakon.getY(), null);
					if (!bigDrakon.getBullets().isEmpty()){
						for (int i = 0; i < bigDrakon.getBullets().size(); i++){
							bigDrakon.getBullets().get(i).draw();
						}
						feindsBulletObserver.destroy();
					}
				}
				
				if (bigDrakon.isKilled()&!spieler.isGibtEsKey()&!truhe.isOffen()){
					String text ="Verwenden Sie die Command 'nimm key' oder kommen Sie zu Schlüss heran";
					g.setColor(Color.WHITE);
					g.drawString(text, 300, 200);
				}
				
				if (bigDrakon.isKilled()&spieler.isGibtEsKey()){
					String text ="Kommen Sie zur Truhe heran";
					g.setColor(Color.WHITE);
					g.drawString(text, 300, 200);
				}
				
				
				if ((truhe.isVisible())){
					g.drawImage(truhe.getTruheImage(), truhe.getX(), truhe.getY(), null);
					truheObserver.method();
				}
			}
			
			if (spieler.isGibtEsKey()){
				g.drawImage(smallKey,230, 0, null);
				g.setColor(Color.blue);
				if (level == 3){
					g.drawOval(770, 190, 80, 40);
				}
				if (level != 3){
					g.setColor(Color.yellow);
					g.drawRect(350, 50, 200, 70);
				}
			}	
				
			if (!spieler.isKilled()){
				g.drawImage(spieler.getSpielerSprite(),spieler.getX(), spieler.getY(), null);
				g.setColor(Color.WHITE);
				g.drawString("X "+Integer.toString(spieler.getX())+" Y ="+Integer.toString(spieler.getY()), 100, 100);
				g.setColor(Color.GREEN);
				g.drawString("Spieler", 170, 27);
				g.setColor(Color.GREEN);
				g.fillRect(170, 5, 40, 10);
				g.setColor(Color.RED);
				g.fillRect(170, 5, spieler.getKillCount()*2, 9);
				if (!spieler.getBullets().isEmpty()){
					for (int i = 0; i < spieler.getBullets().size(); i++){
						spieler.getBullets().get(i).draw();
					}
					bulletsObserver.metod();
				}
			}
			
			if (spieler.getKillCount() == 14){
				herz.setX(400);
				herz.setY(200);
				herz.setVisible(true);
			}
			
			if (herz.isVisible()){
				g.drawImage(herz.getHerzSprite(), herz.getX(), herz.getY(), null);
				herzObserver.method();
			}
			
			if (key.isVisible()){
				keyObserver.method();
				g.drawImage(key.getKeySprite(), key.getX(), key.getY(), null);
			}
			
			
			
			if (spieler.isGibtEsTruhe()){
				k++;
				if (k == 5){
					j++;
					k = 0;
				}
				if (j == 5){
					j = 0;
				}
				g.drawImage(congratulation[j], 100, 100, null);
		
			}
			
			if (spieler.isKilled()){
				g.drawImage(gameOvers[j], 300, 250 , null);
				if (j == 8){
					j = 0;
				}
				k++;
				if (k == 5){
					j++;
					k =0;
				}
			}
			
			g.dispose();
			bs.show();
		}
}
