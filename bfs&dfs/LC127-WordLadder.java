import java.util.*;

class Solution {

    // bfs
    static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (endWord == null || !wordList.contains(endWord) || beginWord.equals(endWord)) {
            return 0;
        }
        Set<String> wordSet = new HashSet<>(wordList);
        Deque<String> queue = new LinkedList<>();
        wordSet.remove(beginWord);
        queue.offer(beginWord);
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            while (size > 0) {
                size--;
                // judge each word in queue
                String str = queue.poll();
                if (str.equals(endWord)) {
                    return step;
                }
                char[] strArray = str.toCharArray();
                // check each character in the poped string
                for (int i = 0; i < strArray.length; i++) {
                    char tmp = strArray[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (strArray[i] != j) {
                            strArray[i] = j;
                            String changedStr = new String(strArray);
                            if (wordSet.contains(changedStr)) {
                                queue.offer(changedStr);
                                wordSet.remove(changedStr);
                            }
                        }
                    }
                    strArray[i] = tmp;
                }

            }
        }
        return 0;
    }

    // Given two words (beginWord and endWord), and a dictionary's word list, find
    // the length of shortest transformation sequence from beginWord to endWord,
    // such that:

    // Only one letter can be changed at a time.
    // Each transformed word must exist in the word list. Note that beginWord is not
    // a transformed word.
    // Note:

    // Return 0 if there is no such transformation sequence.
    // All words have the same length.
    // All words contain only lowercase alphabetic characters.
    // You may assume no duplicates in the word list.
    // You may assume beginWord and endWord are non-empty and are not the same.

    // Example 1:
    // Input:
    // beginWord = "hit",
    // endWord = "cog",
    // wordList = ["hot","dot","dog","lot","log","cog"]

    // hit -> hot -> dot -> dog -> cog

    // Output: 5
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int result = ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }
}