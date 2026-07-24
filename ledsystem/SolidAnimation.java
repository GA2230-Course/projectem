package ledsystem;

import ledsystem.ledssim.LedStrip;
import java.awt.Color;
import java.util.Objects;

public class SolidAnimation implements Animation {
    private final Color color;

    public SolidAnimation(Color color) {
        this.color = Objects.requireNonNull(color, "Solid paint color cannot be null");
    }

    @Override
    public void apply(LedStrip strip) {
        Objects.requireNonNull(strip, "LED strip cannot be null");
        strip.setAll(this.color);
    }
}