package ru.oskin_di.homework_1;

import ru.oskin_di.homework_1.task_1.Person;
import ru.oskin_di.homework_1.task_3.Circle;
import ru.oskin_di.homework_1.task_3.Figure;
import ru.oskin_di.homework_1.task_3.Square;
import ru.oskin_di.homework_1.task_3.Triangle;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //test task_1
        Person person = Person.builder()
                .firstName("Denis")
                .age(29)
                .country("Russia")
                .build();
        System.out.println(person);

        //test task_3
        Arrays.asList(new Figure(), new Square(), new Triangle(), new Circle()).forEach(Figure::whatIsThis);
    }
}
