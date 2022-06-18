package stringarrays;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column are set to O.
 */
public class Demo7 {

	private static void getUpdatedMatrix(int[][] arr) {
		int size = arr.length;
		int[][] buff = new int[arr.length][arr.length];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (arr[i][j] == 0) {
					buff[i][j] = 1;
				}
			}
		}
		setRowColZero(arr, buff);
	}

	private static void setRowColZero(int[][] arr, int[][] buff) {
		System.out.println();
		printMatrix(buff);
		for (int i = 0; i < buff.length; i++) {
			for (int j = 0; j < buff.length; j++) {
				if (buff[i][j] == 1) {
					setColZero(arr, j);
					setRowZero(arr, i);
				}
			}
		}
	}

	private static void setColZero(int[][] arr, int j) {

		for (int i = 0; i < arr.length; i++) {
			arr[i][j] = 0;
		}

	}

	private static void setRowZero(int[][] arr, int i) {

		for (int j = 0; j < arr.length; j++) {
			arr[i][j] = 0;
		}

	}

	private static void printMatrix(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] arr = { { 3, 4, 5, 0, 1, 3 }, { 0, 3, 4, 1, 3, 9 }, { 8, 7, 1, 3, 5, 2 }, { 9, 7, 6, 1, 2, 0 },
				{ 8, 1, 2, 4, 6, 7 }, { 9, 3, 3, 4, 6, 7 } };

		printMatrix(arr);

		getUpdatedMatrix(arr);
		System.out.println("\n");
		printMatrix(arr);
	}

}

/**
 * private static void getUpdatedMatrix(int[][] arr) { int size = arr.length;
 * int k = 0; int[][] buff = new int[arr.length][arr.length];
 * 
 * for (int i = 0; i < size; i++) { int reset = 0; for (int j = i; j < size;
 * j++) { if (arr[i][j] == 0 || arr[j][i] == 0) { reset = 1; k = j; break; } }
 * if (reset == 1) { for (int j = 0; j < size; j++) { arr[k][j] = arr[j][k] = 0;
 * } } } }
 */

/**
 * for (int i = 0; i < size; i++) { for (int j = 0; j < size; j++) { if
 * (arr[i][j] == 0) { setRowZero(arr, i); buff[i][j] = 1; } } }
 * 
 */
