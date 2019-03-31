import java.util.*;


class Solution {

    static boolean isValidSudoku(char[][] input) {
        for (int i = 0; i < 9; i++) {
            // row check
            if (!isParticalValid(input, i, i, 0, 8)) {
                return false;
            }
            // col check
            if (!isParticalValid(input, 0, 8, i, i)) {
                return false;
            }
        }

        // check every 3 * 3 cube
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isParticalValid(input, i * 3, i * 3  + 2, j * 3, j * 3 + 2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isParticalValid(char[][] input, int rowStart, int rowEnd, int colStart, int colEnd) {
        Set<Character> st = new HashSet<>();
        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                if (input[i][j] == '.') {
                    continue;
                }
                if (st.contains(input[i][j])) {
                    return false;
                } else {
                    st.add(input[i][j]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        char[][] input = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        boolean judge = isValidSudoku(input);
        System.out.println(judge);
    }
}