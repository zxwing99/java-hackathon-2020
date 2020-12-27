package pieces;

import java.awt.Graphics;
import java.awt.Color;

public class walls {
	private int x, y, width, height;
	private Color color;

	public walls(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
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

	void paint(Graphics g) {
		g.fillRect(x, y, width, height);
	}
}
