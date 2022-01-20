package ru.oskin_di.homework_3.task_1;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        ThreadPing threadPing = new ThreadPing(printer);
        ThreadPong threadPong = new ThreadPong(printer);
    }
}
