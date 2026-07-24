package ledsystem;

import ledsystem.ledssim.LedSim;
import java.awt.Color;

public class mainprojectcode {
    public static void main(String[] args) throws InterruptedException{
        LedSim strip = LedSim.createRows(10);

        LedController controller = new LedController(strip);

        RandomAnimationGroup vegasproject = new RandomAnimationGroup(
                new TimerAnimation(Color.RED, 5),
                new TimerAnimation(Color.BLUE, 10),
                new TimerAnimation(Color.CYAN, 15)
        );

        controller.addAnimation(vegasproject);

        System.out.println("Starting LED Simulation Window...");
        controller.play();
    }
}
