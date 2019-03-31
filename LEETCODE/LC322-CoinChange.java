
import java.util.*;

class Solution {

    // q1, get the coin change number
    static int coinChange(int[] coins, int amount) {

        // dynamic programming
        // fewest coins of change at that amount 'i'
        int[] fewestCoinsAt = new int[amount + 1];
        // -1 means could not get the change
        Arrays.fill(fewestCoinsAt, -1);
        fewestCoinsAt[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // check all the coin in the coin set
            for (int coin : coins) {
                if (i - coin >= 0 && fewestCoinsAt[i - coin] != -1) {
                    if (fewestCoinsAt[i] == -1) {
                        // first set the value for this index
                        fewestCoinsAt[i] = fewestCoinsAt[i - coin] + 1;
                    } else {
                        // compare with the previous set value, find the minimum
                        fewestCoinsAt[i] = Math.min(fewestCoinsAt[i], fewestCoinsAt[i - coin] + 1);
                    }
                }
            }
        }
        return fewestCoinsAt[amount];
    }

    // q2, get the solution with the fewest coins
    static List<Integer> coinChangeSolution(int[] coins, int amount) {
        List<Integer> res = new ArrayList<>();
        // bfs
        Map<Integer, List<Integer>> solution = new HashMap<>();
        solution.put(0, new ArrayList<>());
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && solution.containsKey(i - coin)) {
                    if (!solution.containsKey(i)) {
                        List<Integer> tmp = solution.get(i - coin);
                        List<Integer> cur = new ArrayList<>(tmp);
                        cur.add(coin);
                        solution.put(i, cur);
                    } else {
                        int preSize = solution.get(i).size();
                        int curSize = solution.get(i - coin).size() + 1;
                        if (curSize < preSize) {
                            List<Integer> tmp = solution.get(i - coin);
                            List<Integer> cur = new ArrayList<>(tmp);
                            cur.add(coin);
                            solution.put(i, cur);
                        }

                    }
                }
            }
        }
        solution.putIfAbsent(amount, new ArrayList<>());
        return solution.get(amount);
    }

    // You are given coins of different denominations and a total amount of money
    // amount.
    // Write a function to compute the fewest number of coins that you need to make
    // up that amount.
    // If that amount of money cannot be made up by any combination of the coins,
    // return -1.

    // Example 1:
    // Input: coins = [1, 2, 5], amount = 11
    // Output: 3
    // Explanation: 11 = 5 + 5 + 1
    // Example 2:

    // Input: coins = [2], amount = 3
    // Output: -1
    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        int result = coinChange(coins, amount);
        System.out.println(result);

        List<Integer> solution = coinChangeSolution(coins, amount);
        System.out.println(solution);
    }
}