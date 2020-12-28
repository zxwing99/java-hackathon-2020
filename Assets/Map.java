package Assets;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import pieces.*;

public class Map implements ActionListener{
	
	private LinkedList<walls[]> walls;
	private int wallCount, level, enimies;
	private int wallSize;
	
	public Map(int wallSize) {
		this.wallSize = wallSize;
		wallCount = 1;
		level = 0;
		enimies = 0;
		for (int i = 0; i < 5; i++) {
			createWall(20*i);
		}
	}
	
	public void createWall(int x) {
		walls[] newWall = new walls[10];
		if (level % 6 == 0 && wallCount <= 7) {
			wallCount++;
		}
		if (level % 10 == 0 && enimies <= 3) {
			enimies ++;
		}
		int wallc = 0;
		int enimiec = 0;
		while (wallc < wallCount) {
			int i = (int) (Math.random()*10);
			if (newWall[i] == null) {
				newWall[i] = new pieces.walls(x, wallSize*i, 20, wallSize);
				wallc++;
			}
		}
		while (enimiec < enimies) {
			int i = (int) (Math.random()*10);
			if (newWall[i] == null) {
				newWall[i] = new pieces.enimies(x, wallSize*i, 20, wallSize);
				enimiec++;
			}
		}
		this.walls.add(newWall);
		level++;
	}
	
	public void draw(Graphics dp) {
		for(walls[] bigWall : this.walls) {
			for (walls wall : bigWall) {
				wall.paint(dp);
			}
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
