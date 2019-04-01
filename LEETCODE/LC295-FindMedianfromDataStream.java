
import java.util.*;


class MedianFinder {

    // we need a min heap  and a max heap
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    /** initialize your data structure here. */
    public MedianFinder() {
        // max heap
        left = new PriorityQueue<Integer>(
            (a, b) -> {
                return b - a;
            }
        );
        
        // min heap
        right = new PriorityQueue<Integer>(
            (a, b) -> {
                return a - b;
            }
        );

        // [..left] median [..right];
    }
    
    public void addNum(int num) {
        right.offer(num);
        left.offer(right.poll());
        if (left.size() > right.size()) {
            right.offer(left.poll());
        }
    }
    
    public double findMedian() {
        if (right.isEmpty()) {
            return 0.0;
        }

        if (right.size() == left.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return right.peek();
        }        
    }
}

class Solution {


    // Median is the middle value in an ordered integer list. 
    // If the size of the list is even, there is no middle value. 
    // So the median is the mean of the two middle value.

    // For example,
    // [2,3,4], the median is 3

    // [2,3], the median is (2 + 3) / 2 = 2.5

    // Design a data structure that supports the following two operations:

    // void addNum(int num) - Add a integer number from the data stream to the data structure.
    // double findMedian() - Return the median of all elements so far.
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(num);
        double param_2 = obj.findMedian();
    }
}