package ledsystem;

import ledsystem.utils.StopWatch;
import java.awt.Color;

class BlinkAnimation implements Animation {

    private final Color firstcolor;
    private final StopWatch blinkTimer;
    private final StopWatch runTimer;
    private final Color secondcolor;
    private boolean usefirstcolor;
    public BlinkAnimation(Color firstcolor, Color secondcolor) {
        this.firstcolor= firstcolor;
        this.secondcolor = secondcolor;
        this.blinkTimer = new StopWatch();
        this.runTimer = new StopWatch();
        this.blinkTimer.start();
        this.runTimer.start();
        this.usefirstcolor = true;
    }
    @Override
    public void update() {
        System.out.println("Time passed: " + blinkTimer.get());
        if (blinkTimer.get() >= 2.0) {
            usefirstcolor = !usefirstcolor;
            blinkTimer.start();
        }
    }
    @Override
    public void apply(LedStrip strip) {
        Color currentColor = usefirstcolor ? firstcolor : secondcolor;

        for (int i = 0; i < strip.getLength(); i++) {
            strip.setColor(i, currentColor);
        }
    }
    @Override
    public boolean isFinished() {
        return runTimer.get() >= 10.0;
    }

}