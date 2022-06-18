package websites.hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class Solution3 {

	// Complete the catAndMouse function below.
	static String catAndMouse(int x, int y, int z) {

		int catADistance = Math.abs(x - z);
		int catBDistance = Math.abs(y - z);
		if (catADistance == catBDistance) {
			return "Mouse C";
		} else if (catADistance < catBDistance) {
			return "Cat A";
		} else {
			return "Cat B";
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int q = scanner.nextInt();

		for (int qItr = 0; qItr < q; qItr++) {

			int x = scanner.nextInt();

			int y = scanner.nextInt();

			int z = scanner.nextInt();

			String result = catAndMouse(x, y, z);
			System.out.println(result);
		}

		scanner.close();
	}
}
