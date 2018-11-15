import java.awt.*;



public abstract class Car implements Movable{

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    private int rotation; // The rotation of the car in degrees
    private double xCordinate = 0;
    private double yCordinate = 0;

    /**
     * Initiates a car, based on subclass parameters
     * @param nrDoors number of doors
     * @param enginePower The power of the engine
     * @param color The color of the Car
     * @param modelName The model of the car, the cars model.
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    private int rotate(int angle){
        int rotation =  (this.rotation + angle)%360;
        return (rotation > 0) ? rotation : 360 + rotation;
    }

    public int getNrDoors(){
        return nrDoors;
    }


    public double getEnginePower(){
        return enginePower;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public int getRotation(){
        return rotation;
    }

    public double getxCordinate(){
        return xCordinate;
    }

    public double getyCordinate() {
        return yCordinate;
    }
    /**
     * Sets the car speed to 0.1
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Sets the Car speed to 0
     */
    private void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Gives the highest maximum speed change
     * @return Max speed change
     */
    public abstract double speedFactor();

    private void incrementSpeed(double amount){
        double newSpeed = getCurrentSpeed() + speedFactor() * amount;
        currentSpeed = getEnginePower() >= newSpeed ? newSpeed : getEnginePower();
    }

    private void decrementSpeed(double amount){
        double newSpeed = getCurrentSpeed() - speedFactor() * amount;
        currentSpeed = newSpeed > 0 ? newSpeed : 0;
    }

    /**
     * Applies the throttle between 0-1
     * @param speed
     */
    // TODO fix this method according to lab pm
    public final void gas(double speed){
        incrementSpeed(capSpeed(speed));
    }
    /**
     * Presses down the break lever machine stick by a factor of 0-1
     * @param
     */
    // TODO fix this method according to lab pm
    public final void brake(double speed){
        decrementSpeed(capSpeed(speed));
    }

    private double capSpeed(double speed){
        return Math.min(1, Math.max(speed, 0));
    }

    /**
     * Changes the car's x,y cordinates based on its current speed and angle
     */
    @Override
    public void     move() {
        xCordinate =  Math.cos(Math.toRadians(rotation))*getCurrentSpeed();
        yCordinate =  Math.sin(Math.toRadians(rotation))*getCurrentSpeed();
    }

    /**
     * Changes the car's direction by 10 degrees positive
     */
    @Override
    public void turnLeft() {
        rotation = rotate(10);
    }

    /**
     * Changes the car direction by 10 degrees negative
     */
    @Override
    public void turnRight() {
        rotation = rotate(-10);

    }
}
