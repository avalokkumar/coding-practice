package array;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * <p>
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 * <p>
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 */

import tree.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * q - [0,0][1,0][0,1]
 * q -   // pop [0,0]
 * q -> [1,0][0,1]  -   match
 * q -> [0,1][1,1]  //pop[1,0]
 * q -> [0,1][1,1]  //match
 * q ->
 */
public class NumberOfIsland {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {

        if (grid.length == 0) {
            return 0;
        }
        int rLen = grid.length;
        int cLen = grid[0].length;
        int islandCount = 0;

        int[][] visited = new int[rLen][cLen];


        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {

                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    dfs(grid, visited, i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private static void dfs(char[][] grid, int[][] visited, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || visited[i][j] == 1) return;

        grid[i][j] = '0';
        visited[i][j] = 1;
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
    }


    public static int numIslands2(char[][] grid) {

        if (grid.length == 0) {
            return 0;
        }
        int rLen = grid.length;
        int cLen = grid[0].length;
        int islandCount = 0;

        int[][] visited = new int[rLen][cLen];


        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {

                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    bfs(grid, visited, i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private static void bfs(char[][] grid, int[][] visited, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = 1;

        while (!q.isEmpty()) {
            int[] rowCol = q.remove();
            int row = rowCol[0], col = rowCol[1];
            int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            for (int[] pos : directions) {
                int r = row + pos[0];
                int c = col + pos[1];
                int[] dir = new int[]{r, c};

                if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length
                        && grid[r][c] == '1' && visited[r][c] == 0) {

                    q.add(dir);
                    visited[r][c] = 1;
                }
            }
        }
    }
}
