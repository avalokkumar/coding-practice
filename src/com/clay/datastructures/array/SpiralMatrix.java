package datastructures.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {

       /*int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
//                {13, 14, 15, 16}
        };*/

       /* int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };*/

        int[][] matrix = new int[][]{
                {1, 2},
                {3, 4}
        };

        cycleInMatrix(matrix);
    }

    private static List<Integer> cycleInMatrix(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return Collections.emptyList();
        }

        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;

        while (left <= right || top <= bottom) {

            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
                System.out.print(matrix[top][i] + " ");
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
                System.out.print(matrix[i][right] + " ");
            }
            right--;
            if (left > right || top > bottom) {
                break;
            }
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
                System.out.print(matrix[bottom][i] + " ");
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
                System.out.print(matrix[i][left] + " ");
            }
            left++;
        }
        return result;
    }
    /*private static void cycleInMatrix(int[][] matrix) {
        int i = 0, j = 0;
        int n = matrix.length;
        while (i < j) {
            for (;j<matrix[i].length;j++) {
                System.out.println(matrix[i][j]);
            }
            i++;
            j--;
            for (;i<matrix[j].length;i++) {
                System.out.println(matrix[i][j]);
            }

            j--;
            i--;
            for (;j>=0;j--) {
                System.out.println(matrix[i][j]);
            }

            j++;
            i--;

            for (;i>0;i--) {
                System.out.println(matrix[i][j]);
            }
            i++;
            j++;
        }
    }*/
}
