package ru.oskin_di.homework_1.task_2;

public class Lorry extends Car {

    public Lorry(Engine engine, String color, String name) {
        super(engine, color, name);
    }


    @Override
    public void start() {
        System.out.println("Lorry starting");
    }

    @Override
    public void move() {
        System.out.println("Lorry is moving");
    }

    @Override
    public void stop() {
        System.out.println("Lorry is stop");
    }

    @Override
    public void open() {
        System.out.println("Lorry is open");
    }
}

