package ledsystem;

import ledsystem.utils.ColorUtils;
import ledsystem.utils.StopWatch;
import java.awt.Color;

public class FadeAnimation implements Animation {
    private final Color startColor;
    private final Color endColor;
    private final StopWatch progressTimer;
    private boolean goingForward;

    public FadeAnimation(Color startColor, Color endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
        this.goingForward = true;
        this.progressTimer = new StopWatch();
        this.progressTimer.start();
    }

    @Override
    public void apply(LedStrip strip) {
        if (progressTimer.get() >= 2.0) {
            goingForward = !goingForward;
            progressTimer.start();
        }
        double t = progressTimer.get() / 2.0;
        t = ColorUtils.clamp(0.0, 1.0, t);
        if (!goingForward) {
            t = 1.0 - t;
        }
        Color blendedColor = ColorUtils.lerp(startColor, endColor, t);
        for (int i = 0; i < strip.getLength(); i++) {
            strip.setColor(i, blendedColor);
        }
    }
}