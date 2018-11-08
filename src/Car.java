import java.awt.*;

public abstract class Car implements Movable{


    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    private int rotation; // The rotation of the car in degrees
    private double xCordinate;
    private double yCordinate;

    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    private int rotate(int angle){
        int rotation =  (this.rotation + angle)%360;
        rotation = (rotation > 0) ? rotation : 360 + rotation;
        return rotation;

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

    public void startEngine(){
        currentSpeed = 0.1;
    }

    private void stopEngine(){
        currentSpeed = 0;
    }

    public abstract double speedFactor();

    private void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    private void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    @Override
    public void move() {
        xCordinate =  (Math.cos(Math.toRadians(rotation))*getCurrentSpeed());
        yCordinate =  (Math.sin(Math.toRadians(rotation))*getCurrentSpeed());

    }

    @Override
    public void turnLeft() {
        rotation = rotate(10);

    }

    @Override
    public void turnRight() {
        rotation = rotate(-10);

    }
}
