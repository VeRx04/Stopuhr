package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import design.RoundButton;

// Klasse mit Funktionalitäten der jeweiligen Knöpfe
public class Buttons implements ActionListener {
	private final JButton startButton;
	private final JButton stopButton;
	private final JButton resetButton;
	private final Time time;

	public Buttons(int xPos, int yPos, int xSize, int ySize, Time time) {
		this.time = time;

		// Erschaffung und Konfigurationen der Knöpfe
		startButton = createButton("Start", xPos, yPos, xSize, ySize, 0, 255, 0);
		stopButton = createButton("Stop", xPos + 150, yPos, xSize, ySize, 255, 0, 0);
		resetButton = createButton("Reset", xPos + 300, yPos, xSize, ySize, 0, 0, 255);
	}

	// Methode zum Konstruieren eines Knopfes
	private JButton createButton(String text, int xPos, int yPos, int xSize, int ySize, int r, int g, int b) {
		RoundButton button = new RoundButton(text, 10);
		button.setBounds(xPos, yPos, xSize, ySize);
		button.setBackground(Color.white);
		button.setForeground(new Color(r, g, b));
		button.setFont(new Font("Canva Sans", Font.BOLD, 20));
		button.addActionListener(this);
		return button;
	}

	public JButton getStartButton() {
		return startButton;
	}

	public JButton getStopButton() {
		return stopButton;
	}

	public JButton getResetButton() {
		return resetButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == startButton) {
			time.start();
		} else if (source == stopButton) {
			time.stop();
		} else if (source == resetButton) {
			time.stop();
			time.reset();
		}
	}
}