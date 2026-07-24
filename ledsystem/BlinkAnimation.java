package ledsystem;

import ledsystem.ledssim.LedStrip;
import ledsystem.utils.StopWatch;
import java.awt.Color;

public class BlinkAnimation implements Animation {

    private final Color firstColor;
    private final Color secondColor;
    private final StopWatch blinkTimer;
    private boolean useFirstColor;

    public BlinkAnimation(Color firstColor, Color secondColor) {
        this.firstColor = firstColor;
        this.secondColor = secondColor;
        this.blinkTimer = new StopWatch();

        this.blinkTimer.start();
        this.useFirstColor = true;
    }

    @Override
    public void apply(LedStrip strip) {
        if (blinkTimer.get() >= 2.0) {
            useFirstColor = !useFirstColor;
            blinkTimer.start();
        }

        Color currentColor = useFirstColor ? firstColor : secondColor;

        strip.setAll(currentColor);
    }
}