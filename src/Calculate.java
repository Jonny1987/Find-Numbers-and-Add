import java.io.File;
import java.util.ArrayList;

public class Calculate {

	public static long calculate(File file) {
		ArrayList<String> arrayWords = FindNumbers.findNumbers(file);
		long[] numbers = ConvertToNumbers.convertToNumbers(arrayWords);
		long sum = AddNumbers.addNumbers(numbers);

		return sum;

	}
}
