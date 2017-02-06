package os1;

public class reader implements Runnable {
	semaphore semaphore;
	String name;

	public reader(String name, semaphore s) {
		semaphore = s;
		this.name = name;
	}
	
	@Override
	public void run() {
		semaphore.StartRead(name);
	}

}

