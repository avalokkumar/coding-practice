package algods;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinanArray {

	public static List<Integer> findDuplicates(int[] arr) {
		List<Integer> duplicates = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			int index = Math.abs(arr[i]) - 1;

			if (arr[index] < 0) {
				duplicates.add(index + 1);
			}

			arr[index] *= -1;
		}
		return duplicates;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 2, 5, 4, 4, 6 };

		for (int i : findDuplicates(arr)) {
			System.out.println(i);
		}

	}
}
