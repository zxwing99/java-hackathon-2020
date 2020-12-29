package Assets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import processing.core.*;


import pieces.*;

public class DisplayPanel extends PApplet implements ActionListener {

	private Map map;
	private Timer timer, playerTimer;
	private Player player;
	private int lazerY, lazerX;

	public DisplayPanel() {
		player = new pieces.Player(0, 550 / 2);
		map = new Map(50, player);
		// player = new Player(0, 550 / 2);
		timer = new Timer(15, map);
		playerTimer = new Timer(30, this);
		timer.start();
		playerTimer.start();
		runSketch();
	}

	public void setup() {
		frameRate(30);
	}

	// runs at every game tick
	public void draw() {
		super.background(255);
		if (player.isDead()) {
			player.setRect(0, 0, 0, 0);
			stop();
			timer.stop();
			playerTimer.stop();
		}
		map.draw(this);
		player.paint(this);
		if(!player.isDead())
			line(30, lazerY, lazerX, lazerY);
	}

	public void keyPressed() {
		switch (keyCode) {
			case PConstants.UP: {
				player.moveY(-5);
				break;
			}
			case PConstants.DOWN: {
				player.moveY(5);
				break;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		lazerY = player.shoot();
		lazerX = map.getShot(lazerY);
		// TODO Auto-generated method stub
		
	}
}
