package ledsystem;

import java.awt.Color;

class SolidAnimation implements Animation {
    private final Color color;

    public SolidAnimation(Color color) {
        this.color = color;
    }

    @Override
    public void apply(LedStrip strip) {
        for (int i = 0; i < strip.getLength(); i++) {
            strip.setColor(i, this.color);
        }
    }
}
