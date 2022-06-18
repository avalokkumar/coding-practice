package websites.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sample {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

         Map<String, String> dictionary = new HashMap<>();
         
         for (int i = 0; i < magazine.length; i++) {
             dictionary.put(magazine[i], magazine[i]);
         }

        //List<String> magazineItems = Arrays.asList(magazine);

        boolean isPresent = false;
        for (int i = 0; i < note.length; i++) {
            if (dictionary.containsKey(note[i])) {
            	dictionary.remove(note[i]);	
                break;
            }
        }

        System.out.println(isPresent ? "Yes" : "No");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
