import java.io.File;

public class App {

	public static void main(String[] args) {

		// Optional: set to true to display the workings of the code as it runs.
		DisplayWorkings.displayWorkings(true);

		File file = new File("file.txt");
		long sum = Calculate.calculate(file);

		System.out.println("The sum of the numbers is: " + sum);
	}
}
