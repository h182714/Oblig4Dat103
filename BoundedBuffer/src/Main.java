import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        int size = 5;
        Buffer buffer = new Buffer(size);
    CustomSemaphore sem = new CustomSemaphore(1);
    CustomSemaphore full = new CustomSemaphore(0);
    CustomSemaphore tom = new CustomSemaphore(size);

    Thread consumer = new Thread(new Consumer(sem, full, tom, buffer));
    Thread producer = new Thread(new Producer(sem, full, tom, buffer));

    consumer.start();
    producer.start();
}
}
