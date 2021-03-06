import static java.lang.Thread.sleep;

public class CustomSemaphore {

	private int tall;

	public CustomSemaphore(int tall) {
		this.tall = tall;
	}

	public void vent() {
		while (this.tall <= 0) {
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.tall--;
	}
	public void signal() {
		this.tall++;
	}

	public int getTall() {
		return this.tall;
	}
}