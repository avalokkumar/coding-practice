package algods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temp {

    static String solution(int N, String S, String T) {
        String[][] map = new String[N][N];
        initializeMap(map);
        List<List<String>> shipsCoordinates = getShipCoordinates(S);
        List<String> hits = Arrays.asList(T.split(" "));
        int sunkShips = 0;
        int hitShips = 0;
        for (List<String> ship : shipsCoordinates) {
            if (ship.stream().allMatch(T::contains)) {
                sunkShips += 1;
            } else if (ship.stream().anyMatch(T::contains)) {
                hitShips += 1;
            }
        }

        return sunkShips + "," + hitShips;
    }

    private static List<List<String>> getShipCoordinates(String s) {
        String[] ships = s.split(",");
        int k = 0;
        List<List<String>> shipsCoordinates = new ArrayList<>();
        for (int i = 0; i < ships.length; i++) {
            List<String> shipCoordinates = new ArrayList<>();
            String topLeft = ships[i].split(" ")[0];
            String bottomRight = ships[i].split(" ")[1];

            char initChar = topLeft.charAt(topLeft.length() - 1);
            char endChar = bottomRight.charAt(bottomRight.length() - 1);

            char[] allChars = new char[endChar - initChar + 1];
            while (initChar <= endChar) {
                allChars[k++] = initChar;
                initChar++;
            }
            int startIndex = Integer.parseInt(String.valueOf(topLeft.charAt(0)));
            int endIndex = Integer.parseInt(String.valueOf(bottomRight.charAt(0)));

            while (startIndex <= endIndex) {
                for (int j = 0; j < allChars.length; j++) {
                    shipCoordinates.add(String.valueOf(startIndex) + allChars[j]);
                }
                startIndex++;
            }
            shipsCoordinates.add(shipCoordinates);
            k = 0;
        }

        return shipsCoordinates;
    }

    private static void initializeMap(String[][] map) {
        for (int i = 0; i < map.length; i++) {
            char ch = 'A';
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = String.valueOf(i + 1) + ch;
                ch++;
            }
        }
    }

    public static void main(String[] args) {
        String S = "1A 2A,12A 12A";
        String T = "12A";
        System.out.print(solution(12, S, T));
        System.out.print("");
    }


}


/**
 * static int solution(String s) {
 * int[] sCharCount = getCharCount(s);
 * int[] balloonCharCount = getCharCount("BALLOON");
 * int remainingCharCount = 0;
 *
 * for (int i = 0; i < 25; i++) {
 * if (sCharCount[i] < balloonCharCount[i]) {
 * return 0;
 * }
 * sCharCount[i] -= balloonCharCount[i];
 * }
 *
 * for (int i = 0; i < 25; i++) {
 * if (sCharCount[i] > 0) {
 * remainingCharCount += sCharCount[i];
 * }
 * }
 *
 * return remainingCharCount > 7 ? remainingCharCount % 7 : 1;
 * }
 *
 * private static int[] getCharCount(String str) {
 * int[] count = new int[26];
 *
 * for (int i = 0; i < str.length(); i++) {
 * int ch = str.charAt(i);
 * int offset = (int) 'A';
 * int val = ch - offset;
 * count[val]++;
 * }
 * return count;
 * }
 **/