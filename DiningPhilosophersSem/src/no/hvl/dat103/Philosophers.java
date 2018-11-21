package no.hvl.dat103;

public class Philosophers extends Thread {

	public int tall;
	public Fork LfFork;
	public Fork RtFork;

	public Philosophers(int tall, Fork left, Fork right) {
		this.tall = tall;
		this.LfFork = left;
		this.RtFork = right;
	}

	public void run() {
		while(true) {
			LfFork.grab();
			System.out.println("Philosopher: " + tall + " Grabs Left Fork");

			RtFork.grab();
			System.out.println("Philosopher: " + tall + " Grabs Right Fork");

			eat();

			LfFork.release();
			System.out.println("Philosopher: " + tall + " Release Left Fork");

			RtFork.release();
			System.out.println("Philosopher: " + tall + " Release Right Fork");
		}
	}
	public void eat(){
		try{
			System.out.println("Philosopher: " + (tall+1) + " Starts Eating");
			sleep(200);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

