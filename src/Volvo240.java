import java.awt.*;

/**
    En bil som fungerar både på rally och på vägen, kanske också rally på vägen. Går på bensin och vodka, kölar gött.
    240 LEVERERAR.
 */
public class Volvo240 extends Car{

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
