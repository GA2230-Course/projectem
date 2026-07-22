package ledsystem;
import ledsystem.utils.StopWatch;
import java.util.ArrayList;
import java.util.List;


public class LedController {
    private final LedStrip strip;
    private final List<Animation> animations;
    private int currentAnimationIndex;
    private final StopWatch animationTimer;

    public LedController(int stripLength) {
        this.strip = new LedStrip(stripLength);
        this.animations = new ArrayList<>();
        this.currentAnimationIndex = 0;
        this.animationTimer = new StopWatch();
    }

    public void addAnimation(Animation animation) {
        this.animations.add(animation);
    }

    public void play() {
        if (this.animations.isEmpty()) {
            return;
        }
        this.animationTimer.start();

        while (true) {
            Animation current = this.animations.get(currentAnimationIndex);
            current.apply(strip);

            if (this.animationTimer.get() >= 10.0) {
                this.currentAnimationIndex = (this.currentAnimationIndex + 1) % this.animations.size();
                this.animationTimer.start();


            }
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public LedStrip getStrip() {
        return this.strip;
    }
}