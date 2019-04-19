import java.util.*;


class Solution {

    static int smallestStep(int n) {
        int step = 0;
        int cur = 0;
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int reversed = getReverse(i);
            if (reversed < i && getReverse(reversed) == i){
                dp[i] = Math.min(dp[i - 1], dp[reversed]) + 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    // each step -> you can increment number by 1
    //              or reverse (e.g. 47 -> 74, 30 -> 3)
    // calculate the minimum step to get N

    private static int getReverse(int n) {
        int result = 0;
        while (n > 0) {
            result = result * 10 + n % 10;
            n /= 10;
        }
        return result;
    }

    // for example
    // N = 4, 1 2 3 4 -> 3
    // N = 23, 1 2 3 4 5 6 7 8 9 10 11 12 21 22 23  -> 14
    // N = 43, 1 2 3 4 5 6 7 8 9 10 11 12 13 14 41 42 43 -> 16
    public static void main(String[] args) {
        int n = 4;
        int steps = smallestStep(n);
        System.out.println(steps);
    }
}