package no.hvl.dat103;

public class Philosophers extends Thread{

	private CustomSemaphore[] chopsticks;
	private int c;

	public Philosophers(CustomSemaphore[] chopsticks, int c){
		this.c = c;
		this.chopsticks = chopsticks;
	}
	@Override
	public void run(){
		do {
			chopsticks[c].vent();
			chopsticks[(c + 1) % 5].vent();
			System.out.println("Philosopher: " + c + " Start Eating");

			try{
				sleep(200);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Philosopher: " + c + " Stops Eating ");
			chopsticks[c].signal();
			chopsticks[(c + 1) % 5].signal();
			System.out.println("Philisopher: " + c + " Start Thinking");
			try{
				sleep(200);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("Philosopher: " + c + " Stop Thinking");
		}while(true);

	}

}
