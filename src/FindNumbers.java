import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FindNumbers {

	private static HashMap<String, Long> stringToLong = StringToLong
			.getStringToInt();

	public static boolean displayWorkings = false;

	/*
	 * (1)Looks at each word in the file and (2)ignores it if it is an "and"
	 * (required for algorith to work). (3) If it is a number (in the
	 * arrayNumInWords array) then adds it to the String variable temp. (4) When
	 * it find the next nonnumber word it then adds the contents of temp, which
	 * will be a phrase made up of number words, to the array 'arrayWords'.
	 * String variable temp is then reset.
	 */
	public static ArrayList<String> findNumbers(File file) {
		ArrayList<String> arrayWords = new ArrayList<String>();

		try (Scanner scanner = new Scanner(file)) {

			scanner.useDelimiter("[^A-Za-z]+"); // Use any non letter characters
			// to separate words

			StringBuilder temp = new StringBuilder();
			boolean isNumber = false;

			if (displayWorkings) {
				System.out
						.println("Words after seperating, removing making lower case, "
								+ "and removing instances of 'and' :\n");
			}

			// (1)
			while (scanner.hasNext()) {

				isNumber = false;
				String word = scanner.next().toLowerCase();

				// (2)
				if (!word.equals("and")) {

					if (displayWorkings) {
						System.out.println(word);
					}
					// (3)
					if (stringToLong.containsKey(word)) {
						temp.append(word + " ");
						isNumber = true;
					}

					// (4)
					if (!isNumber && (temp.length() != 0)) {
						arrayWords.add(temp.toString());
						temp.setLength(0);
					}
				}
			}

			if (displayWorkings) {
				System.out
						.println("*************************************************");
				DisplayWorkings.displayArrayWords(arrayWords);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

		return arrayWords;
	}
}
