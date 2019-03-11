import java.util.*;


class LovelaceDay {

    static int getLovelaceDay(int year) {
        int month = 10;
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        int t = calendar.get(Calendar.DAY_OF_WEEK);
        if (t == 3) {
            return 1 + 7;
        } else if (t < 3) {
            return 1 + (3 - t) + 7;
        } else {
            return 1 + (3 + 7 - t) + 7;
        }
    }

    public static void main(String[] args) {
        int year = 2018;
        
        int lovelace = getLovelaceDay(year);
        System.out.println(lovelace);
    }
}