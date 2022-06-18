package linkedlist;

import java.util.Arrays;
import java.util.List;

public class Demo10 {

    public static List<Integer> cellCompete(int[] states, int days){
        int daysC = 0;

        Integer[] updatedStatus = new Integer[8];

        for (int j = 0; j< states.length; j++){
            updatedStatus[j] = states[j];
        }

        while (daysC < days){

            for (int i=1; i< 7; i++){
                updatedStatus[i] = (states[i-1] == states[i+1] ? 0: 1);
            }

            updatedStatus[0] = (states[1] == 0 ? 0: 1);
            updatedStatus[7] = (states[6] == 0 ? 0: 1);

            daysC++;
        }

        return Arrays.asList(updatedStatus);
    }

    public static void main(String[] args){

        int[] abc = {1, 1, 1, 0, 1, 1, 1, 1};
        List<Integer> retVal = cellCompete(abc, 1);
        System.out.println(retVal);
    }
}
