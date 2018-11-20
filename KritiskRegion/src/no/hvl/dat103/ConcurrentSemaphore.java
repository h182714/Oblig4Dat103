package no.hvl.dat103;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ConcurrentSemaphore {

	public Semaphore sem;
	private List<Integer> list;

	public ConcurrentSemaphore(){
		sem = new Semaphore(1);
		list = new ArrayList<>();
		list.add(10);
	}

	public void KritiskRegion1(){
		try {
			sem.acquire();
			System.out.println("Legg til: " + 10);
			list.add(10);
			sem.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void KritiskRegion2(){
		try {
			sem.acquire();
			Integer tall= list.get(0);
			System.out.println("Ta vekk: " + tall);
			sem.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
