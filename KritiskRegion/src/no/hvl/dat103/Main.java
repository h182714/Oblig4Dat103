package no.hvl.dat103;


public class Main {

	public static void main(String[] args) {

		ConcurrentSemaphore cs = new ConcurrentSemaphore();
		new Thread(new Process1(cs)).start();
		new Thread(new Process2(cs)).start();
			}
		}
