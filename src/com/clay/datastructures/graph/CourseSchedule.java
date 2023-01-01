package datastructures.graph;

import java.util.*;

/**
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * <p>
 * Example 2:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
public class CourseSchedule {

    public static void main(String[] args) {
//        int[][] prerequisites = new int[][]{{1, 0}};
        int[][] prerequisites = new int[][]{{1,0},{0,1}};
        System.out.println(canFinish(2, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses = new ArrayList<>();
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            courses.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int course = 0; course < numCourses; course++) {
            if (hasCycle(courses, visited, course)) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasCycle(List<List<Integer>> courses, int[] visited, int course) {
        if (visited[course] == 1) {
            return true;
        }

        visited[course] = 1;

        for (int val : courses.get(course)) {
            if (visited[val] != 2) {
                if (hasCycle(courses, visited, val)) {
                    return true;
                }
            }
        }

        visited[course] = 2;

        return false;
    }
    /*public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < prerequisites.length; i++) {
            if (!courseMap.containsKey(prerequisites[i][0])) {
                courseMap.put(prerequisites[i][0], new ArrayList<>());
            }

            courseMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(courseMap, visited, course)) {
                return false;
            }
        }
        return true;
    }*/

    /*private static boolean dfs(Map<Integer, List<Integer>> courseMap, Set<Integer> visited, int course) {
        if (visited.contains(course)) {
            return false;
        }

        if (courseMap.containsKey(course) && courseMap.get(course).isEmpty()) {
            return true;
        }

        visited.add(course);
        for (Integer val: courseMap.get(course)) {
            if (!dfs(courseMap, visited, val)) {
                return false;
            }
        }
        visited.remove(course);
        courseMap.put(course, Collections.emptyList());

        return true;
    }*/
}
