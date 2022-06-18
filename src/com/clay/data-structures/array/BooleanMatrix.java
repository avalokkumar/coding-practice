package array;

/**
 * Given a boolean matrix mat[M][N] of size M X N, modify it such that
 * if a matrix cell mat[i][j] is 1 (or true) then make all the cells of
 * ith row and jth column as 1.
 *
 * */
public class BooleanMatrix {

    public static void main(String[] args) {
        int[][] a = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}};
        setMatrix(a);
        printMatrix(a);
    }

    private static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void setMatrix(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    setRow(arr, i);
                    setColumn(arr, j);
                }
            }
        }
    }

    private static void setColumn(int[][] arr, int jthIndex) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][jthIndex] = 1;
        }
    }

    private static void setRow(int[][] arr, int index) {
        for (int j = 0; j < arr[0].length; j++) {
            arr[index][j] = 1;
        }
    }
}
