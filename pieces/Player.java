package pieces;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	private int x, y;
	private int health;
	private Color color;

	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.health = 4;
	}

	public void moveX(int move) {
		x += move;
	}

	public void moveY(int move) {
		y += move;
	}

	public void paint(Graphics g) {
		
	}

	public void takeDamage() {
		health--;
	}
}
