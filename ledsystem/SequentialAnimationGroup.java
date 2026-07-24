package ledsystem;
import ledsystem.ledssim.LedStrip;
import ledsystem.utils.StopWatch;
import java.util.Objects;
public class SequentialAnimationGroup implements Animation, Timed {
    private final Animation[] animations;
    private final StopWatch currentTimer;
    private int currentIndex;
    public SequentialAnimationGroup(Animation... animations) {
        Objects.requireNonNull(animations, "Animations array cant be null");
        if (animations.length == 0) {
            throw new IllegalArgumentException("needs to put at lease one animation");
        }
        for (Animation anim : animations) {
            Objects.requireNonNull(anim, "Animation objects cant be null");
        }
        this.animations = animations;
        this.currentIndex = 0;
        this.currentTimer = new StopWatch();
        this.currentTimer.start();
    }
    @Override
    public void apply(LedStrip strip) {
        Objects.requireNonNull(strip, "LED strip cant be null");
        if (isTimeUp()) {
            return;
        }
        Animation current = animations[currentIndex];
        current.apply(strip);
        boolean shouldAdvance = false;
        if (current instanceof Timed) {
            if (((Timed) current).isTimeUp()) {
                shouldAdvance = true;
            }
        } else {
            if (this.currentTimer.get() >= 5.0) {
                shouldAdvance = true;
            }
        }

        if (shouldAdvance) {
            currentIndex++;
            this.currentTimer.start();
        }
    }

    @Override
    public boolean isTimeUp() {
        return currentIndex >= animations.length;
    }
}