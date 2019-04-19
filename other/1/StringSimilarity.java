import java.util.*;

class Solution {

    static double calculate(String s1, String s2) {
        int base1 = 0;
        int qMark1 = 0;

        int base2 = 0;
        int qMark2 = 0;

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (char c : s1.toCharArray()) {
            if (c == '+') {
                base1++;
            } else if (c == '-') {
                base1--;
            } else {
                qMark1++;
            }
        }

        for (char c : s2.toCharArray()) {
            if (c == '+') {
                base2++;
            } else if (c == '-') {
                base2--;
            } else {
                qMark2++;
            }
        }
        double size1 = Math.pow(2.0, (double) qMark1);
        double size2 = Math.pow(2.0, (double) qMark2);
        
        generateMap(base1, map1, 0, qMark1);
        generateMap(base2, map2, 0, qMark2);

        System.out.println(map1);
        System.out.println(map2);
        double possibility = 0;
        for (int key : map1.keySet()) {
            if (map2.containsKey(key)) {
                possibility += map1.get(key) / size1 * map2.get(key) / size2;
            }
        }
        return possibility;
    }

    private static void generateMap(int base, Map<Integer, Integer> map, int cur, int left) {
        if (left == 0) {
            map.put(base + cur, map.getOrDefault(base + cur, 0) + 1);
            return;
        }
        generateMap(base, map, cur + 1, left - 1);
        generateMap(base, map, cur - 1, left - 1);
    }

    // a strign can contain only one of following three characters(+ - ?)
    // the '?' denotes a wildcard and indicates that the character could be
    // either '+' or '-'
    // for example, "-+?" could be "-++" or "-+-"

    // svalue of +-++ is  3 - 1 = 2
    // so, s1 -> +?  -> +- or ++
    //     s2 -> -?  -> -- or -+
    // so the probability that two of these strings have 
    // same svalue is 0.5 * 0.5 = 0.25

    public static void main(String[] args) {
        String s1 = "+???";
        String s2 = "-?";
        double result = calculate(s1, s2);
        System.out.println(result);
    }
}