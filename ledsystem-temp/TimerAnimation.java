package ledsystem;

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
        for (int i = 0; i < strip.getLength(); i++) {
            strip.setColor(i, this.color);
        }
    }

    public boolean isTimeUp() {
        return this.timer.get() >= this.durationSeconds;
    }
}