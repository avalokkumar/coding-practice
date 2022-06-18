import java.util.LinkedList;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Random().nextInt(10));
        //generate random number between 0 and 1
        System.out.println(new Random().nextDouble());
        //generate random number between 0 and 10
        System.out.println(new Random().nextInt(10));

        System.out.println(Math.random()*2);
    }

}
//0.7308781907032909
//0.7308781907032909