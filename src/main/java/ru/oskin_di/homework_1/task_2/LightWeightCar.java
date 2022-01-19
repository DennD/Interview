package ru.oskin_di.homework_1.task_2;

public class LightWeightCar extends Car {

    public LightWeightCar(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    public void start() {
        System.out.println("LightWeightCar starting");
    }

    @Override
    public void open() {
        System.out.println("LightWeightCar is open");
    }

    @Override
    public void move() {
        System.out.println("LightWeightCar is moving");
    }

    @Override
    public void stop() {
        System.out.println("LightWeightCar is stop");
    }
}

