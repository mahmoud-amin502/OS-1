package OS3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Scanner in;

	public static void main(String[] args) {
		int numofReader = 0, numofWriter = 0;
		String buffer = "";
		Semaphore semaphore;

		in = new Scanner(System.in);
		System.out.print("Initial Buffer contents :");
		buffer = in.nextLine();
		semaphore=new Semaphore(buffer);
		ArrayList<Thread> Array=new ArrayList<>();

		System.out.println("Enter Number Of Reader :");
		numofReader = in.nextInt();
		in.nextLine();

		for (int i = 0; i < numofReader; i++) {
			System.out.println("Reader Number : " + (i + 1) );
			System.out.println("  Enter Name : ");
			String name = in.nextLine();
			Reader reader=new Reader(name, semaphore);
			Array.add(new Thread(reader));
		}

		System.out.println("Enter Number Of Writer :");
		numofWriter = in.nextInt();
		in.nextLine();

		for (int i = 0; i < numofWriter; i++) {
			System.out.println("Writer Number : " + (i + 1));
			System.out.println("Enter Name : ");
			String name = in.nextLine();
			System.out.println("Words : ");
			String words = in.nextLine();
			Writer writer=new Writer(semaphore, name, words);
			Array.add(new Thread(writer));
		}
		
		for(int i=0;i<Array.size();i++){
			Array.get(i).start();
		}

	}

}
