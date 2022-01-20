package ru.oskin_di.homework_3.task_1;

public class ThreadPong implements Runnable {

    private final Printer printer;

    public ThreadPong(Printer printer) {
        this.printer = printer;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            printer.print("Pong");
        }
    }
}
