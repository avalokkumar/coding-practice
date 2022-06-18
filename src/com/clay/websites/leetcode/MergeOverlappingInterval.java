package websites.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * <p>
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeOverlappingInterval {

    public static void main(String[] args) {
//        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] intervals = new int[][]{{1, 4}, {5, 6}};
        int[][] intervals = new int[][]{{1, 4}, {0, 4}};

        int[][] overlappingIntervals = merge(intervals);

        for (int i=0; i< overlappingIntervals.length; i++) {
            for (int j=0; j < overlappingIntervals[0].length; j++) {
                System.out.print(overlappingIntervals[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static int[][] merge2(int[][] intervals) {

        if (intervals.length == 1) {
            return intervals;
        }
        List<int[]> output = new ArrayList<>();

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0]) {
                output.add(new int[]{intervals[i][0], intervals[i + 1][1]});
            } else {
                output.add(intervals[i]);
                output.add(new int[]{intervals[i+1][0], intervals[i + 1][1]});
            }
        }
        return output.toArray(new int[output.size()][]);
    }

    public static int[][] merge(int[][] intervals) {

        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> output = new ArrayList<>();
        int[] current = intervals[0];
        output.add(current);

        for (int[] interval: intervals) {
            if (current[1] >= interval[0]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                current = interval;
                output.add(current);
            }
        }
        return output.toArray(new int[output.size()][]);
    }
}
