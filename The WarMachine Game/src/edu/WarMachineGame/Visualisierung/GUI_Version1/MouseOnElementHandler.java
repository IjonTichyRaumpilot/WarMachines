package edu.WarMachineGame.Visualisierung.GUI_Version1;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import edu.WarMachineGame.TestDrive.GameStarter;

public class MouseOnElementHandler implements MouseListener {

	private JPanel panel;
	private Color initialColor;
	private int x;
	private int y;

	public MouseOnElementHandler(int x, int y, JPanel panel) {
		this.x = x;
		this.y = y;
		this.panel = panel;
		this.initialColor = panel.getBackground();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		GameStarter.setInput(x + "," + y);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.panel.setBackground(Color.orange);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.panel.setBackground(Color.yellow);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.panel.setBackground(Color.yellow);

	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.panel.setBackground(this.initialColor);

	}

}
