import java.util.Random;


public class Producer extends Thread {

	private Random rand = new Random();
	private CustomSemaphore full;
	private CustomSemaphore sem;
	private CustomSemaphore tom;
	private Buffer buffer;
	int bufferSize;

	public Producer(CustomSemaphore full, CustomSemaphore sem,CustomSemaphore tom, Buffer buffer) {
		this.full = full;
		this.sem = sem;
		this.tom = tom;
		this.buffer = buffer;
		bufferSize = tom.getTall() -1;

	}


	@Override
	public void run() {
		do {
			Integer ting = rand.nextInt(100);
			if(buffer.getBuffer().size() < bufferSize) {
				tom.vent();
				sem.vent();
				buffer.BufferAdd(ting);
				sem.signal();
				full.signal();
			}


			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}while (true);
	}
}