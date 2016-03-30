public class Consumer extends Thread {
	private Buffer buffer;

	private String name;

	private int waitingTime;

	public Consumer(Buffer buffer, String name, int waitingTime) {
		this.buffer = buffer;
		this.name = name;
		this.waitingTime = waitingTime;
	}

	public void run() {
		for (;;) {
			try {
				sleep(waitingTime);
			} catch (InterruptedException e) {
			}
			buffer.consume(name);
		}
	}
}
