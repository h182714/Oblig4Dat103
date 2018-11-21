import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

    CustomSemaphore s = new CustomSemaphore(1);
    CustomSemaphore full = new CustomSemaphore(0);
    CustomSemaphore tom = new CustomSemaphore(10);

    Buffer buffer =new Buffer();
    Thread consumer = new Thread(new Consumer(s, full, tom, buffer));
    Thread producer = new Thread(new Producer(s, full, tom, buffer));

    producer.run();
    consumer.run();
}
}
