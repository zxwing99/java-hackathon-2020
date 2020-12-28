package Assets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import processing.core.PApplet;

import pieces.*;

public class DisplayPanel extends PApplet {

	private Map map;
	private Timer timer;

	public DisplayPanel() {
		map = new Map();
		timer = new Timer(50, map);
	}

}
