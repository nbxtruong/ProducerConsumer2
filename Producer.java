public class Producer extends Thread {
	private Buffer buffer;

	private String name;

	private int waitingTime;

	public Producer(Buffer buffer, String name, int waitingTime) {
		this.buffer = buffer;
		this.name = name;
		this.waitingTime = waitingTime;
	}

	public void run() {
		int i = 0;
		for (;;) {
			buffer.produce("message" + i++ + " from " + name, name);
			try {
				sleep(waitingTime);
			} catch (InterruptedException e) {
			}
		}
	}
}