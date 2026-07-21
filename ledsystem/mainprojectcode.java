package ledsystem;
import java.awt.Color;

class Project1 {
    public static void main(String[] args) {
        LedController controller = new LedController(10);
        BlinkAnimation blinkingAnimation= new BlinkAnimation(Color.RED, Color.BLUE);
        controller.addAnimation(blinkingAnimation);
        controller.play();
    }

}