package ledsystem;

class LedController {
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
        }
    }
    public LedStrip getStrip() {
        return this.strip;
    }
}