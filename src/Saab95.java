import java.awt.*;

/**
 * Törbon drar som fa'an
 */

public class Saab95 extends Car {

    private boolean turboOn;

    /**
     * Initiates a standard Saab95
     */
    public Saab95() {
        super(2, 125, Color.red, "Saab95");
        setTurboOff();
    }


    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
