import java.awt.*;

/**
    A representation of a Volvo 240 car.
 */
public class Volvo240 extends Car{

    /**
     * The trim factor of the car, directly affects the acceleration of the car.
     */
    public final static double trimFactor = 1.25;

    /**
     * Initiates a standard volvo240
     */
    public Volvo240(){
        super(4,100,Color.black,"Volvo240");
    }


    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
