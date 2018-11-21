package no.hvl.dat103;

import java.util.concurrent.Semaphore;

public class Reader implements Runnable {

	private Semaphore sem;
	private Semaphore write;
	private Buffer buffer;
	private int id;

	public Reader(Semaphore sem, Semaphore write, Buffer buffer, int id) {
		this.sem = sem;
		this.write = write;
		this.buffer = buffer;
		this.id = id;
	}

	@Override
	public void run() {
		while(true) {
			try {
				sem.acquire();

				int readers = buffer.getReaders();

				buffer.setReaders(readers + 1);

				if(readers + 1 == 1) {
					write.acquire();
				}

				int tall = buffer.BufferRemove();
				System.out.println("Reader: " + id + " Read: " + tall);

				buffer.setReaders(readers);

				if(readers == 0) {
					write.release();
				}

				sem.release();

				try {
					Thread.sleep(200);

				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


