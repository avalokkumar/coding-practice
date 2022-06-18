package websites.hackerrank;

//with memoization
public class FibRec {

    private static int fib(int n, int[] mem){
        if(n == 0){
            return 0;
        } else if(n == 1){
            return n;
        }else if(mem[n] == n){
            return mem[n];
        }else{
            mem[n] = fib(n-1, mem) + fib(n-2, mem);
        }
        return mem[n];
    }
    public static void main(String[] args) {
        int[] mem = new int[6];
        for (int i =0; i< 6; i++){
            System.out.println(fib(i, mem));
        }
    }
}