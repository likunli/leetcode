class Solution {
    public int minAreaRect(int[][] points) {
        if (points.length == 0 || points[0].length == 0) {
            return 0;
        }
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] record : points) {
            graph.putIfAbsent(record[0], new HashSet<>());
            graph.get(record[0]).add(record[1]);
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] p = points[i];
                int[] q = points[j];
                if (p[0] == q[0] || p[1] == q[1]) {
                    continue;
                }
                if (graph.get(p[0]).contains(q[1])
                   && graph.get(q[0]).contains(p[1])) {
                    int area = Math.abs((p[0] - q[0]) * (p[1] - q[1]));
                    min = Math.min(min, area);
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    // Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes.

    // If there isn't any rectangle, return 0.
    // Example 1:

    // Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
    // Output: 4
    // Example 2:

    // Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
    // Output: 2
}