package ledsystem;

import java.awt.Color;
import javax.swing.JFrame;

class LedStrip {
    private final int length;
    private final JFrame window;

    public LedStrip(int length) {
        this.length = length;
        window = new JFrame("LED Strip Simulation");
        window.setSize(300, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public int getLength() {
        return this.length;
    }

    public void setColor(int index, Color color) {
        window.getContentPane().setBackground(color);
    }
}

