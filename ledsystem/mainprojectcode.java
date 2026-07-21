import ledsystem.*;

import java.awt.Color;
public static void main(String[] args) {
    LedController controller = new LedController(10);

    sequentialAnimationGroup playlist = new sequentialAnimationGroup(
            new SolidAnimation(Color.GREEN),
            new BlinkAnimation(Color.RED, Color.BLUE),
            new FadeAnimation(Color.YELLOW, Color.RED)
    );

    controller.addAnimation(playlist);
    controller.play();
}