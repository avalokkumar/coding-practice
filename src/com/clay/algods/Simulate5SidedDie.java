package algods;

import java.util.Random;

/**
 * You have a function rand7() that generates a random integer from 1 to 7.
 * Use it to write a function rand5() that generates a random integer from 1 to 5.
 */
public class Simulate5SidedDie {

    public static void main(String[] args) {
        System.out.println(rand5());
    }

    private static int rand5() {
        int rand7 = rand7();
        while (rand7 > 5) {
            rand7 = rand7();
            //generate a random integer from 1 to 5 using rand7()
        }
        return 0;
    }

    private static int rand7() {
        return new Random().nextInt(7);
    }
}
