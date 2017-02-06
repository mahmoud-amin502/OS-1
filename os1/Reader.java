package OS3;

public class Reader implements Runnable {
	Semaphore semaphore;
	String name;

	public Reader(String name, Semaphore s) {
		semaphore = s;
		this.name = name;
	}
	
	@Override
	public void run() {
		semaphore.StartRead(name);
	}

}
