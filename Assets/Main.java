package Assets;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main extends JFrame{
	static Container c;

	public static void main(String[] args) {
		Main panel = new Main();
		panel.setTitle("Test Title");
		panel.setBounds(100, 100, 800, 600); 
		panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setResizable(false);
		c = panel.getContentPane(); // *****
		c.setBackground(Color.CYAN);
		panel.setBackground(Color.BLACK);
		panel.setVisible(true); // ***
		c.setVisible(true);
	}
}