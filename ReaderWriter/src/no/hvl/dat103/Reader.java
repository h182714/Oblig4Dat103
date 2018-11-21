package no.hvl.dat103;

public class Reader implements Runnable {
	private CustomSemaphore sem;
	private CustomSemaphore write;
	private Buffer buffer;
	private int id;

	public Reader(CustomSemaphore sem, CustomSemaphore write, Buffer buffer, int id) {
		this.sem = sem;
		this.write = write;
		this.buffer = buffer;
		this.id = id;
	}
	@Override
	public void run() {
		while (true) {
			sem.vent();

			int readers = buffer.getReaders();

			buffer.setReaders(readers + 1);

			if (readers + 1 == 1) {
				write.vent();
			}

			int tall = buffer.BufferRemove();
			System.out.println("Reader: " + id + " Read: " + tall);

			buffer.setReaders(readers);

			if (readers == 0) {
				write.signal();
			}

			sem.signal();

			try {
				Thread.sleep(200);

			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
