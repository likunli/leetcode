import java.util.*;

class Solution {

    static String repeatingSequences(int n, int d) {
        boolean isNegative = n < 0 && d > 0 || n > 0 && d < 0;
        long nL = Math.abs((long) n);
        long dL = Math.abs((long) d);
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        long quotain = nL / dL;
        sb.append(quotain);

        nL %= dL;
        if (nL != 0) {
            sb.append('.');
        }

        int index = 0;
        while (nL != 0) {
            nL *= 10;
            quotain = Math.abs(nL / dL);
            if (!map.containsKey(nL)) {
                sb.append(quotain);
                map.put(nL, index);
                index++;
            } else {
                int firstIndex = 1 + map.get(nL) + sb.indexOf(".");
                sb.insert(firstIndex, '[');
                sb.append(']');
                break;
            }
            nL %= dL;
        }

        if (isNegative) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }

    // repeating sequnences
    // 1/3 = 0.333333 -> 0.[3]
    // 13/11 = 0.181818 ->2.[18]
    // 1/15 = 0.066666  -> 0.0[6]
    // 9/7 = 1.285714285714 -> 0.[285714]
    // 1/5 = 0.2 -> 0.2
    public static void main(String[] args) {
        int n = 1;
        int d = 5;
        String result = repeatingSequences(n ,d);
        System.out.println(result);
    }
}