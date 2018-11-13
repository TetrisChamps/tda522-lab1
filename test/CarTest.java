import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Saab95();
    }

    @AfterEach
    void tearDown() {
        car = null;
    }

    @Test
    void getNrDoors() {
        assertEquals(2, car.getNrDoors());
    }

    @Test
    void getEnginePower() {
        assertEquals(125, car.getEnginePower());
    }

    @Test
    void getCurrentSpeed() {
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    void getColor() {
        assertEquals(Color.red, car.getColor());
    }

    @Test
    void setColor() {
        car.setColor(Color.green);
        assertEquals(Color.green, car.getColor());
    }

    @Test
    void startEngine() {
        car.startEngine();
        assertEquals(0.1, car.getCurrentSpeed());
    }

    @Test
    void gas() {
        car.gas(2);
        assertEquals(2.5, car.getCurrentSpeed());
    }

    @Test
    void brake() {
        car.gas(2);
        car.brake(1);
        assertEquals(1.25, car.getCurrentSpeed());
    }

    @Test
    void moveX() {
        car.gas(2);
        car.turnLeft();
        car.move();
        assertEquals(2.46, (double) Math.round(car.getxCordinate() * 100.0) / 100.0);
    }

    @Test
    void moveY() {
        car.gas(2);
        car.turnLeft();
        car.move();
        assertEquals(0.43, (double) Math.round(car.getyCordinate() * 100.0) / 100.0);
    }

    @Test
    void turnLeft() {
        car.turnLeft();
        assertEquals(10, car.getRotation());
    }

    @Test
    void turnRight() {
        car.turnRight();
        assertEquals(350, car.getRotation());
    }

    @Test
    void getxCordinate(){
        assertEquals(0, car.getxCordinate());
    }

    @Test
    void getyCordinate(){
        assertEquals(0, car.getyCordinate());
    }
}