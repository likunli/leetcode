import java.util.*;

class Solution {
    static int[][] reconstructQueue(int[][] people) {
        if (people.length == 0 || people[0].length == 0) {
            return new int[][] {};
        }

        Arrays.sort(people, (int[] a, int[] b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });

        List<int[]> res = new ArrayList<>();

        for (int[] record : people) {
            // key part ->
            // list.add(index , value)
            // append that value after the index indead of add the value to end of the list
            res.add(record[1], record);
        }
        return res.toArray(new int[people.length][2]);
    }

    // Suppose you have a random list of people standing in a queue. 
    // Each person is described by a pair of integers (h, k), 
    // where h is the height of the person and k is the number of people 
    // in front of this person who have a height greater than or equal to h. 
    // Write an algorithm to reconstruct the queue.

    // Note:
    // The number of people is less than 1,100.

    // Example
    // Input:
    // [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

    // Output:
    // [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
    public static void main(String[] args) {
        int[][] people = {
            {7, 0},
            {4, 4},
            {7, 1},
            {5, 0},
            {6, 1},
            {5, 2}
        };
        int[][] res = reconstructQueue(people);
        for (int[] record: res) {
            System.out.println(Arrays.toString(record));
        }
    }
}