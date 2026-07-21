package ledsystem;

import java.awt.Color;

class project {
    public static void main(String[] args) {
        LedController controller = new LedController(10);
        SolidAnimation redAnimation = new SolidAnimation(Color.RED);
        controller.addAnimation(redAnimation);
        controller.play();
    }
}
