public class TestProducerConsumer {

	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		new Producer(buffer, "p1", 500).start();
		new Producer(buffer, "p2", 1000).start();
		new Consumer(buffer, "c1", 800).start();
		new Consumer(buffer, "c2", 2000).start();
	}
}
