import java.util.*;

class Solution {

    static void wallsAndGates(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    bfs(grid, i, j);
                }
            }
        }
    }

    private static void bfs(int[][] grid, int x, int y) {
        Deque<List<Integer>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>(Arrays.asList(x, y)));
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                List<Integer> record = queue.poll();
                int row = record.get(0);
                int col = record.get(1);
                if (step <= grid[row][col]) {
                    grid[row][col] = step;
                    // top
                    if (row - 1 >= 0 && grid[row - 1][col] > 0) {
                        queue.offer(new ArrayList<>(Arrays.asList(row - 1, col)));
                    }
                    // right
                    if (col + 1 < grid[0].length && grid[row][col + 1] > 0) {
                        queue.offer(new ArrayList<>(Arrays.asList(row, col - 1)));
                    }
                    // bottom
                    if (row + 1 < grid.length && grid[row + 1][col] > 0) {
                        queue.offer(new ArrayList<>(Arrays.asList(row + 1, col)));
                    }
                    // down
                    if (col - 1 >= 0 && grid[row][col - 1] > 0) {
                        queue.offer(new ArrayList<>(Arrays.asList(row, col - 1)));
                    }
                }
            }
            step++;
        }
    }

    // You are given a m x n 2D grid initialized with these three possible values.
    // -1 - A wall or an obstacle.
    // 0 - A gate.
    // INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647
    // to represent INF as you may assume that the distance to a gate is less than
    // 2147483647.
    // Fill each empty room with the distance to its nearest gate.
    // If it is impossible to reach a gate, it should be filled with INF.

    // Example:

    // Given the 2D grid:

    // INF -1 0 INF
    // INF INF INF -1
    // INF -1 INF -1
    // 0 -1 INF INF
    // After running your function, the 2D grid should be:

    // 3 -1 0 1
    // 2 2 1 -1
    // 1 -1 2 -1
    // 0 -1 3 4
    public static void main(String[] args) {
        // solution -> bfs from each possible entrance
        int[][] grid = { { 2147483647, -1, 0, 2147483647 }, { 2147483647, 2147483647, 2147483647, -1 },
                { 2147483647, -1, 2147483647, -1 }, { 0, -1, 2147483647, 2147483647 } };

        wallsAndGates(grid);
        for (int[] record : grid) {
            System.out.println(Arrays.toString(record));
        }
    }
}