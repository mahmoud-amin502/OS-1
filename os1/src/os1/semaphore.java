package os1;

public class semaphore {

	String str = "";
	int numofreaders;
	boolean writing;

	public semaphore(String buf) { //constructor to initialize the variables
		str = buf;
		numofreaders = 0;
		writing = false;
	}

	public synchronized void StartRead(String name) {

		while (writing == true) {
			System.out.println("Reader  " + name + "  is Bloked \n");
			try {
				this.wait();
			} catch (InterruptedException e) {
				System.out.println("Interrupted Exception in wait ");
			}
		}
		numofreaders++;
		System.out.println("Resder  " + name + "  start read  " + str + "\n");
		try {
			this.wait(2000);// Wait till be notified or timeout milliseconds
							// elapses
		} catch (InterruptedException e) {
			System.out.println("Interrupted Exception in wait ");
		}

		System.out.println("Reader  " + name + "  is Finshed\n ");
		numofreaders--;
		notifyAll(); // wakes up all threads that are waiting on this object's monitor. A thread waits on an object's monitor by calling one of the wait methods.
	}
	
	
	
	
	
	
	
	

	public synchronized void StartWrite(String name, String word) {

		while (writing == true || numofreaders > 0) {
			System.out.println("Wirter  " + name + "  is Bloked \n");
			try {
				this.wait();
			} catch (InterruptedException e) {
				System.out.println("Interrupted Exception in wait ");
			}
		}

		writing = true;
		str += word;
		System.out.println("Wirter  " + name + "  start write  " + str + "\n");
		try {
			this.wait(2000);// Wait till be notified or timeout milliseconds
							// elapses
		} catch (InterruptedException e) {
			System.out.println("Interrupted Exception in wait ");
		}

		System.out.println("Wirter  " + name + "  is Finshed\n ");
		writing = false;
		notifyAll();
	}
}