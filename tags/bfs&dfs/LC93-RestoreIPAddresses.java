import java.util.*;


 class Solution {

    static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.isEmpty() || s.length() < 4 || s.length() > 12) {
            return res;
        }

        helper(res, new StringBuilder(), s, 0, 0);
        return res;
    }

    private static void helper(List<String> res, StringBuilder sb, String s, int currentIndex, int step) {
        if (step == 4 && sb.length() == (s.length() + 3)) {
            res.add(sb.toString());
            return;
        }

        if (step != 0) {
            sb.append(".");
        }

        int len = sb.length();
        for (int i = currentIndex + 1; i <= s.length() && i <= currentIndex + 3; i++) {
            String tmp = s.substring(currentIndex, i);
            if (tmp.length() != 1 && tmp.charAt(0) == '0') {
                continue;
            }
            int num = Integer.parseInt(tmp);
            if (num >= 0 && num <= 255 && (3 - step) * 3 >= (s.length() - i)) {
                sb.append(tmp);
                helper(res, sb, s, i, step + 1);
                sb.setLength(len);
            }
        }
    }
    

    // Given a string containing only digits, restore it by returning all possible valid IP address combinations.

    // Example:
    // Input: "25525511135"
    // Output: ["255.255.11.135", "255.255.111.35"]
    // ip   1.  1.  1.  1
    //    255.255.255.255
    public static void main(String[] args) {
        String s = "25525511135";
        List<String> res = restoreIpAddresses(s);
        System.out.println(res);
    }
 }