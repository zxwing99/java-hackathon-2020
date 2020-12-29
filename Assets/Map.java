package Assets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.LinkedList;

import pieces.*;
import processing.core.PConstants;
import processing.event.KeyEvent;

public class Map implements ActionListener {
	
	private LinkedList<walls[]> walls;
	private int wallCount, level, enimies;
	private int wallSize;
	private Player player;
	private int distance;
	private int immunity;

	public Map(int wallSize, Player player) {
		this.wallSize = wallSize;
		this.player = player;
		wallCount = 1;
		level = 1;
		enimies = 0;
		walls = new LinkedList<walls[]>();
		for (int i = 2; i < 5; i++) {
			createWall(100 * i);
		}
		distance = 0;
		immunity = 0;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void createWall(int x) {
		walls[] newWall = new walls[10];
		if (level % 6 == 0 && wallCount < 7) {
			wallCount++;
		}
		if (level % 10 == 0 && enimies < 3) {
			enimies ++;
		}
		int wallc = 0;
		int enimiec = 0;
		while (wallc < wallCount) {
			int i = (int) (Math.random()*10);
			if (newWall[i] == null) {
				newWall[i] = new pieces.walls(x, wallSize*i, 40, wallSize);
				wallc++;
			}
		}
		while (enimiec < enimies) {
			int i = (int) (Math.random()*10);
			if (newWall[i] == null) {
				newWall[i] = new pieces.enimies(x, wallSize*i, 40, wallSize);
				enimiec++;
			}
		}
		this.walls.add(newWall);
		level++;
	}

	public void draw(DisplayPanel dp) {
		if (player.isDead()) {
			// player = null;
		}

		player.paint(dp);

		for(walls[] bigWall : this.walls) {
			for (walls wall : bigWall) {
				if (wall != null)
					wall.paint(dp);
			}
		}
		for (int i = 0; i < 10; i++) {
			if (this.walls.getFirst()[i] != null) {
				if (this.walls.getFirst()[i].getX() < -40) {
					this.walls.removeFirst();
				}
				break;
			}
		}
	}
	
	public int getShot(int y) {
		int row = y/50;
		for(walls[] bigWall: walls) {
			if(bigWall[row] != null) {
				if(bigWall[row] instanceof enimies) {
					bigWall[row].setY(-5);
				}
				else
					return (int) bigWall[row].x;
			}
		}
		return 550;
	}

	private void detectCollisions() {
		if (immunity<=0) {
			walls[] bigWall = walls.getFirst();
			for (int i = 0; i < 10; i++) {
				if (bigWall[i] != null && bigWall[i].intersects(player)) {
					player.takeDamage();
					immunity = 70;
				}
			}
		}
		else {
			immunity--;
		}
	}

	private void shiftWalls() {
		for(walls[] bigWall : this.walls) {
			for (walls wall : bigWall) {
				if (wall != null) {
					wall.updateX(-1);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {		

		// TODO Auto-generated method stub
		distance++;
		if (distance % 100 == 0)
			createWall(550);
		shiftWalls();
		detectCollisions();
		
	}

}
