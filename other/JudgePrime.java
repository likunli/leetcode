
import java.util.*;

class Solution {

    static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int number = sc.nextInt();
            boolean result = isPrime(number);
            System.out.println(result);
        }

    }
}