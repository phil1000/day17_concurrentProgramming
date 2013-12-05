import java.util.*;

public class ResponsiveUI {

	private String output="Finished tasks ";
	private ParallelTask p1 = null;
	
	public void launch() {
		for (int i=0; i<10;i++) {
			System.out.println("Enter the duration (in ms) of task " + i);
			int duration = Integer.parseInt(System.console().readLine());
			p1 = new ParallelTask(i+1,duration,this);	
			Thread t1 = new Thread(p1);
			t1.start();
			checkForCompleteTasks();
		}
	}
	
	public void reportComplete(int id) {
		output=output+id+" ";
	}
	
	public void checkForCompleteTasks() {
		System.out.println(output);
		output="Finished tasks ";
		
	}
		
	public static void main(String[] args) {
		ResponsiveUI script = new ResponsiveUI();
		script.launch();
	}
}