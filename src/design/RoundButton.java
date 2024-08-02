// design/RoundButton.java
package design;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

// Design-Klasse, welcher das Aussehen der damit instanziierten Knöpfe festlegt
public class RoundButton extends JButton {

	// Stärke der Rundung des Knopfes
	private final int power;

	public RoundButton(String text, int power) {
		super(text);
		this.power = power;

		// Deaktiviert alle Standard-Styleelemente eines Knopfes
		setContentAreaFilled(false);
		setFocusPainted(false);
		setBorderPainted(false);
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// Farbänderung bei Betätigung des Knopfes
		if (getModel().isArmed()) {
			g.setColor(getBackground().darker());
		} else {
			g.setColor(getBackground());
		}

		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));

		// Füllung des Knopfes
		g2d.fillOval(0, 0, getWidth() - 1, getHeight() - 1);

		// Rand des Knopfes
		g2d.setStroke(new BasicStroke(1.2f));
		g2d.setColor(getForeground());
		g2d.drawOval(0, 0, getWidth() - 1, getHeight() - 1);

		super.paintComponent(g2d);
	}
}
