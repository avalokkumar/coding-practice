package websites.geeksforgeeks.array;

/**
 * Input : arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1}
 * Output : [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]
 */
public class RearrangeArray {

    public static void main(String[] args) {
        int[] res = rearrange(new int[]{-1, -1, 6, 1, 9, 3, 2, -1, 4, -1});

        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    private static int[] rearrange(int[] values) {

        for (int i = 0; i < values.length; i++) {
            if (values[i] != -1 && values[i] != i) {
                int temp = values[values[i]];
                values[values[i]] = values[i];
                values[i] = temp;
            }
        }
        return values;
    }
}
