
import java.util.*;

class Alerter {

    // any value is more than allowed increase above the window average in ALL windows in which it appears
    // any window's average is more than the acceptable increase over any previous window's average
    static boolean isAlert(int[] inputs, int window, double allowedIncrease) {
        if (inputs.length == 0 || window == 0) {
            return false;
        }

        // get each window's maximum
        int[] windowMax = getWindowMax(inputs, window);
        // get each window's average
        double[] windowAvg = getWindowAvg(inputs, window);

        // if alert by value over range in every window it exist
        boolean isAlertByWindow = windowAlert(inputs, windowMax, windowAvg, allowedIncrease, window);
        // if alert by average over range over privious minimum average
        boolean isAlertByPrevious = previousAlert(inputs, windowMax, windowAvg, allowedIncrease);
        return isAlertByWindow || isAlertByPrevious;
    }

    private static int[] getWindowMax(int[] inputs, int window) {
        int[] res = new int[inputs.length - window + 1];
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inputs.length; i++) {
            // remove number that out of range
            while (!queue.isEmpty() && queue.peek() <= i - window) {
                queue.poll();
            }

            // poll the previous number less than current offered number
            while (!queue.isEmpty() && inputs[queue.peekLast()] < inputs[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= window - 1) {
                res[i - window + 1] = inputs[queue.peek()];
            }
        }
        return res;
    }

    // calculate every window's average 
    private static double[] getWindowAvg(int[] inputs, int window) {
        double[] res = new double[inputs.length - window + 1];
        int sum = 0;

        for (int i = 0; i < inputs.length; i++) {
            if (i < window) {
                sum += inputs[i];
            } else {
                sum -= inputs[i - window];
                sum += inputs[i];
            }

            if (i >= window - 1) {
                res[i - window + 1] = (double) sum / window;
            }
        }
        return res;
    }

    private static boolean windowAlert(int[] inputs,
    int[] windowMax, double[] windowAvg, double allowedIncrease, int window) {

        for (int i = 0; i < windowMax.length; i++) {
            boolean judge = true;
            // alert when continuesly over allowedIncrease times equals to window width
            for (int j = i; j < i + window && j < windowAvg.length; j++) {
                if (windowMax[i] <= windowAvg[j] * allowedIncrease) {
                    judge = false;
                    break;
                }
            }
            if (judge) {
                return true;
            }
        }
        return false;
    }

    private static boolean previousAlert(int[] inputs,
        int[] windowMax, double[] windowAvg, double allowedIncrease) {   
        if (windowAvg.length == 0) {
            return false;
        }
        double min = windowAvg[0];

        for (int i = 1; i < windowMax.length; i++) {
            // update the minimum average
            min = Math.min(windowAvg[i], min);
            // alert when current average is more than the acceptable increase over any one previous average
            if (windowAvg[i] > min * allowedIncrease) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        
        int[] inputs = {1, 2, 4, 2, 2};
        int window = 3;
        double allowedIncrease = 2;
        boolean res = isAlert(inputs, window, allowedIncrease);
        System.out.println(res);
    }
}