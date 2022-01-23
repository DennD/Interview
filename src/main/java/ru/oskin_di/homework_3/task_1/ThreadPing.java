package ru.oskin_di.homework_3.task_1;

public class ThreadPing implements Runnable{

    private final Printer printer;

    public ThreadPing(Printer printer) {
        this.printer = printer;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true){
            printer.print("Ping");
        }
    }
}
