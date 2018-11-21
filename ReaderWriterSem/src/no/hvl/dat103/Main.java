package no.hvl.dat103;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();
    Semaphore sem = new Semaphore(1);
    Semaphore write = new Semaphore(1);

    Thread writer = new Thread(new Writer(write, buffer));
    Thread reader1 = new Thread(new Reader(sem, write, buffer, 1));
    Thread reader2 = new Thread(new Reader(sem,write,buffer,2));

    writer.start();
    reader1.start();
    reader2.start();
}
}
