package no.hvl.dat103;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Semaphore full;
    private Semaphore tom;
    private Semaphore sem;
    private Buffer buffer;

    public Consumer(Semaphore full, Semaphore sem, Semaphore tom, Buffer buffer) {
        this.full = full;
        this.sem = sem;
        this.tom = tom;

        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                full.acquire();
                tom.acquire();

                Integer tall = buffer.BufferRemove();
                System.out.println("Removed: " + tall);

                sem.release();
                tom.release();

            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}