package OS3;

public class Writer implements Runnable {
	
	Semaphore semaphore;
	String name;
	String word;
	
	public Writer(Semaphore s,String name,String word) {
		semaphore=s;
		this.name=name;
		this.word=word;
	}

	@Override
	public void run() {
	semaphore.StartWrite(name, word);
		
	}

}
