package Assets;

import java.awt.Graphics;

import pieces.*;

public class Map {
	
	private walls[][] wallsAndEnemies = new walls[2][];
	private walls[] wals;
	private enimies[] enimies;
	private Player player;
	private Graphics g;
	
	public Map(int walls, int enemies) {
		createEverything(walls, enemies);
		for (walls[] entry : wallsAndEnemies) {
			for (walls wall : entry) {
				wall.paint(g);
			}
		}
	}
	
	private void createEverything(int walls, int enemies) {
		Player player1 = new Player(15,15);
		this.wals = new walls[walls];
		this.enimies = new enimies[enemies];
		
		for (int i = 0; i < walls; i++) {
			wals[i] = new walls(newNumber(), newNumber(), newNumber(), newNumber());
		}
		for (int i = 0; i < enemies; i++) {
			enimies[i] = new enimies(newNumber(), newNumber(), 5, 5);
		}
		wallsAndEnemies[0] = wals;
		wallsAndEnemies[1] = enimies;
	}
	
	private int newNumber() {
		return 5 + (int)(Math.random() * ((30 - 5) + 1));
	}

}
