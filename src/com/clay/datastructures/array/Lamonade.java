package datastructures.array;

public class Lamonade {

    public static void main(String[] args) {
//        int[] input = new int[]{5, 5, 5, 10, 20};
        int[] input = new int[]{5, 5, 10, 10, 20};

        System.out.println(lemonadeChange(input));
    }

    public static boolean lemonadeChange(int[] bills) {
        int[] currencyCount = new int[3];

        for (int val : bills) {
            if (val == 5) {
                currencyCount[0]++;
                continue;
            }
            if (val == 10) {
                if (currencyCount[0] <= 0) {
                    return false;
                }
                currencyCount[0]--;
                currencyCount[1]++;
                continue;
            }

            if (val == 20) {
                if (currencyCount[0] < 1 || (currencyCount[0] < 3 && currencyCount[1] == 0)) {
                    return false;
                }

                if (currencyCount[1] > 0) {
                    currencyCount[0]--;
                    currencyCount[1]--;
                } else {
                    currencyCount[0] -= 3;
                }
            }
        }

        return true;
    }
}
