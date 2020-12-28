package pieces;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class walls extends Rectangle {
	private Color color;

	public walls(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.color = Color.GRAY;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color c) {
		color = c;
	}

	public void updateX(int move) {
		this.x += move;
	}

	public void updateY(int move) {
		this.y += move;
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
}
