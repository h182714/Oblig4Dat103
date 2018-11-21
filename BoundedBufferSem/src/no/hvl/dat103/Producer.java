package no.hvl.dat103;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
	private Semaphore full;
	private Semaphore tom;
	private Semaphore sem;
	private Buffer buffer;
	private Random random;

	public Producer(Semaphore full, Semaphore sem, Semaphore tom, Buffer buffer) {
		this.full = full;
		this.sem = sem;
		this.tom = tom;

		this.buffer = buffer;
		this.random = new Random();
	}

	@Override
	public void run() {
		while (true) {
			try {
				tom.acquire();
				sem.acquire();

				int value = random.nextInt(100);

				buffer.BufferAdd(value);
				System.out.println("Added: " + value);

				sem.release();
				full.release();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}