
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class CarQueue {
	Random randint;

	Queue<Integer> direction;

	public CarQueue() {
		randint = new Random();
		direction = new ArrayDeque<Integer>();
		direction.add(randint.nextInt(3));
		direction.add(randint.nextInt(3));
		direction.add(randint.nextInt(3));
		direction.add(randint.nextInt(3));
		direction.add(randint.nextInt(3));
		direction.add(randint.nextInt(3));

	}

	public void addToQueue() {

		class carq implements Runnable {

			@Override
			public void run() {
				while (true) {

					direction.add(randint.nextInt(3));
					try {
						Thread.sleep(200);
					}

					catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

			}

		}
		Runnable r = new carq();
		Thread t = new Thread(r);
		t.start();

	}

	public int deleteQueue() {
		return direction.remove();
	}
}
