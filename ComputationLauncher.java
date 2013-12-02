/**
 * This class launched two heavy computations
 * sequentially first, then in parallel. 
 * Assuming there is more than one processor in 
 * the machine, parallel computations finish
 * earlier.
 */
public class ComputationLauncher {   
    /**
     * How many numbers to process? If too low, there is no noticeable
     * difference.
     */
     public static final int COUNT = 40000000;

    /*
     * The computations to be performed. Stored as fields so 
     * both methods (sequential and parallel) act on exactly 
     * the same data
     */
    private Computation c1 = null;
    private Computation c2 = null;
	private Computation c3 = null; // phil's added code - this computer has 4 processors and so 
	private Computation c4 = null; // I increased the number of computations to 4 - should get bigger parallel processing benefits

    /**
     * The main method that launches the computations
     *
     * @param args command-line arguments, ignored
     */
    public static void main(String args[]) {
	  ComputationLauncher c = new ComputationLauncher();
	  c.launch();
    }
   
    private double[] createArray(int size) {
	  double[] result = new double[size];
	  for (int i = 0; i < result.length; i++) 
		{
		    result[i] = Math.random();
		}
	  return result;
    }
   
    private void launch() {
	  // Uncomment the following line to know how many processors your machine has
	  System.out.println("#CPU: " + Runtime.getRuntime().availableProcessors());
	  long start, stop;
	  c1 = new Computation(createArray(COUNT/2));
	  c2 = new Computation(createArray(COUNT/2));	
	  c3 = new Computation(createArray(COUNT/2)); //phil's added code
	  c4 = new Computation(createArray(COUNT/2)); //phil's added code
	  start = System.currentTimeMillis();
	  sequentialComputations();
	  stop = System.currentTimeMillis();
	  System.out.println("Time without threads: " + (stop - start) + "ms");
	  start = System.currentTimeMillis();
	  parallelComputations();
	  stop = System.currentTimeMillis();
	  System.out.println("Time with threads: " + (stop - start) + "ms");
    }
   
    private void sequentialComputations() {
	  c1.run();
	  c2.run();
	  c3.run(); // Phil added 2 more run statements
	  c4.run(); // for c3 and c4
	  double result1 = c1.getResult();
	  double result2 = c2.getResult();
	  double result3 = c3.getResult(); // calc the additional time taken
	  double result4 = c4.getResult(); // for c3 and c4 and out to the printed output below
	  System.out.println("Result: " + (result1 + result2 + result3 + result4));
    }
   
    private void parallelComputations() {
		//phil added c3 and c4 to this method - we should see greater savings here over
		// the sequential method as more processors can be used in parallel (there are 4 cores in this machine)
	  Thread t1 = new Thread(c1);
	  t1.start();
	  Thread t2 = new Thread(c2);
	  t2.start();
	  Thread t3 = new Thread(c3);
	  t3.start();
	  Thread t4 = new Thread(c4);
	  t4.start();
	  double result1 = c1.getResult();
	  double result2 = c2.getResult();
	  double result3 = c3.getResult();
	  double result4 = c4.getResult();
	  System.out.println("Result: " + (result1 + result2 + result3 + result4));
    }
}