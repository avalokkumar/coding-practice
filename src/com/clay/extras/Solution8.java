package extras;

import java.util.Scanner;

/**
 * Day Shared Liked Cumulative
	1      5     2       2
	2      6     3       5
	3      9     4       9
	4     12     6      15
	5     18     9      24
 *
 */
public class Solution8 {
	
	static int viralAdvertising(int n) {
		
		int shared = 5;
		int liked = 0;
		int cumulative = 0;
		
		for (int i = 0; i < n; i++) {
			liked = shared/2;
			cumulative += liked;
			shared = liked*3;
		}
		
		return cumulative;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();

        int result = viralAdvertising(n);
        
        System.out.println(result);
        scanner.close();
    }
}
