package ledsystem;

interface Animation {
    void apply(LedStrip strip);

    void update();
}