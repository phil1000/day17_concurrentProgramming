import java.util.Random;

public class SelfOrderingList {
	
	public void launch() {
		IntegerArray myArray = new IntegerArray();
		Random randomGenerator = new Random();
		for (int i=0;i<30;i++) {
			int randomInt = randomGenerator.nextInt(500);
			myArray.add(randomInt);
		}
		myArray.printArray();
		myArray.sort();
		myArray.printArray();
	}
	
	public static void main(String[] args) {
		SelfOrderingList script = new SelfOrderingList();
		script.launch();
	}
}