package ledsystem;

import ledsystem.utils.StopWatch;
import java.awt.Color;

class BlinkAnimation implements Animation {

    private final Color firstcolor;
    private final Color secondcolor;
    private final StopWatch stopWatch;
    private boolean usefirstcolor;
    public BlinkAnimation(Color firstcolor, Color secondcolor) {
        this.firstcolor= firstcolor;
        this.secondcolor = secondcolor;
        this.stopWatch = new StopWatch();
        this.usefirstcolor = true;
        this.stopWatch.start();
    }
    @Override
    public void update() {
        System.out.println("Time passed: " + stopWatch.get());
        if (stopWatch.get() >= 2.0) {
            usefirstcolor = !usefirstcolor;
            stopWatch.start();
        }
    }
    @Override
    public void apply(LedStrip strip) {
        Color currentColor = usefirstcolor ? firstcolor : secondcolor;

        for (int i = 0; i < strip.getLength(); i++) {
            strip.setColor(i, currentColor);
        }
    }

}