import java.util.Random;

public class Producer implements Runnable{

    private CustomSemaphore sem;
    private CustomSemaphore tom;
    private CustomSemaphore full;
    private Buffer buffer;
    private Random random;
;

    public Producer(CustomSemaphore sem, CustomSemaphore tom, CustomSemaphore full, Buffer buffer){
		this.full=full;
		this.sem=sem;
        this.tom=tom;

        this.buffer=buffer;
        this.random = new Random();
    }
	@Override
	public void run() {
		while (true) {
			tom.Wait();
			sem.Wait();

			int tall = random.nextInt(100);

			buffer.BufferAdd(tall);
			System.out.println("Added: " + tall);

			sem.Signal();
			full.Signal();
        }
    }
}
