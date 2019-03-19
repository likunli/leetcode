import java.util.*;

class Solution {

    static void qsort(int[] input) {
        int start = 0;
        int end = input.length - 1;
        sort(input, start, end);
    }

    private static void sort(int[] input, int start, int end) {
        if (start < end) {
            int pivot = partition(input, start, end);
            sort(input, start, pivot - 1);
            sort(input, pivot + 1, end);
        }
    }

    private static int partition(int[] input, int start, int end) {
        int pivot = input[end];
        int cur = start;

        for (int i = start; i <= end - 1; i++) {
            if (input[i] <= pivot) {
                swap(input, i, cur);
                cur++;
            }
        }
        swap(input, cur, end);
        return cur;
    }

    private static void swap(int[] input, int left, int right) {
        int tmp = input[left];
        input[left] = input[right];
        input[right] = tmp;
    }



    public static void main(String[] args) {

        int[] input = {2, 5, 7, 8, 9, 1, 3};
        qsort(input);
        System.out.println(Arrays.toString(input));

    }
}