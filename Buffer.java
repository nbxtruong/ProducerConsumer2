public class Buffer {
	private boolean isEmpty = true;

	private String buffer;

	public synchronized void produce(String buffer, String name) {
		while (!isEmpty) {
			System.out.println("Producer " + name + " waiting");
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Producer " + name + " produces " + buffer);
		this.buffer = buffer;
		isEmpty = false;
		notifyAll();
		// notify would be here sufficient because a producer and a consumer may
		// not wait in the same time.
	}

	public synchronized String consume(String name) {
		while (isEmpty) {
			System.out.println("Consumer " + name + " waiting");
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Consumer " + name + " consumes " + buffer);
		isEmpty = true;
		notifyAll(); // same remark.
		return buffer;
	}
}
