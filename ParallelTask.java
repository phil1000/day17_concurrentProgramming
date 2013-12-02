import java.util.*;

public class ParallelTask implements Runnable {

	private int duration;
	private int id;
	private boolean resultReady = false;
	private ResponsiveUI callerID=null;
	
	public ParallelTask(int id, int duration, ResponsiveUI callerID) {
		this.callerID=callerID;
		this.duration=duration;
		this.id = id;
	}
	
    /**
     * Runs the computation.
     */
    public void run() {		

		try {
			Thread.sleep(this.duration); // sleep 1000ms = 1 second
		} catch (InterruptedException ex) {
			// Nothing to do in this case, just sleep less...
		}
		callerID.reportComplete(this.id);
	}

}