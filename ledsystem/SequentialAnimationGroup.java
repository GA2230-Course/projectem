package ledsystem;

public class sequentialAnimationGroup implements Animation {
    private final Animation[] animations;
    private int currentIndex;
    public sequentialAnimationGroup(Animation... animations) {
        this.animations = animations;
        this.currentIndex = 0;
    }

    @Override
    public void update() {
        if (currentIndex >= animations.length) {
            return;
        }
        animations[currentIndex].update();
        if (animations[currentIndex].isFinished()) {
            currentIndex++;
        }
    }

    @Override
    public void apply(LedStrip strip) {
        if (currentIndex >= animations.length) {
            return;
        }
        animations[currentIndex].apply(strip);
    }

    @Override
    public boolean isFinished() {
        return currentIndex >= animations.length;
    }
}
