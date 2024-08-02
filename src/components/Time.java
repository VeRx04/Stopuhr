package components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;

// Klasse mit Funktionalitäten zum Ermitteln und Ausgeben der Zeit
public class Time extends JTextArea implements Runnable {

    // Label, auf welchem die Zeit ausgegeben wird
    private final JLabel timeLabel;

    private final int xPos;
    private final int yPos;
    private final int xSize;
    private final int ySize;

    private long startTime;
    private long elapsedTime;

    private Thread thread;
    private boolean running;

    public Time(int xPos, int yPos, int xSize, int ySize) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.xSize = xSize;
        this.ySize = ySize;

        elapsedTime = 0;
        timeLabel = createLabel();
        thread = new Thread(this);
    }

    // Methode zum Konstruieren eines Labels
    private JLabel createLabel() {
        JLabel label = new JLabel("00:00:00.00");
        label.setBounds(xPos, yPos, xSize, ySize);
        label.setFont(new Font("Canva Sans", Font.BOLD, 85));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setOpaque(true);
        label.setBackground(Color.white);
        return label;
    }

    public JLabel getZeitLabel() {
        return timeLabel;
    }

    // Starten des Timers
    public void start() {
        running = true;
        startTime = System.currentTimeMillis();
        thread = new Thread(this);
        thread.start();
    }

    // Anhalten des Timers
    public void stop() {
        running = false;
        thread.interrupt();
    }

    // Zurücksetzen des Timers
    public void reset() {
        elapsedTime = 0;
        timeLabel.setText("00:00:00.00");
    }

    // Methode zum konstanten Aktualisieren des Timers
    @Override
    public void run() {
        while (running) {
            elapsedTime = System.currentTimeMillis() - startTime;
            String formattedTime = formatTime(elapsedTime);
            timeLabel.setText(formattedTime);
            repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Methode zum Formatieren der Zeit
    private String formatTime(long millis) {
        long hours = millis / 3600000;
        long minutes = (millis % 3600000) / 60000;
        long seconds = (millis % 60000) / 1000;
        long hundredths = (millis % 1000) / 10;

        return String.format("%02d:%02d:%02d.%02d", hours, minutes, seconds, hundredths);
    }
}
