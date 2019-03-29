import java.util.*;

class Solution {

    static List<int[]> getSkyline(int[][] buildings) {
        if (buildings.length == 0 || buildings[0].length == 0) {
            return new ArrayList<>();
        }
        return devide(buildings, 0, buildings.length - 1);
    }

    private static List<int[]> devide(int[][] buildings, int start, int end) {
        if (start == end) {
            List<int[]> res = new ArrayList<>();
            res.add(new int[] {buildings[start][0], buildings[start][2]});
            res.add(new int[] {buildings[start][1], 0});
            return res;
        } else {
            List<int[]> left = devide(buildings, start, start + (end - start) / 2);
            List<int[]> right = devide(buildings, start + (end - start) / 2 + 1, end);
            return merge(left, right);
        }
    }

    private static List<int[]> merge(List<int[]> s, List<int[]> t) {
        List<int[]> res = new ArrayList<>();

        int currentPosition = 0;
        int sHeight = 0;
        int tHeight = 0;
        int sIndex = 0;
        int tIndex = 0;
        int preHight = 0;
        while (sIndex < s.size() && tIndex < t.size()) {
            int[] sCur = s.get(sIndex);
            int[] tCur = t.get(tIndex);

            if (sCur[0] < tCur[0]) {
                currentPosition = sCur[0];
                sHeight = sCur[1];
                sIndex++;
            } else if (sCur[0] > tCur[0]) {
                currentPosition = tCur[0];
                tHeight = tCur[1];
                tIndex++;
            } else {
                currentPosition = sCur[0];
                sHeight = sCur[1];
                tHeight = tCur[1];
                sIndex++;
                tIndex++;
            }
            int currentHeight = Math.max(sHeight, tHeight);
            if (preHight != currentHeight) {
                res.add(new int[] {currentPosition, currentHeight});
                preHight = currentHeight;
            }
            
        }

        while (sIndex < s.size()) {
            res.add(s.get(sIndex++));
        }

        while (tIndex < t.size()) {
            res.add(t.get(tIndex++));
        }
        return res;
    }

    // https://leetcode.com/problems/the-skyline-problem/
    // https://leetcode.com/problems/the-skyline-problem/discuss/61314/10ms-Divide-and-Conquer-JAVA-Solution
    // A city's skyline is the outer contour of the silhouette formed 
    // by all the buildings in that city when viewed from a distance. 
    // Now suppose you are given the locations and height of all the buildings 
    // as shown on a cityscape photo (Figure A), 
    // write a program to output the skyline formed by these buildings collectively 
    

    // Buildings  Skyline Contour
    // The geometric information of each building is represented 
    // by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates 
    // of the left and right edge of the ith building, respectively, and Hi is its height. 
    // It is guaranteed that 0 <= Li, Ri <= INT_MAX, 0 < Hi <= INT_MAX, and Ri - Li > 0. 
    // You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

    // For instance, the dimensions of all buildings in Figure A are recorded as:
    
    // [left, right, high]
    // [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

    // The output is a list of "key points" (red dots in Figure B) 
    // in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline.
    //  A key point is the left endpoint of a horizontal line segment. Note that the last key point, 
    //  where the rightmost building ends, is merely used to mark the termination of the skyline, 
    //  and always has zero height. Also, the ground in between any two adjacent buildings 
    //  should be considered part of the skyline contour.

    // For instance, the skyline in Figure B should be represented as:
    // [ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
    public static void main(String[] args) {
        int[][] buildings = {
            {2, 9, 10},
            {3, 7, 15},
            {5, 12, 12},
            {15, 20, 10},
            {19, 24, 8}
        };

        List<int[]> res = getSkyline(buildings);
        for (int[] record : res) {
            System.out.println(Arrays.toString(record));
        }
    }
}