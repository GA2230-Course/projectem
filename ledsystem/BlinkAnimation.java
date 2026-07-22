package ledsystem;

import ledsystem.utils.StopWatch;
import java.awt.Color;

public class BlinkAnimation implements Animation {

    private final Color firstColor;
    private final Color secondColor;
    private final StopWatch blinkTimer;
    private final StopWatch runTimer;
    private boolean useFirstColor;

    public BlinkAnimation(Color firstColor, Color secondColor) {
        this.firstColor = firstColor;
        this.secondColor = secondColor;
        this.blinkTimer = new StopWatch();
        this.runTimer = new StopWatch();

        this.blinkTimer.start();
        this.runTimer.start();
        this.useFirstColor = true;
    }

    @Override
    public void update() {
        if (blinkTimer.get() >= 2.0) {
            useFirstColor = !useFirstColor;
            blinkTimer.start();
        }
    }

    @Override
    public void apply(LedStrip strip) {
        Color currentColor = useFirstColor ? firstColor : secondColor;

        for (int i = 0; i < strip.getLength(); i++) {
            strip.setColor(i, currentColor);
        }
    }

    @Override
    public boolean isFinished() {
        return runTimer.get() >= 10.0;
    }
}