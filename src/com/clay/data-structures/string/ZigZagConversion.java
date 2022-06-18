package string;

import java.util.HashMap;
import java.util.Map;

/*
## topic description
Given a string, and an integer n, arrange it into an n-line snake and return it.
## Example
```
P    A    H    N
A  P L  S I  I  G
Y    I    R
And  then read line by line :  " PAHNAPLSIIGYIR "

 */
public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(convert2("PAYPALISHIRING", 3));
//        printZigZag("PAYPALISHIRING", 3);
    }

    private static String convert(String str, int rowNum) {
        if (str == null || str.length() == 0 || rowNum == 0) {
            return "";
        }
        int len = str.length();
        int colNum = len / rowNum;
        if (len % rowNum != 0) {
            colNum++;
        }
        StringBuilder[] sb = new StringBuilder[rowNum];
        for (int i = 0; i < rowNum; i++) {
            sb[i] = new StringBuilder();
        }
        int index = 0;
        boolean down = true;
        for (int i = 0; i < colNum; i++) {
            for (int j = 0; j < rowNum; j++) {
                if (index < len) {
                    sb[j].append(str.charAt(index));
                    index++;
                }
            }
            if (down) {
                for (int j = rowNum - 2; j >= 0; j--) {
                    if (index < len) {
                        sb[j].append(str.charAt(index));
                        index++;
                    }
                }
                down = false;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rowNum; i++) {
            result.append(sb[i]);
        }
        return result.toString();
    }

    //Method to print zigzag pattern
    private static void printZigZag(String str, int rowNum) {
        if (str == null || str.length() == 0 || rowNum == 0) {
            return;
        }
        int len = str.length();
        int colNum = len / rowNum;
        if (len % rowNum != 0) {
            colNum++;
        }
        int index = 0;
        boolean down = true;
        for (int i = 0; i < colNum; i++) {
            for (int j = 0; j < rowNum; j++) {
                if (index < len) {
                    System.out.print(str.charAt(index));
                    index++;
                }
            }
            if (down) {
                for (int j = rowNum - 2; j >= 0; j--) {
                    if (index < len) {
                        System.out.print(str.charAt(index));
                        index++;
                    }
                }
                down = false;
            }
        }
    }

    public static String convert2(String s, int numRows) {

        Map<Integer, StringBuilder> strMap = new HashMap<>();
        int pos = 0;
        boolean incr = true;
        for(char c : s.toCharArray()) {
            if (pos == numRows) incr = false;
            if (pos == 1) incr = true;

            if (incr) pos++;
            else pos--;

            if (!strMap.containsKey(pos)) {
                strMap.put(pos, new StringBuilder());
            }
            strMap.get(pos).append(c);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= numRows; i++) {
            result.append(strMap.get(i));
        }

        return result.toString();
    }
}
