package stringarrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * 4 6 5 3 3 1
 */
class Result {

	public static int pickingNumbers(List<Integer> arr) {

		int max = 0;
		int c = 0;
		for (int k = 0; k < arr.size(); k++) {
			int curr = arr.get(k);
			for (int j = 0; j < arr.size(); j++) {
				if (curr == arr.get(j) || curr == arr.get(j) + 1) {
					c++;
				}
			}
			if (c > max) {
				max = c;
			}
			c = 0;

		}

		return max;
	}

}

public class Demo9 {
	public static void main(String[] args) {

		Scanner s1 = new Scanner(System.in);

		int n = s1.nextInt();

		List<Integer> aTemp = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int temp = s1.nextInt();
			aTemp.add(temp);
		}

		int result = Result.pickingNumbers(aTemp);
		System.out.println(result);
		s1.close();
	}
}
