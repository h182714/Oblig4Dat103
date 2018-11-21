package no.hvl.dat103;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Writer implements Runnable {
	private Semaphore write;
	private Buffer buffer;
	private Random random;

	public Writer(Semaphore write, Buffer buffer) {
		this.write = write;
		this.buffer = buffer;
		this.random = new Random();
	}

	@Override
	public void run() {
		while (true) {
			try {
				write.acquire();

				int tall = random.nextInt(100);
				buffer.BufferAdd(tall);

				System.out.println("Writer added value: " + tall);

				write.release();

				try {
					Thread.sleep(random.nextInt(100));

				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

