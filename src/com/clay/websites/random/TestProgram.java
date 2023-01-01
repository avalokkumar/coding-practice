package websites.random;

import java.util.*;

public class TestProgram {

    public static void main(String[] args) {
        //find the second highest number from a list

        List<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 4, 6, 12, 33, 54, 38));
        values.sort(Comparator.naturalOrder());

        System.out.println(values.get(values.size() - 2));

        Optional<Integer> maxVal = values.stream().max(Comparator.naturalOrder());
        System.out.println(maxVal.get());

        System.out.println("findSecondMax");
        System.out.println(findSecondMax(new int[]{19, 19, 18, 19, 18, 18, 122, 11}));

    }

    public static int findSecondMax(int[] val) {

        if (val == null || val.length <= 1) {
            return 0;
        }

        if (val.length == 2 && val[0] != val[1]) {
            return Math.min(val[0], val[1]);
        }

        //int[]{12, 12}
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;

        for (int i = 0; i < val.length; i++) {
            if (val[i] > max) {
                secMax = max;
                max = val[i];
            } else if (val[i] > secMax && val[i] != max) {
                secMax = val[i];
            }
        }
        return secMax;
    }
}
