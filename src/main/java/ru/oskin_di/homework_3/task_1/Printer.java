package ru.oskin_di.homework_3.task_1;

public class Printer {

    public synchronized void print(String message) {
        try {
            notify();
            System.out.println(message);
            // При последней итерации поток уснет и его некому будет разбудить
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
