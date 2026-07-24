package ledsystem;

import ledsystem.ledssim.LedStrip;
import ledsystem.utils.StopWatch;
import java.awt.Color;

public class TimerAnimation implements Animation {
    private final Color color;
    private final double durationSeconds;
    private final StopWatch timer;

    public TimerAnimation(Color color, double durationSeconds) {
        this.color = color;
        this.durationSeconds = durationSeconds;
        this.timer = new StopWatch();
        this.timer.start();
    }

    @Override
    public void apply(LedStrip strip) {
        strip.setAll(this.color);
    }

    public boolean isTimeUp() {
        return this.timer.get() >= this.durationSeconds;
    }
}