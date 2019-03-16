
import java.util.*;

class Solution {

    // dfs
    static List<String> wordBreak(String s, List<String> wordList) {
        List<String> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        return dfs(s, wordList, map);
    }

    private static List<String> dfs(String s, List<String> wordList, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            return res;
        }

        // backtracking
        for (String word : wordList) {
            if (s.startsWith(word)) {
                String restString = s.substring(word.length());
                if (!restString.isEmpty()) {
                    List<String> nextList = dfs(restString, wordList, map);
                    if (nextList.size() != 0) {
                        for (String next : nextList) {
                            res.add(word + " " + next);
                        }
                    }
                } else {
                    res.add(word);
                }
            }
        }
        map.put(s, res);
        return res;
    }

    // Given a non-empty string s and a dictionary wordDict containing a list of
    // non-empty words,
    // add spaces in s to construct a sentence where each word is a valid dictionary
    // word. Return all such possible sentences.
    // Note:
    // The same word in the dictionary may be reused multiple times in the
    // segmentation.
    // You may assume the dictionary does not contain duplicate words.
    // Example 1:

    // Input:
    // s = "catsanddog"
    // wordDict = ["cat", "cats", "and", "sand", "dog"]
    // Output:
    // [
    // "cats and dog",
    // "cat sand dog"
    // ]

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordList = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        List<String> result = wordBreak(s, wordList);
        System.out.println(result);
    }
}