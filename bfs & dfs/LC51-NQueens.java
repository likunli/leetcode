import java.util.*;

class Solution {

    static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        // search the graph
        dfs(res, 0, n, new int[n]);
        return res;
    }

    private static void dfs(List<List<String>> res, int step, int n, int[] pos) {
        if (step == n) {
            // have searched all the lines
            List<String> solution = getSolution(pos, n);
            res.add(solution);
        } else {
            // search the each possible index 
            // if have potential index, move forword to the next line
            for (int i = 0; i < pos.length; i++) {
                pos[step] = i;
                if (isValid(pos, step)) {
                    dfs(res, step + 1, n, pos);
                }
            }
        }
    }

    private static boolean isValid(int[] pos, int step) {
        for (int i = 0; i < step; i++) {
            // south
            if (pos[i] == pos[step]) {
                return false;
            }

            // southeast OR southwest
            if (Math.abs(pos[i] - pos[step]) == step - i) {
                return false;
            }
        }
        return true;
    }

    private static List<String> getSolution(int[] pos, int n) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < pos.length; i++) {
            char[] line = new char[n];
            Arrays.fill(line, '.');
            line[pos[i]] = 'Q';
            solution.add(new String(line));
        }
        return solution;
    }

    // The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
    // Given an integer n, return all distinct solutions to the n-queens puzzle.
    // Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

    // Example:
    // Input: 4
    // Output: [
    // [".Q..",  // Solution 1
    // "...Q",
    // "Q...",
    // "..Q."],

    // ["..Q.",  // Solution 2
    // "Q...",
    // "...Q",
    // ".Q.."]
    // ]
    // Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.

    public static void main(String[] args) {
        
        int n = 4;
        List<List<String>> result = solveNQueens(n);
        for (List<String> record : result) {
            for (String line : record) {
                System.out.println(line);
            }
            System.out.println();
        }
    }
}