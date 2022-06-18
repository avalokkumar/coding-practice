package algods.example.demo;

import java.util.ArrayList;
import java.util.List;

//buying and selling stock n number of times for max profit
public class StockBuyAndSell {

    public static void main(String[] args) {
        int[] sharePrices = {45, 18, 29, 100, 89, 67, 5, 89};

        maxDiff(sharePrices).stream().forEach(op -> {
            System.out.println("Buy : " + op.buy + " | Sell " + op.sell);
        });
        ;
    }

    private static List<Operation> maxDiff(int[] sharePrices) {

        int i = 0;
        int size = sharePrices.length;
        List<Operation> opList = new ArrayList<>();

        while (i < size) {
            Operation op = new Operation();
            //find local minima
            while (i < size && sharePrices[i + 1] < sharePrices[i]) {
                i++;
            }

            if (i == size) {
                break;
            }
            op.buy = i++;

            //find the local maxima
            while (i < size && sharePrices[i - 1] < sharePrices[i]) {
                i++;
            }

            op.sell = i - 1;
            opList.add(op);
        }

        return opList;
    }
    //-ve in case of decreasing price


}

class Operation {
    int buy, sell;
}


//buying and selling stock only once
/**
 * private static int maxDiff(int[] sharePrices) {
 *
 * int maxDiff = sharePrices[1]-sharePrices[0]; //-17, 11, 82, 84
 * int minPrice = sharePrices[0]; //45, 18, 5
 * for (int i = 1; i < sharePrices.length; i++) {
 *
 * if(sharePrices[i]-minPrice > maxDiff) { // false, true, true, false, false ,false, true
 * maxDiff = sharePrices[i]-minPrice;
 * }
 *
 * if(sharePrices[i]< minPrice) { // true, false, false,
 * minPrice = sharePrices[i];
 * }
 * }
 *
 * return maxDiff;
 * }
 **/