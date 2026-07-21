package ledsystem;

import java.awt.Color;

class Project1 {
    public static void main(String[] args) {
        LedController controller = new LedController(10);

        // Match the capital 'F'
        FadeAnimation creativecolor = new FadeAnimation(Color.MAGENTA, Color.BLUE);

        controller.addAnimation(creativecolor);
        controller.play();
    }
}