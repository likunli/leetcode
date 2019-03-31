import java.util.*;


class Solution {


    static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int max = 0;
        int lastMin = prices[0];

        for (int i = 1; i < prices.length; i++) {
            max = Math.max(prices[i] - lastMin, max);
            lastMin = Math.min(lastMin, prices[i]);
        }
        return max;
    }

    // Say you have an array for which the ith element is the price of a given stock on day i.
    // If you were only permitted to complete at most one transaction 
    // (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
    // Note that you cannot sell a stock before you buy one.

    // Example 1:
    // Input: [7,1,5,3,6,4]
    // Output: 5
    // Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    //             Not 7-1 = 6, as selling price needs to be larger than buying price.
    public static void main(String[] args) {
        int[] input = {7, 6,4,3,1};
        int result = maxProfit(input);
        System.out.println(result);
    }
}