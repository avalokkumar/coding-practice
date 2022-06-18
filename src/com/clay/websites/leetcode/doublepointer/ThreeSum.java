package websites.leetcode.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    private static List<List<Integer>> printTripletSumIndex(int[] numbers) {
        List<List<Integer>> tripletSum = new ArrayList<>();

        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i == 0 || (numbers[i] != numbers[i - 1])) {
                int low = i + 1;
                int high = numbers.length - 1;
                int sum = -numbers[i];

                while (low < high) {
                    if (numbers[low] + numbers[high] == sum) {
                        tripletSum.add(Arrays.asList(numbers[i], numbers[low], numbers[high]));
                        while (low < high && numbers[low] == numbers[low + 1]) {
                            low++;
                        }
                        while (low < high && numbers[high] == numbers[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (numbers[low] + numbers[high] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return tripletSum;
    }

    public static void main(String[] args) {

        int[] numbers = new int[]{2, 1, 11, 7};
        List<List<Integer>> vals = printTripletSumIndex(numbers);
        for (List<Integer> valList: vals) {
            for (Integer val: valList) {
                System.out.println(val);
            }
        }
    }
}
