package Assets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import processing.core.*;


import pieces.*;

public class DisplayPanel extends PApplet implements ActionListener {

	private Map map;
	private int score;
	private Timer timer, playerTimer;
	private Player player;
	private int lazerY, lazerX;

	public DisplayPanel() {
		player = new pieces.Player(0, 550 / 2);
		map = new Map(50);
		// timer = new Timer(15, map);
		// playerTimer = new Timer(30, this);
		// timer.start();
		// playerTimer.start();
		
		runSketch(); // instantiates drawing surface
	}

	public void setup() {
		frameRate(60);
		textAlign(PConstants.CENTER);
		textSize(20);
	}

	// runs at every game tick
	public void draw() {
		super.background(255);
		map.draw(this, player);
		score = map.getLevel() - 4;

		if (player.isDead()) {
			player.setRect(0, 0, 0, 0);
			stop();
			// timer.stop();
			// playerTimer.stop();
			
			textSize(32);
			
			fill(0);
			text("Game Over!\nYour Score: " + score, this.width / 2, this.height / 2 );
		}

		lazerY = player.shoot();
		lazerX = map.getShot(lazerY);

		player.paint(this);
		player.drawHealth(this);
		if (!player.isDead()) {
			fill(0);
			if (score < 0)
				text("Score: " + 0, this.width / 2, 20);
			else
				text("Score: " + score, this.width / 2, 20);
			line(30, lazerY, lazerX, lazerY);
		}
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
		// TODO Auto-generated method stub

	}
}
