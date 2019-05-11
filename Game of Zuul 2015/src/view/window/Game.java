package view.window;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.invoker.Bewegung;
import model.observerpackage.BulletsObserver;
import model.person.FeindDrakon;
import model.person.FeindMonkey;
import model.person.Spieler;
import model.resourceloader.PersonsImageLoader;
import model.resourceloader.RoomsImageLoader;
import model.rooms.Room1;
import model.rooms.Room2;
import model.steuerung.Steuer;
import controller.cmd.KeyHandler;

public class Game  implements Runnable {
    int speedGame = 30;
  	Canvas    canvas;
    public JTextField text;
    private static Game game = new Game ();
	Dimension size;
	JFrame    frame;
	Thread    thread;
	Bewegung bewegung;
	KeyHandler keyHandler;
	JLabel commands;
	JLabel nimmKey;
	JLabel openDoor;
	boolean running;
	public JLabel lastCommand;
 	JLabel lastCmd;
 	JLabel strike;
 	JLabel gehen;
 	JLabel laufen;
	JList list;
	public  JButton execute;
   	BufferStrategy bs;
	private int level = 1;
	Steuer steuer;
	public void setLevel(int level) {
		this.level = level;
	}

	public static Game getGame() {
		return game;
	}

	private Game (){
		text = new JTextField();
		commands = new JLabel("Commands:");
		nimmKey  = new JLabel("nimm key");
		openDoor = new JLabel ("open the door");
		execute = new JButton("Execute");
		lastCommand = new JLabel("null");
		strike      = new JLabel("CTRL: strike");
		gehen       = new JLabel("CAPS LOCK: gehen");
		laufen      = new JLabel ("SHIFT: laufen");
		lastCmd = new JLabel("Last command:");
		text.setBounds(1020, 84, 155, 25);
		commands.setBounds(1020, 10, 100, 20);
		nimmKey.setBounds(1040, 35,100, 20);
		openDoor.setBounds(1040, 56,100, 20);
		lastCommand.setBounds(1040, 175, 100, 20);
		lastCmd.setBounds(1020, 150, 100, 20);
		execute.setBounds(1045, 120, 100, 20);
		strike.setBounds(1020, 300, 100, 20);
		laufen.setBounds(1020, 320, 100, 20);
		gehen.setBounds(1020, 340, 150, 20);
		steuer = Steuer.getSteuer();
		bewegung = Bewegung.getBewegung();
		keyHandler = KeyHandler.getKeyHandler();
		execute.addActionListener(keyHandler.getActionListener());
		size   = new Dimension(1200, 750);
	    frame  = new JFrame ("Game of zuul 2016");
		frame.setLayout(null);
		frame.setResizable(false);
		thread = new Thread (this);
		canvas = new Canvas();
		frame.setSize(size);
		canvas.setPreferredSize(size);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(canvas);
		canvas.setBounds(0, 0, 1000, 750);
		frame.getContentPane().add(text);
		frame.getContentPane().add(execute);
		canvas.addKeyListener(keyHandler.getKeyAdapter());
		frame.getContentPane().add(commands);
		frame.getContentPane().add(nimmKey);
		frame.getContentPane().add(openDoor);
        frame.getContentPane().add(lastCommand);
		frame.getContentPane().add(lastCmd);
		frame.getContentPane().add(strike);
	    frame.getContentPane().add(laufen);
	    frame.getContentPane().add(gehen);
        steuer.init(canvas, bs);
        running = true;
		thread.start();
	}
	
	public void run() {
		while (running){
			try {
				thread.sleep(speedGame);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			steuer.draw();
			bewegung.gehen();
		}
	}
}
