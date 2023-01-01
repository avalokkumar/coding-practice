package interview;

import java.util.*;

/**
 * We are working on a security system for a badged-access room in our company's building.
 * <p>
 * Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collections:
 * <p>
 * All employees who didn't use their badge while exiting the room - they recorded an enter without a matching exit. (All employees are required to leave the room before the log ends.)
 * <p>
 * All employees who didn't use their badge while entering the room - they recorded an exit without a matching enter. (The room is empty when the log begins.)
 * <p>
 * Each collection should contain no duplicates, regardless of how many times a given employee matches the criteria for belonging to it.
 * records1 = [
 * ["Martha", "exit"],
 * ["Paul", "enter"],
 * ["Martha", "enter"],
 * ["Steve", "enter"],
 * ["Martha", "exit"],
 * ["Jennifer", "enter"],
 * ["Paul", "enter"],
 * ["Curtis", "exit"],
 * ["Curtis", "enter"],
 * ["Paul", "exit"],
 * ["Martha", "enter"],
 * ["Martha", "exit"],
 * ["Jennifer", "exit"],
 * ["Paul", "enter"],
 * ["Paul", "enter"],
 * ["Martha", "exit"],
 * ["Paul", "enter"],
 * ["Paul", "enter"],
 * ["Paul", "exit"],
 * ["Paul", "exit"]
 * ]
 * <p>
 * Expected output: ["Paul", "Curtis", "Steve"], ["Martha", "Curtis", "Paul"]
 */
public class MatchingBadge {

    public static void main(String[] args) {
        String[][] records1 = new String[][]{
                {"Martha", "exit"},
                {"Paul", "enter"},
                {"Martha", "enter"},
                {"Steve", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "enter"},
                {"Paul", "enter"},
                {"Curtis", "exit"},
                {"Curtis", "enter"},
                {"Paul", "exit"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "exit"},
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Martha", "exit"},
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"}
        };

        List<List<String>> result = getMatchingBadge(records1);
        for (List<String> val : result) {
            System.out.println(val);
        }
    }

    private static List<List<String>> getMatchingBadge(String[][] records1) {
        List<String> noBadgeExitList = new ArrayList<>();
        List<String> noBadgeEntryList = new ArrayList<>();
        Map<String, Boolean> entryExitMapping = new HashMap<>();
        boolean isFirstEntry = false;
        boolean isFirstExit = false;

        for (String[] record : records1) {

            if (record[1].equals("exit") && !entryExitMapping.containsKey(record[0])) {
                entryExitMapping.put(record[0], false);
                isFirstExit = true;
            }

            if (record[1].equals("enter") && !entryExitMapping.containsKey(record[0])) {
                entryExitMapping.put(record[0], true);
                isFirstExit = true;
            }

            if (record[1].equals("exit")) {
                if (!entryExitMapping.containsKey(record[0])) {
                    noBadgeEntryList.add(record[0]);
                } else {
                    noBadgeEntryList.add(record[0]);
                }
            }

            if (record[1].equals("enter") && !entryExitMapping.containsKey(record[0])) {
                noBadgeEntryList.add(record[0]);
            }

            entryExitMapping.put(record[0], true);
        }

        return Arrays.asList(noBadgeExitList, noBadgeEntryList);
    }
}
