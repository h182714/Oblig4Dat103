package no.hvl.dat103;

public class  Main {

	public static void main(String[] args) {
		CustomSemaphore sem = new CustomSemaphore(1);
		CustomSemaphore write = new CustomSemaphore(1);

		Buffer buffer = new Buffer();

		Thread writer = new Thread(new Writer(write, buffer));
		Thread readers1 = new Thread(new Reader(sem, write, buffer, 1));
		Thread readers2 = new Thread(new Reader(sem, write, buffer, 2));

		writer.start();
		readers1.start();
		readers2.start();
	}
}
