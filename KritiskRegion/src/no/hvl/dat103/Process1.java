package no.hvl.dat103;


public class Process1 implements Runnable {

	ConcurrentSemaphore cs;

	public Process1(ConcurrentSemaphore cs) { this.cs = cs; }

	@Override

	public void run()  {
		while(true) {
			cs.KritiskRegion1();
			synchronized(this) {
				try{
					this.wait(900);
				}catch(InterruptedException e){

				}
			}
		}
	}
}
