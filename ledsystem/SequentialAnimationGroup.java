package ledsystem;

public class SequentialAnimationGroup implements Animation {
    private final Animation[] animations;
    private int currentIndex;

    public SequentialAnimationGroup(Animation... animations) {
        this.animations = animations;
        this.currentIndex = 0;
    }

    @Override
    public void apply(LedStrip strip) {
        if (currentIndex >= animations.length) {
            return;
        }

        Animation current = animations[currentIndex];
        current.apply(strip);
        if (current instanceof TimerAnimation) {
            TimerAnimation timerAnim = (TimerAnimation) current;
            if (timerAnim.isTimeUp()) {
                currentIndex++;
            }
        }
    }
}