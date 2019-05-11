package controller.cmd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;

import model.invoker.Bewegung;
import mainclass.main.Main;

public class KeyHandler extends Observable {
	private boolean east = false;
	private boolean pressed = false;
	private boolean pressedStrike = false;
	private boolean west = false;
	private boolean south = false;
	private boolean north = false;
	private boolean strike = false;
	private boolean schnellGehenOn = false;
	private boolean nimmKey = false;
	private boolean openTheDoor = false;
	
	public boolean isNimmKey() {
		return nimmKey;
	}
	
	public void setNimmKey(boolean nimmKey) {
		this.nimmKey = nimmKey;
	}
	
	public boolean isOpenTheDoor() {
		return openTheDoor;
	}
	
	public void setOpenTheDoor(boolean openTheDoor) {
		this.openTheDoor = openTheDoor;
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
	
	public boolean isStrike() {
		return strike;
	}
	
	public void setStrike(boolean strike) {
		this.strike = strike;
	}
	
	public boolean isSchnellGehenOn() {
		return schnellGehenOn;
	}
	
	public void setSchnellGehenOn(boolean schnellGehenOn) {
		this.schnellGehenOn = schnellGehenOn;
	}
	
	public void setWest(boolean west) {
		this.west = west;
	}
	
	public boolean isSouth() {
		return south;
	}
	
	public void setSouth(boolean south) {
		this.south = south;
	}
	
	public boolean isNorth() {
		return north;
	}
	
	public void setNorth(boolean north) {
		this.north = north;
	}
	
	public KeyAdapter getKeyAdapter() {
		return keyAdapter;
	}

	Bewegung b;
	private static KeyHandler keyHandler = new KeyHandler();
	public static KeyHandler getKeyHandler(){
		return keyHandler;
	}
	
	private KeyHandler (){
		this.b = Bewegung.getBewegung();
		this.addObserver(b);
	}
	
	private ActionListener actionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			 if (e.getSource() == Main.game.execute){
				 if (Main.game.text.getText().equals("nimm key")){
					keyHandler.nimmKey = true; 	
					keyHandler.update();
					keyHandler.nimmKey = false;
					Main.game.text.setText(null);
					Main.game.lastCommand.setText("nimm key");
				 }
				 if (Main.game.text.getText().equals("open the door") ){
					keyHandler.openTheDoor = true;
					Main.game.text.setText(null);
					Main.game.lastCommand.setText("open the door");
					keyHandler.update();
					keyHandler.openTheDoor = false;
				 }
			 }
		}
	};
	
	public ActionListener getActionListener() {
		return actionListener;
	}

	private KeyAdapter keyAdapter = new KeyAdapter(){
		public void keyPressed(KeyEvent e){
			if (e.getKeyCode() == KeyEvent.VK_DOWN){
				keyHandler.setSouth(true);
				keyHandler.setWest(false);
				keyHandler.setNorth(false);
				keyHandler.setEast(false);
				if (!keyHandler.pressed){
					keyHandler.update();
				}
				keyHandler.pressed = true;
			}
			
			if (e.getKeyCode() == KeyEvent.VK_UP){
				keyHandler.setNorth(true);
				keyHandler.setSouth(false);
				keyHandler.setWest(false);
				keyHandler.setEast(false);
				
				if (!keyHandler.pressed){
					keyHandler.update();
				}
				keyHandler.pressed = true;
			}
			
			if (e.getKeyCode() == KeyEvent.VK_LEFT){
				keyHandler.setEast(false);
				keyHandler.setSouth(false);
				keyHandler.setNorth(false);
				keyHandler.setWest(true);
				if (!keyHandler.pressed){
					keyHandler.update();
				}
				keyHandler.pressed = true;
			}
			
			if (e.getKeyCode() == KeyEvent.VK_RIGHT){
				keyHandler.setWest(false);
				keyHandler.setSouth(false);
				keyHandler.setNorth(false);
				keyHandler.setEast(true);
				if (!keyHandler.pressed){
					keyHandler.update();
				}
				keyHandler.pressed = true;
			}
			
			if (e.getKeyCode() == KeyEvent.VK_SHIFT){
				keyHandler.setSchnellGehenOn(true);
				keyHandler.update();
			}
			
			if (e.getKeyCode() == KeyEvent.VK_CAPS_LOCK){
				keyHandler.setSchnellGehenOn(false);
				keyHandler.update();
			}
			
			if (e.getKeyCode() == KeyEvent.VK_CONTROL){
				
				keyHandler.setStrike(true);
				if (!keyHandler.pressedStrike){
					keyHandler.update();
				}
				keyHandler.pressedStrike = true;
			}
		}
		
		public void keyReleased(KeyEvent e){
			
			if (e.getKeyCode() == KeyEvent.VK_LEFT){
				keyHandler.setWest(false);
				keyHandler.update();
				keyHandler.pressed = false;
			}
			
			if (e.getKeyCode() == KeyEvent.VK_RIGHT){
				keyHandler.setEast(false);
				keyHandler.update();
				keyHandler.pressed = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN){
				keyHandler.setSouth(false);
				keyHandler.update();
				keyHandler.pressed = false;
			}
			
			if (e.getKeyCode() == KeyEvent.VK_UP){
				keyHandler.setNorth(false);
				keyHandler.update();
				keyHandler.pressed = false;
			}
			
			if (e.getKeyCode() == KeyEvent.VK_CONTROL){
				keyHandler.setStrike(false);
				keyHandler.update();
				keyHandler.pressedStrike = false;
			}
		}
	};
	
	public void update(){
		super.notifyObservers();
		super.setChanged();
	}
}//argen dastan salavat  GAME Z-1 2016 ig-14