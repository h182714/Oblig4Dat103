package no.hvl.dat103;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Writer implements Runnable {
	private CustomSemaphore write;
	private Buffer buffer;
	private Random random;

	public Writer(CustomSemaphore write, Buffer buffer) {
		this.write = write;
		this.buffer = buffer;
		this.random = new Random();
	}

	@Override
	public void run() {
		while (true) {
			write.vent();

			int tall = random.nextInt(100);
			buffer.BufferAdd(tall);

			System.out.println("Writer added value: " + tall);

			write.signal();

			try {
				Thread.sleep(random.nextInt(100));

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

