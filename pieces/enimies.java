package pieces;

import java.awt.Color;

public class enimies extends walls {
	public enimies(int x, int y, int width, int height) {
		super(x, y, width, height);
		super.setColor(Color.RED);
	}
}
