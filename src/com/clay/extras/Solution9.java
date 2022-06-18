package extras;

import java.util.Scanner;

/**
	2
	5 2 4
	5 2 1  --> 2
	5 2 2  --> 3
	5 7 3  --> 
 * 1 2 3 4 5
 * 
	: the number of prisoners - n - no of seats
 	: the number of sweets - m
 	: the chair number to start passing out treats at - s, i 
 */
public class Solution9 {

	static int saveThePrisoner(int n, int m, int s) {
		int x = (m%n)+s-1;
		return (x==0)?(s-1 == 0)?n:s-1:x;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		
		
		int t = scanner.nextInt();

		for (int tItr = 0; tItr < t; tItr++) {

			int n = scanner.nextInt();

			int m = scanner.nextInt();

			int s = scanner.nextInt();

			int result = saveThePrisoner(n, m, s);
			System.out.println(result);

		}
		scanner.close();
	}
}
/*
 * static int saveThePrisoner(int n, int m, int s) {
		int i=s;
		
		while(m != 1) { 
			if(i > n) { 
				i = i%n;
				m--;
			}else { 
				i++; 
				m--;
			}
		}
			
		return i;
	}
*/


/*
 * if(m+s < n) {
			return n-(m+n);
		}else if(m < n){
			return n%2 + s;
		}else {
			return 
		}
		*/
