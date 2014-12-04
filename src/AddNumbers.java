public class AddNumbers {

	// Takes an array of numbers
	public static long addNumbers(long[] numbers) {
		long sum = 0;

		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}

		return sum;
	}

}
