package datastructures.graph;

import java.util.*;

public class PacificAtlantic {

    public static void main(String[] args) {
        int[][] heights = new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};

        for (List<Integer> res : pacificAtlantic(heights)) {
            System.out.println(res);
        }
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights.length == 0) {
            return Collections.emptyList();
        }

        int ROW = heights.length;
        int COL = heights[0].length;

        boolean[][] pac = new boolean[ROW][COL];
        boolean[][] atl = new boolean[ROW][COL];


        for (int i = 0; i < COL; i++) {
            dfs(heights, 0, i, pac, heights[0][i]);
            dfs(heights, ROW - 1, i, atl, heights[ROW - 1][i]);
        }

        for (int i = 0; i < ROW; i++) {
            dfs(heights, i, 0, pac, heights[i][0]);
            dfs(heights, i, COL - 1, atl, heights[i][COL - 1]);
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (pac[i][j] && atl[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private static void dfs(int[][] heights, int row, int col, boolean[][] ocean, int prevHeight) {

        if (row < 0 || col < 0
                || row == heights.length || col == heights[0].length
                || ocean[row][col]
                || heights[row][col] < prevHeight) {
            return;
        }

        ocean[row][col] = true;

        dfs(heights, row + 1, col, ocean, heights[row][col]);
        dfs(heights, row - 1, col, ocean, heights[row][col]);
        dfs(heights, row, col + 1, ocean, heights[row][col]);
        dfs(heights, row, col - 1, ocean, heights[row][col]);
    }
}
