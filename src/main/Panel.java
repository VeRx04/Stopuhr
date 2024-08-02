package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import components.Buttons;
import components.Time;

// Hauptpanel des Projekts
public class Panel extends JPanel {
	private final Buttons buttons;
	private final Time time;

	public Panel() {
		setLayout(null);
		setPreferredSize(new Dimension(504, 896));

		// Position der Zeitausgabe
		time = new Time(0, 0, 504, 300);

		// Position des Knöpfeblocks
		buttons = new Buttons(50, 375, 100, 100, time);

		// Hinzufügen der jeweiligen Komponenten zum Panel
		add(buttons.getStartButton());
		add(buttons.getStopButton());
		add(buttons.getResetButton());
		add(time.getZeitLabel());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// dunkelgraue Hintergrundsfarbe
		g.setColor(new Color(45, 45, 45));

		// Hintergrund für den Bereich unterhalb der Zeitausgabe
		g.fillRect(0, 300, 504, 596);
	}

	public Time getZeit() {
		return time;
	}
}