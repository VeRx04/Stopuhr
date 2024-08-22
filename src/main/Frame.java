package main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

// Hauptframe des Projekts
public class Frame extends JFrame {

    public Frame() {
		Panel panel = new Panel();

		// Konfigurationen des Frames
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
        add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setIconImage(new ImageIcon(getClass().getResource("/res/clock.png")).getImage());
	}
}
