package no.hvl.dat103;

class Main {

	public static void main(String[] args) {

		Philosophers[] philosophers = new Philosophers[5];
		Fork[] fork = new Fork[philosophers.length];

		for (int c = 0; c < philosophers.length; c++) {
			fork[c] = new Fork();
		}

		for (int c = 0; c < philosophers.length; c++) {

			if (c % 2 == 0) {
				philosophers[c] = new Philosophers(c, fork[(c + 1) % fork.length], fork[c]);
				philosophers[c].start();

			} else {
				philosophers[c] = new Philosophers(c, fork[c], fork[(c + 1) % fork.length]);
				philosophers[c].start();
			}
		}
	}

}