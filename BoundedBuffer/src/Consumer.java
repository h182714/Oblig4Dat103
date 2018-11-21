

public class Consumer extends Thread {

    private CustomSemaphore full;
    private CustomSemaphore sem;
    private CustomSemaphore tom;
    private Buffer buffer;

    public Consumer(CustomSemaphore full, CustomSemaphore sem, CustomSemaphore tom, Buffer buffer) {
        this.full = full;
        this.sem = sem;
        this.tom = tom;
        this.buffer = buffer;
    }

    @Override
    public void run() {

        while (true) {


            full.vent();
            sem.vent();
            Integer tall = buffer.BufferRemove();
            System.out.println("Remove: " + tall);
            sem.signal();
            tom.signal();

        }

    }

}