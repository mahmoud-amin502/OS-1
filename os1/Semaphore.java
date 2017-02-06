package OS3;

public class Semaphore {

	String str = "";
	int numofResders;
	boolean writing;

	public Semaphore(String buf) {
		str = buf;
		numofResders = 0;
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

		numofResders++;
		System.out.println("Resder  " + name + "  start read  " + str + "\n");
		try {
			this.wait(2000);// Wait till be notified or timeout milliseconds
							// elapses
		} catch (InterruptedException e) {
			System.out.println("Interrupted Exception in wait ");
		}

		System.out.println("Reader  " + name + "  is Finshed\n ");
		numofResders--;
		notifyAll();
	}

	public synchronized void StartWrite(String name, String word) {

		while (writing == true || numofResders > 0) {
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
