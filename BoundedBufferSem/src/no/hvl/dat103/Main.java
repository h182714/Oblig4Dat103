package no.hvl.dat103;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        int size = 5;
        Buffer buffer = new Buffer(size);
    Semaphore sem = new Semaphore(1);
    Semaphore full = new Semaphore(0);
    Semaphore tom = new Semaphore(size);

    Thread consumer = new Thread(new Consumer(sem, full, tom, buffer));
    Thread producer = new Thread(new Producer(sem, full, tom, buffer));

    consumer.start();
    producer.start();
}
}
