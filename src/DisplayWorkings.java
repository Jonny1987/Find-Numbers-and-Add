import java.util.ArrayList;

public class DisplayWorkings {

	// This method changes the corresponding 'displayWorking' booleans in the
	// other methods if given a 'true' argument.
	public static void displayWorkings(boolean display) {
		if (display) {
			ConvertToNumbers.displayWorkings = true;
			FindNumbers.displayWorkings = true;
		}
	}

	public static void displayArrayWords(ArrayList<String> arrayWords) {

		System.out.println("*********************************************");
		System.out.println("arrayWords contents: \n");
		for (int i = 0; i < arrayWords.size(); i++) {
			System.out.println("arrayWords.get(" + i + "): "
					+ arrayWords.get(i));
		}
		System.out.println("*********************************************");
	}

	public static void displayArrayNumbers(long[] numbers) {

		System.out.println("numbers[] contents: ");
		for (int i = 0; i < numbers.length; i++) {
			System.out.println("numbers[" + i + "]: " + numbers[i]);
		}
		System.out.println("*********************************************");

	}
}
