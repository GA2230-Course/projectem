package ledsystem;

import ledsystem.ledssim.LedStrip;
import java.awt.Color;

public class SolidAnimation implements Animation {
    private final Color color;

    public SolidAnimation(Color color) {
        this.color = color;
    }

    @Override
    public void apply(LedStrip strip) {
        strip.setAll(this.color);
    }
}