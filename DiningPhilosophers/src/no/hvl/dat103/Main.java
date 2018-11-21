package no.hvl.dat103;


public class Main {

	public static void main(String[] args) {

		CustomSemaphore sem1 = new CustomSemaphore(1);
		CustomSemaphore sem2 = new CustomSemaphore(1);
		CustomSemaphore sem3 = new CustomSemaphore(1);
		CustomSemaphore sem4 = new CustomSemaphore(1);
		CustomSemaphore sem5 = new CustomSemaphore(1);

		CustomSemaphore[] chopsticks = { sem1, sem2, sem3, sem4, sem5 };

		Thread thread1 = new Thread(new Philosophers(chopsticks, 1));
		Thread thread2 = new Thread(new Philosophers(chopsticks, 2));
		Thread thread3 = new Thread(new Philosophers(chopsticks, 3));
		Thread thread4 = new Thread(new Philosophers(chopsticks, 4));
		Thread thread5 = new Thread(new Philosophers(chopsticks, 5));

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}
}
