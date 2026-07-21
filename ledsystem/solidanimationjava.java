package ledsystem;
import ledsystem.utils.StopWatch;
import java.awt.Color;

class SolidAnimation implements Animation {
    private final Color color;
    private final StopWatch stopWatch;

    public SolidAnimation(Color color) {
        this.color = color;
        this.stopWatch = new StopWatch();
        this.stopWatch.start();
    }


    @Override
    public void apply(LedStrip strip) {
        for (int i = 0; i < strip.getLength(); i++) {
            strip.setColor(i, this.color);
        }
    }

    @Override
    public void update() {

    }

    @Override
    public boolean isFinished() {
        return stopWatch.get() >= 5.0;
    }
}