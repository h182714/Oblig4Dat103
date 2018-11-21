import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();
        CustomSemaphore full = new CustomSemaphore(0);
        CustomSemaphore sem = new CustomSemaphore(1);
        CustomSemaphore tom = new CustomSemaphore(10);

        Thread consumer = new Thread(new Consumer(full, sem, tom, buffer));
        Thread producer = new Thread(new Producer(full, sem, tom, buffer));

        producer.start();
        consumer.start();
    }
}