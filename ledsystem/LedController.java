package ledsystem;

public class LedController {
    private final LedStrip strip;
    private Animation animation;
    public LedController(int stripLength) {
        this.strip = new LedStrip(stripLength);
    }

    public void addAnimation(Animation animation) {
        this.animation = animation;
    }

    public void play() {
        while (true) {
            if (this.animation != null) {
                this.animation.update();
                this.animation.apply(strip);

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