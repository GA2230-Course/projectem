package ledsystem;

import java.awt.Color;

class Project1 {
    public static void main(String[] args) {
        LedStrip myStrip = new LedStrip(10);
        SolidAnimation redAnimation = new SolidAnimation(Color.RED);
        redAnimation.apply(myStrip);
    }
}
