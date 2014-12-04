import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ConvertToNumbers {

	private static HashMap<String, Long> stringToLong = StringToLong
			.getStringToInt();

	public static boolean displayWorkings = false;

	/*
	 * Takes an array of number phrases and: (1) goes through each phrase in
	 * turn. (2) For each phrase it scans each word in turn in the phrase and
	 * converts it to a number using the hashmap 'stringToInt'. (3)Performs an
	 * algorithm. For each number that is converted from a word in the phrase,
	 * it does a different action depending on the value of the number and the
	 * current contents of that array element. (4)When it gets to the end of
	 * that phrase, it adds all the elements of the 'values[]' array and puts
	 * this sum into an element of the 'numbers[]' array. It then resets the
	 * 'values[]' array and moves on to the next element in 'numbers[]' ready
	 * for the next phrases sum.
	 */
	public static long[] convertToNumbers(ArrayList<String> arrayWords) {

		long[] numbers = new long[arrayWords.size()];

		// (1)
		if (displayWorkings) {
			System.out.println("Inner working of the algorithm: \n");
		}

		for (int i = 0; i < arrayWords.size(); i++) {

			if (displayWorkings) {
				System.out.println("\n" + arrayWords.get(i) + ":");
			}

			try (Scanner scanner = new Scanner(arrayWords.get(i))) {
				long[] value = new long[5];

				// (2)
				String word;
				long smallNumber;
				int element = 0;
				while (scanner.hasNext()) {
					word = scanner.next();
					smallNumber = stringToLong.get(word);

					// (3)
					if (smallNumber < 100) {
						value[element] += smallNumber;

						if (displayWorkings) {
							System.out.println("value[" + element + "] +"
									+ smallNumber + " = " + value[element]);
						}

					} else if (smallNumber == 100) {

						if (value[element] != 0) {
							value[element] *= smallNumber;
						} else {
							value[element] = smallNumber;
						}

						if (displayWorkings) {
							System.out.println("value[" + element + "] *"
									+ smallNumber + " = " + value[element]);
						}

					} else {

						if (value[element] != 0) {
							value[element] *= smallNumber;
						} else {
							value[element] = smallNumber;
						}

						if (displayWorkings) {
							System.out.println("value[" + element + "] *"
									+ smallNumber + " = " + value[element]);

							element++;
						}

					}
				}

				// (4)
				for (int j = 0; j < value.length; j++) {
					numbers[i] += value[j];
					value[j] = 0;
				}
			}

		}

		if (displayWorkings) {
			DisplayWorkings.displayArrayNumbers(numbers);
		}
		return numbers;
	}
}