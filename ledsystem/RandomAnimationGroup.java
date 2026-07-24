package ledsystem;
import java.util.Random;
import ledsystem.ledssim.LedStrip;
import ledsystem.utils.StopWatch;

public class RandomAnimationGroup implements Animation {
    private final Animation[] animations;
    private final Random random;
    private StopWatch currentTimer;
    private int currentIndex;

    public RandomAnimationGroup(Animation... animations) {
        if (animations == null || animations.length == 0) {
            throw new IllegalArgumentException("Must provide at least one animation!");
        }
        this.animations = animations;
        this.random = new Random();
        this.currentIndex = 0;
        this.currentTimer = new StopWatch();
        this.currentTimer.start();
        this.currentIndex = random.nextInt(animations.length);
    }

    @Override
    public void apply(LedStrip strip) {
        Animation current = animations[currentIndex];
        current.apply(strip);
        boolean shouldAdvance = false;

        if (current instanceof TimerAnimation) {
            TimerAnimation timerAnim = (TimerAnimation) current;
            if (timerAnim.isTimeUp()) {
                shouldAdvance = true;
            }else{
                if (this.currentTimer.get() >= 5.0) {
                    shouldAdvance = true;
                }
            }
            if(shouldAdvance){
                this.currentIndex= random.nextInt(animations.length);
                this.currentTimer = new StopWatch();
                this.currentTimer.start();
            }
        }
    }
}
