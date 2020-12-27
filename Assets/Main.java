package Assets;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.util.*;

import pieces.walls;

public class Main extends JFrame{
	static Container c;
	static ArrayList<walls> wallArray = new ArrayList<walls>();

	public static void main(String[] args) {
		Main panel = new Main();
		panel.setTitle("Test Title");
		panel.setBounds(100, 100, 800, 600); 
		panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setResizable(false);
		c = panel.getContentPane(); // *****
		// c.setBackground(Color.BLACK);
		panel.setBackground(Color.BLACK);
		panel.setVisible(true); // ***
		c.setVisible(true);
		wallArray.add(new walls(100, 100, 200, 200));
		wallArray.add(new walls(310, 100, 200, 200));
		c.paint(null);
	}

	public void paint(Graphics g) {
		super.paint(g);
		drawWalls(g);
	}

	public void drawWalls(Graphics g) {
		for (walls wall : wallArray) {
			wall.paint(g);
		}
	}
}