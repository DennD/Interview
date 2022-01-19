package ru.oskin_di.homework_1.task_2;

/**
 * для рефакторинга нужно больше условий задачи
 */
public abstract class Car implements Moveable, Stopable {

    private Engine engine;
    private String color;
    private String name;


    public Car(Engine engine, String color, String name) {
        this.engine = engine;
        this.color = color;
        this.name = name;
    }

    /**
     * метод start можно прокинуть в интерфейс, но это тоже зависит от дополнительных условий задачи
     */
    public void start() {
        System.out.println("Car starting");
    }

    public abstract void open();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
