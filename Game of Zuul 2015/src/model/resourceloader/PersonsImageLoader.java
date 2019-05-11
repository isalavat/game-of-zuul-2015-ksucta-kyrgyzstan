package model.resourceloader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PersonsImageLoader {
	private static PersonsImageLoader personsImageLoader = new PersonsImageLoader();
	private BufferedImage spielerImage;
	private BufferedImage feindDrakonImage;
	private BufferedImage feindMonkeyImage;
	private BufferedImage teufelImage;
	private BufferedImage effeckts;
	private BufferedImage key;
	private BufferedImage herz;
	private BufferedImage zwergImage;
	private BufferedImage schwertImage;
	private BufferedImage soldatImage;
	private BufferedImage gameOver1;
	private BufferedImage gameOver;
	private BufferedImage gameOver0;
	private BufferedImage gameOver2;
	private BufferedImage gameOver3;
	private BufferedImage gameOver4;
	private BufferedImage gameOver5;
	private BufferedImage gameOver6;
	private BufferedImage gameOver7;
	private BufferedImage hexeImage;
	private BufferedImage bigDrakonImage;
	private BufferedImage drakonFire;
	private BufferedImage truheImage;
	private BufferedImage cong1;
	private BufferedImage cong2;
	private BufferedImage cong3;
	private BufferedImage cong4;
	private BufferedImage cong5;
	private BufferedImage smallKkey;

	public BufferedImage getSmallKkey() {
		return smallKkey;
	}

	public void setSmallKkey(String path) {
		try {
			this.smallKkey = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getCong1() {
		return cong1;
	}

	public void setCong1(String path) {
		try {
			this.cong1 = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getCong2() {
		return cong2;
	}

	public void setCong2(String path) {
		try {
			this.cong2 = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getCong3() {
		return cong3;
	}

	public void setCong3(String path) {
		try {
			this.cong3 = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getCong4() {
		return cong4;
	}

	public void setCong4(String path) {
		try {
			this.cong4 = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public BufferedImage getCong5() {
		return cong5;
	}

	public void setCong5(String path) {
		try {
			this.cong5 = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getTruheImage() {
		return truheImage;
	}

	public void setTruheImage(String path) {
		try {
			this.truheImage = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getDrakonFire() {
		return drakonFire;
	}

	public void setDrakonFire(String path) {
		try {
			this.drakonFire = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getBigDrakonImage() {
		return bigDrakonImage;
	}

	public void setBigDrakonImage(String path) {
		try {
			this.bigDrakonImage = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getHexeImage() {
		return hexeImage;
	}

	public void setHexeImage(String path) {
		try {
			this.hexeImage = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getGameOver() {
		return gameOver;
	}

	public void setGameOver(String path) {
		try {
			this.gameOver = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getGameOver0() {
		return gameOver0;
	}

	public void setGameOver0(String path) {
		try {
			this.gameOver0 = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getGameOver1() {
		return gameOver1;
	}

	public void setGameOver1(String path) {
		try {
			this.gameOver1 = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getGameOver2() {
		return gameOver2;
	}

	public void setGameOver2(String path) {
		try {
			this.gameOver2 = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getGameOver3() {
		return gameOver3;
	}

	public void setGameOver3(String path) {
		try {
			this.gameOver3 = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getGameOver4() {
		return gameOver4;
	}

	public void setGameOver4(String path) {
		try {
			this.gameOver4 = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getGameOver5() {
		return gameOver5;
	}

	public void setGameOver5(String path) {
		try {
			this.gameOver5 = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getGameOver6() {
		return gameOver6;
	}

	public void setGameOver6(String path) {
		try {
			this.gameOver6 = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getGameOver7() {
		return gameOver7;
	}

	public void setGameOver7(String path) {
		try {
			this.gameOver7 = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getSoldatImage() {
		return soldatImage;
	}

	public void setSoldatImage(String path) {
		try {
			this.soldatImage = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

	public BufferedImage getSchwertImage() {
		return schwertImage;
	}

	public void setSchwertImage(String path) {
		try {
			this.schwertImage = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public BufferedImage getZwergImage() {
		return zwergImage;
	}

	public void setZwergImage(String path) {
		
		try {
			this.zwergImage = ImageIO.read(new File ("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public BufferedImage getHerz() {
		return herz;
	}

	public void setHerz(String path) {
		try {
			this.herz = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getKey() {
		return key;
	}

	public void setKey(String path) {
		try {
			this.key = ImageIO.read(new File ("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getTeufelImage() {
		return teufelImage;
	}

	public void setTeufelImage(String path) {
		try {
			this.teufelImage = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	
	private PersonsImageLoader(){
		
	}
		
	public void setEffeckts(String path) {
		try {
			this.effeckts = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public BufferedImage getEffeckts() {
		return effeckts;
	}

	public BufferedImage getSpielerImage() {
		return spielerImage;
	}
	public void setSpielerImage(String path) {
		try {
			this.spielerImage = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public BufferedImage getFeindDrakonImage() {
		return feindDrakonImage;
	}
	public void setFeindDrakonImage(String path) {
		try {
			this.feindDrakonImage = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public BufferedImage getFeindMonkeyImage() {
		return feindMonkeyImage;
	}
	public void setFeindMonkeyImage(String path) {
		try {
			this.feindMonkeyImage = ImageIO.read(new File("res/"+path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static PersonsImageLoader getPersonsImageLoader() {
		return personsImageLoader;
	}
}
