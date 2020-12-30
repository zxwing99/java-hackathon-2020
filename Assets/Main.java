package Assets;

import java.awt.*;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;

public class Main extends JFrame{
	static Container c;

	public static void main(String[] args) {
		DisplayPanel drawing = new DisplayPanel();
//		drawing.runSketch();

		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame) canvas.getFrame();

		window.setSize(550, 535);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
	}
}