package ledsystem;

import ledsystem.ledssim.LedStrip;
import ledsystem.utils.StopWatch;
import java.util.Objects;

public class TimerAnimation implements Animation, Timed {
    private final Animation wrappedAnimation;
    private final double durationSeconds;
    private final StopWatch timer;

    public TimerAnimation(Animation wrappedAnimation, double durationSeconds) {
        this.wrappedAnimation = Objects.requireNonNull(wrappedAnimation, "Wrapped animation cannot be null");
        if (durationSeconds <= 0.0) {
            throw new IllegalArgumentException("Duration must be greater than zero: " + durationSeconds);
        }
        this.durationSeconds = durationSeconds;
        this.timer = new StopWatch();
        this.timer.start();
    }

    @Override
    public void apply(LedStrip strip) {
        Objects.requireNonNull(strip, "LED strip cannot be null");
        wrappedAnimation.apply(strip);
    }

    @Override
    public boolean isTimeUp() {
        return this.timer.get() >= this.durationSeconds;
    }
}