package no.hvl.dat103;


public class CustomSemaphore {

	private int tall;

	public CustomSemaphore(int tall) {
		this.tall = tall;
	}

	public void vent() {
		while (this.tall <= 0) {
			Thread.yield();
		}
		this.tall--;
	}
	public void signal() {
		this.tall++;
	}

}