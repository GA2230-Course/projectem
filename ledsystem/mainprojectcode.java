import ledsystem.*;
import java.awt.Color;

public static void main(String[] args) {
    LedController controller = new LedController(10);
            SequentialAnimationGroup a = new SequentialAnimationGroup(
            new TimerAnimation(Color.RED,5),
            new TimerAnimation(Color.BLUE,10)
    );
    controller.addAnimation(a);
    controller.play();

}