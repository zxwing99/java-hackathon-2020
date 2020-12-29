package pieces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends walls {
	private int health;
	private int moveSpeed;

	public Player(int x, int y) {
		super(x, y, 30, 40);
		setColor(Color.GREEN);
		moveSpeed = 20;
		health = 4;
	}
	
	public void moveY(int move) {
		y += move;
	}

	public void takeDamage() {
		health--;
		System.out.println(health);
	}

	public boolean isDead() {
		if (health <= 0) return true;
		return false;
	}
	
	public int shoot() {
		return (int) (y+15);
	}

}
