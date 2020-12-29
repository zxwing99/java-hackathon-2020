package pieces;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import Assets.DisplayPanel;

public class walls extends Rectangle2D.Double {
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
	public void setY(int y) {
		this.y = y;
	}

	public void updateY(int move) {
		this.y += move;
	}

	public void paint(DisplayPanel g) {
		g.pushMatrix();
		g.pushStyle();
		g.fill(color.getRed(),color.getGreen(), color.getBlue());
		g.rect((int)x, (int)y, (int)(width), (int)(height));
		g.popMatrix();
		g.popStyle();
	}
}
