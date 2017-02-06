package os1;

public class writer implements Runnable {
	
	semaphore semaphore;
	String name;
	String word;
	
	public writer(semaphore s,String name,String word) {
		semaphore=s;
		this.name=name;
		this.word=word;
	}

	@Override
	public void run() {
	semaphore.StartWrite(name, word);
		
	}

}

