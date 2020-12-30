package pieces;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import Assets.DisplayPanel;
import processing.core.PConstants;

public class Player extends walls {
	private int health;
	private Ellipse2D.Double[] healthPoints;
	private Color hpColor = Color.ORANGE;

	public Player(int x, int y) {
		super(x, y, 30, 40);
		setColor(Color.GREEN);
		health = 4;

		healthPoints = new Ellipse2D.Double[health];
		for (int i = 0; i < health; i++) {
			healthPoints[i] = new Ellipse2D.Double(i * 25, 0, 15, 15);
		}
	}
	
	public void moveY(int move) {
		y += move;
	}

	public void takeDamage() {
		health--;
		// System.out.println(health);
	}

	public boolean isDead() {
		if (health <= 0) return true;
		return false;
	}
	
	public int shoot() {
		return (int) (this.y + this.height / 2);
	}

	public void drawHealth(DisplayPanel dp) {
		dp.pushMatrix();
		dp.pushStyle();
		dp.ellipseMode(PConstants.CORNER);
		for (int i = 0; i < health; i++) {
			Ellipse2D.Double cur = healthPoints[i];
			if (cur != null) {
				dp.fill(hpColor.getRed(),hpColor.getGreen(), hpColor.getBlue());
				dp.ellipse((int)cur.x, (int)cur.y, (int)cur.width, (int)cur.height);
			}
		}
		dp.popMatrix();
		dp.popStyle();
	}

}
