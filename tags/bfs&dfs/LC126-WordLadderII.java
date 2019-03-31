import java.util.*;

class Solution {

    // use bfs to build a graph stored in a hash map
    // then usd dfs to print that hash map

    // bidirectional bfs & dfs, beat 100%
    private static boolean isMet = false;

    static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (endWord.isEmpty() || !wordSet.contains(endWord)) {
            return res;
        }

        // build a graph to store the word tree
        Map<String, Set<String>> graph = new HashMap<>();
        Set<String> froms = new HashSet<>();
        Set<String> tos = new HashSet<>();
        froms.add(beginWord);
        tos.add(endWord);
        buildGraph(graph, froms, tos, wordSet, false);
        if (!isMet) {
            return res;
        }

        List<String> tmpList = new ArrayList<>();
        tmpList.add(beginWord);
        printGraph(res, tmpList, graph, beginWord, endWord);
        return res;
    }

    // bfs
    private static void buildGraph(Map<String, Set<String>> graph, Set<String> froms, Set<String> tos,
                                Set<String> wordSet, boolean isReversed) {
        if (froms.isEmpty() || tos.isEmpty()) {
            return;
        }

        if (froms.size() > tos.size()) {
            buildGraph(graph, tos, froms, wordSet, !isReversed);
        }

        wordSet.removeAll(tos);
        wordSet.removeAll(froms);
        Set<String> nexts = new HashSet<>();

        for (String from : froms) {
            char[] arr = from.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char tmp = arr[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    arr[i] = j;
                    String changed = new String(arr);
                    if (!wordSet.contains(changed) && !tos.contains(changed)) {
                        continue;
                    }
                    String key = !isReversed ? from : changed;
                    String value = !isReversed ? changed : from;
                    graph.putIfAbsent(key, new HashSet<>());
                    if (tos.contains(changed)) {
                        isMet = true;
                        graph.get(key).add(value);
                    }
                    if (!isMet && wordSet.contains(changed)) {
                        graph.get(key).add(value);
                        nexts.add(changed);
                    }
                }
                arr[i] = tmp;
            }
        }

        if (!isMet) {
            buildGraph(graph, nexts, tos, wordSet, isReversed);
        }
    
    }

    private static void printGraph(List<List<String>> res, List<String> tmpList,
                 Map<String, Set<String>> graph, String beginWord, String endWord) {
        if (beginWord.equals(endWord)) {
            List<String> tmp = new ArrayList<>(tmpList);
            res.add(tmp);
            return;
        }

        if (!graph.containsKey(beginWord)) {
            return;
        }
        Set<String> tos = graph.get(beginWord);
        for (String to : tos) {
            tmpList.add(to);
            printGraph(res, tmpList, graph, to, endWord);
            tmpList.remove(to);
        }
    }

    // Given two words (beginWord and endWord), and a dictionary's word list,
    // find all shortest transformation sequence(s) from beginWord to endWord, such
    // that:
    // Only one letter can be changed at a time
    // Each transformed word must exist in the word list. Note that beginWord is not
    // a transformed word.
    // Note:

    // Return an empty list if there is no such transformation sequence.
    // All words have the same length.
    // All words contain only lowercase alphabetic characters.
    // You may assume no duplicates in the word list.
    // You may assume beginWord and endWord are non-empty and are not the same.
    // Example 1:

    // Input:
    // beginWord = "hit",
    // endWord = "cog",
    // wordList = ["hot","dot","dog","lot","log","cog"]

    // Output:
    // [
    // ["hit","hot","dot","dog","cog"],
    // ["hit","hot","lot","log","cog"]
    // ]

    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        //List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog"));
        List<List<String>> result = findLadders(beginWord, endWord, wordList);
        for (List<String> record : result) {
            System.out.println(record);
        }
    }
}