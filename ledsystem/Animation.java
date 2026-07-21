package ledsystem;

public interface Animation {
    void apply(LedStrip strip);

    void update();
    boolean isFinished();
}
