package ledsystem;

import ledsystem.utils.ColorUtils;
import ledsystem.utils.StopWatch;
import java.awt.Color;
public class FadeAnimation implements Animation {
    private final Color startColor;
    private final Color endColor;
    private StopWatch progressTimer;
    private StopWatch totalTimer;
    private boolean goingForward;

    public FadeAnimation(Color startColor, Color endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
        this.goingForward = true;
        this.progressTimer = new StopWatch();
        this.totalTimer = new StopWatch();
        this.progressTimer.start();
        this.totalTimer.start();
    }

    @Override
    public void update() {
        if (progressTimer.get() >= 2.0) {
            goingForward = !goingForward;
            progressTimer.start();
        }
    }

    @Override
    public void apply(LedStrip strip) {
        double t = progressTimer.get() / 2.0;
        t = ColorUtils.clamp(0.0, 1.0, t);
        if (!goingForward) {
            t = 1.0 - t;
        }
        Color blendedColor = ColorUtils.lerp(startColor, endColor,t);
        for (int i = 0; i < strip.getLength(); i++) {
            strip.setColor(i, blendedColor);
        }
    }

    @Override
    public boolean isFinished() {
        return totalTimer.get() >= 10.0;
    }
}