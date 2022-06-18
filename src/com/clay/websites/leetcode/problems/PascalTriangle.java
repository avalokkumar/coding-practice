package websites.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {
	private static Scanner scanner = new Scanner(System.in);

	private static List<Integer> getPascalTriangle(int k) {

		if (k == 0) {
			return Arrays.asList(1);
		} else if (k == 1) {
			return Arrays.asList(1, 1);
		} else if (k == 2) {
			return Arrays.asList(1, 2, 1);
		}

		List<Integer> pascalTValues = new ArrayList<>();
		pascalTValues.add(2);
		k -= 2;

		while (k-- > 0) {
			int p = 1, c;
			//int i = 0;
			for (int i = 0; i < pascalTValues.size(); i++) {
				c = pascalTValues.get(i);
				pascalTValues.set(i, p+c);
				p=c;
			}
			pascalTValues.add(p+1);
		}
		pascalTValues.add(0, 1);
		pascalTValues.add(1);
		return pascalTValues;
	}

	public static void main(String[] args) {

		int k = scanner.nextInt();

		for (Integer val : getPascalTriangle(k)) {
			System.out.println(val);
		}
	}

}
