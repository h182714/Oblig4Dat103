package no.hvl.dat103;

import java.util.concurrent.Semaphore;

public class Fork {

	public Semaphore sem = new Semaphore(1);

	void grab() {
		try {
			sem.acquire();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	void release() {
		sem.release();
	}

}
