public class ResponsiveUI implements Runnable {

	private long duration;
	public ResponsiveUI(long duration) {
		this.duration = duration;
	}
	
	public void run() {
		// this is where the logic to be threaded goes
		Thread.sleep(this.duration);
		System.out.println("Finished task " + this.duration);
	}
	
	public static void main(String[] args) {
		for (int i=0;i<10;i++) {
			System.out.println("Enter the duration (in ms) of task " + i);
			Long duration = Long.parseLong(System.console().readLine());
			Runnable r = new ResponsiveUI(duration);
			Thread t = new Thread(r);
			t.start();
		}
	}
}