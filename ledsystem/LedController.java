package ledsystem;

import ledsystem.ledssim.LedStrip;
import ledsystem.utils.StopWatch;
import java.util.ArrayList;
import java.util.List;

public class LedController {
    private final LedStrip strip;
    private final List<Animation> animations;
    private int currentAnimationIndex;
    private final StopWatch animationTimer;

    public LedController(LedStrip strip) {
        this.strip = strip;
        this.animations = new ArrayList<>();
        this.currentAnimationIndex = 0;
        this.animationTimer = new StopWatch();
    }
    public void addAnimation(Animation animation) {
        this.animations.add(animation);
    }
    //I ADDED THE THREADSLEEP SO THE RUN OF THE RANDOM COLORS WILL GO SLOWER AND NOT SO FAST
    public void play() throws InterruptedException {
        if (this.animations.isEmpty()) {
            return;
        }
        this.animationTimer.start();
        while (true) {
            Animation current = this.animations.get(currentAnimationIndex);
            current.apply(strip);
            strip.apply();
            if (this.animationTimer.get() >= 10.0) {
                this.currentAnimationIndex = (this.currentAnimationIndex + 1) % this.animations.size();
                this.animationTimer.start();
            }
            Thread.sleep(75);
        }
    }
    public LedStrip getStrip() {
        return this.strip;
    }
}