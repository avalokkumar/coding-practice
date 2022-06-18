package websites.leetcode.problems;

public class ThirdMax {

	public static void main(String[] args) throws Exception {
		int[] a = { 1, 1, 3, 2, 3, 4, 4, 3, 2 };
		System.out.println(thirdMax(a));
	}

	private static int thirdMax(int[] a) {
		int x, y, z;
		x = y = z = a[0];

		for (int i = 1; i < a.length; i++) {

			if (a[i] > x) {
				z = y;
				y = x;
				x = a[i];

			} else if (a[i] > y && a[i] < x) {
				z = y;
				y = a[i];
			}
		}

		if (x > y && y > z) {
			return z;
		} else {
			return x;
		}
	}

}
