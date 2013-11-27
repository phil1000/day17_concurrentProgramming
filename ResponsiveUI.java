public class ResponsiveUI implements Runnable {

	private Counter taskNo;
	public ResponsiveUI(Counter counter) {
		this.taskNo = counter;
	}
	
	public void run() {
		// this is where the logic to be threaded goes
		System.out.println("Finished task " + taskNo.getCount());
	}
	
	public static void main(String[] args) {
		Counter counter = new Counter();
		for (int i=0;i<10;i++) {
			System.out.println("Enter the duration (in ms) of task " + i);
			String duration = System.console().readLine();
			Runnable r = new ResponsiveUI(counter);
			Thread t = new Thread(r);
			t.start();
			counter.increase();
		}
	}
}