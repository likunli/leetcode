
import java.util.*;

class Solution {

    static int largestRectangleArea(int[] height) {

        if (height.length == 0) {
            return 0;
        }

        int maxArea = 0;
        // use a stack to store the index of last closest higher height
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < height.length; i++) {   
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
            } else {
                // pop all the higher height in the stack
                int currentHeight = height[stack.pop()];
                int currentArea = 0;
                if (stack.isEmpty()) {
                    // [1, k] is the width, and array index start with 0, so multiple i
                    currentArea = currentHeight * i;
                } else {
                    // actually, it is i - 1 - (stack.peek(); - 1) -> i - stack.peek();
                    currentArea = currentHeight * (i - stack.peek() - 1);
                }
                maxArea = Math.max(currentArea, maxArea);
                i--;
            }
        }

        while (!stack.isEmpty()) {
            int currentHeight = height[stack.pop()];
            int currentArea = 0;
            if (stack.isEmpty()) {
                currentArea = currentHeight * height.length;
            } else {
                currentArea = currentHeight * (height.length - stack.peek() - 1);
            }
            maxArea = Math.max(currentArea, maxArea);
        }
        
        return maxArea;
    }

    

    // Given n non-negative integers representing the histogram's bar height 
    // where the width of each bar is 1, find the area of largest rectangle in the histogram.

    // Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

    // The largest rectangle is shown in the shaded area, which has area = 10 unit.
    public static void main(String[] args) {
        // int[] input = {2,1,5,6,2,3};
        //int[] input = {1,1};
        int[] input = {5,4,1,2};
        int result = largestRectangleArea(input);
        System.out.println(result);
    }
}