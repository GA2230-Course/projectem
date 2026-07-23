package ledsystem;

import ledsystem.utils.StopWatch;

public class SequentialAnimationGroup implements Animation {
    private final Animation[] animations;
    private StopWatch currentTimer;
    private int currentIndex;

    public SequentialAnimationGroup(Animation... animations) {
        this.animations = animations;
        this.currentIndex = 0;
        this.currentTimer = new StopWatch();
        this.currentTimer.start();
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
                this.currentTimer = new StopWatch();
                this.currentTimer.start();
            }
        } else {
            currentIndex++;
            this.currentTimer = new StopWatch();
            this.currentTimer.start();
        }
    }
}