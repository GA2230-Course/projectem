package ledsystem;

import ledsystem.ledssim.LedSim;
import java.awt.Color;

public class MainProjectCode {
    public static void main(String[] args) throws InterruptedException {

        LedSim strip = LedSim.createRows(10);
        LedController controller = new LedController(strip);

        Animation redSolidTimed = new TimerAnimation(new SolidAnimation(Color.RED), 3.0);
        Animation dynamicBlinkTimed = new TimerAnimation(new BlinkAnimation(Color.BLUE, Color.CYAN), 6.0);
        Animation beautifulFadeTimed = new TimerAnimation(new FadeAnimation(Color.MAGENTA, Color.GREEN), 4.0);

        SequentialAnimationGroup masterSequence = new SequentialAnimationGroup(
                redSolidTimed,
                dynamicBlinkTimed,
                beautifulFadeTimed
        );

        controller.addAnimation(masterSequence);
        System.out.println("Starting clean, decoupled LED root loop engine...");

        while (true) {
            controller.tickNextFrame();

            strip.apply();

            Thread.sleep(30);
        }
    }
}
