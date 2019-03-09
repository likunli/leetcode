import java.util.*;

class Solution {

    static int maxSubArray(int[] input) {
        //[-2,1,-3,4,-1,2,1,-5,4]
        //int[] dp = new int[input.length];
        int lastMax = input[0];
        int res = input[0];
        for (int i = 1; i < input.length; i++) {
            lastMax = Math.max(lastMax + input[i], input[i]);
            res = Math.max(lastMax, res);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(input);
        System.out.println(result);
    }
}