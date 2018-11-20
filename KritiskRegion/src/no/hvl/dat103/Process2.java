package no.hvl.dat103;

public class Process2 implements Runnable{

	ConcurrentSemaphore cs;

	public Process2(ConcurrentSemaphore cs) {this.cs = cs;}

	@Override
	public void run() {
		while(true){
			cs.KritiskRegion2();
			synchronized(this) {
				try {
					this.wait(1000);
				}catch(InterruptedException e){

				}
			}
		}

	}
}
