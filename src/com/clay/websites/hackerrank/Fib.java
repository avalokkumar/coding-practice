package websites.hackerrank;

public class Fib {

    public static void main(String[] args) {

        //int n = new Scanner(System.in).nextInt();
        //int[] memo = new int[n + 1];
        //fibonacci(10, memo);
        System.out.println(fibonacci(10));
        //printMemo(memo);
    }

    private static void printMemo(int[] memo) {
        for (int i = 0; i < memo.length; i++) {
            System.out.println(i);
        }
    }

    /*private static void fibonacci(int n) {

        int a = 0, b = 1;

        while (n > 0) {
            *//*b = a + b;
			a = b - a;*//*
			int t =  a;
			a = a + b;
			b = t;
			System.out.println(b);
			n--;
		}
	}*/

    private static int fibonacci(int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    /*
    private static int fibonacci(int n, int[] memo) {

        if (n <= 0) {
            return 0;

        } else if (n == 1) {
            return 1;

        } else if (memo[n] > 0) {
            return memo[n];

        }
        memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        System.out.println(memo[n]);
        return memo[n];
    }
    */
}

