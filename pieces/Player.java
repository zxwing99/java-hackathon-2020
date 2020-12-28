package pieces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Assets.Map;

public class Player extends Rectangle{
	private int health;
	private Color color;

	public Player(int x, int y) {
		super(x, y, 10, 10);
		this.health = 4;
		this.color = Color.GREEN;
	}

	public void moveX(int move) {
		x += move;
	}

	public void moveY(int move) {
		y += move;
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	public void takeDamage() {
		health--;
	}

	public boolean isDead() {
		if (health <= 0) return true;
		return false;
	}

}
