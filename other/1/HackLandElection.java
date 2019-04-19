import java.util.*;


class Solution {

    static String electionWinner(String[] input) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : input) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        String maxString = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxString = entry.getKey();
            } else if (entry.getValue() == max && entry.getKey().compareTo(maxString) > 0) {
                maxString = entry.getKey();
            } 
        }
        return maxString;
    }

    public static void main(String[] args) {
        String[] input = {"Joe", "Mary", "Joe"};
        String result = electionWinner(input);
        System.out.println(result);
    }
}