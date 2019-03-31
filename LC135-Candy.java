import java.util.*;

class Solution {

    // greedy problem
    // time  : O (N)
    // space : O (1)
    static int candy1(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }

        int[] candies = new int[ratings.length];
        candies[0] = 1;
        
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            } else {
                continue;
            }
        }

        int sum = 0;
        for (int num : candies) {
            sum += num;
        }
        return sum;
    }

    // time   O (N)
    // space  O (1)
    static int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }

        int sum = 1;

        int pre = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] < ratings[i - 1]) {
                int count = 1;
                while (i < ratings.length && ratings[i] < ratings[i - 1]) {
                    count++;
                    i++;
                }
                i--;
                if (count > pre) {
                    sum += (count + 1) * count / 2 - pre;
                } else {
                    sum += (count + 1) * count / 2 - count;
                }
                pre = 1;
            } else if (ratings[i] > ratings[i - 1]) {
                pre++;
                sum += pre;
            } else {
                pre = 1;
                sum += pre;
            }
        }
        return sum;
    }

    // There are N children standing in a line. Each child is assigned a rating value.

    // You are giving candies to these children subjected to the following requirements:

    // Each child must have at least one candy.
    // Children with a higher rating get more candies than their neighbors.
    // What is the minimum candies you must give?

    // Example 1:

    // Input: [1,0,2]
    // Output: 5
    // Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
    // Example 2:

    // Input: [1,2,2]
    // Output: 4
    // Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
    //             The third child gets 1 candy because it satisfies the above two conditions.
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        int result = candy(ratings);
        System.out.println(result);
    }
}