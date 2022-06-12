package Arrays;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/fruit-into-baskets/
 */
public class FruitBasket {

    /**
     * https://leetcode.com/problems/fruit-into-baskets/discuss/170745/Problem%3A-Longest-Subarray-With-2-Elements
     * @param array
     * @return
     */
    public int betterSolution(int[] array) {
        if (array == null || array.length == 0) {
            return  0;
        }

        int lastFruit = -1, secondLastFruit = -1;
        int lastFruitCount = 0;
        int max = 0;
        for (var fruit : array) {
            int curMax = 0;
            if (fruit == lastFruit || fruit == secondLastFruit) {
                curMax++;
            } else {
                curMax = lastFruitCount + 1;
            }

            if (fruit != lastFruit) {
                lastFruitCount = 1;
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            } else {
                lastFruitCount++;
            }

            max = Math.max(max, curMax);
        }

        return max;
    }
    public int solution(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        int maxSize = 1;
        int startIndex = 0;
        Set<Integer> set = new HashSet<>();

        for (var i = 0; i < array.length; i++) {
            if (set.size() < 2 || set.contains(array[i])) {
                set.add(array[i]);
            } else {
                int lastOne = array[i-1];
                for (var j = i-2; j>=0; j--) {
                    if (array[j] != lastOne) {
                        set.remove(array[j]);
                        startIndex = j + 1;
                        break;
                    }
                }

            }
            maxSize = Math.max(maxSize, i - startIndex + 1);
        }

        return maxSize;
    }

    public static void main(String[] args) throws ParseException {
        int[] array = new int[]{3,3,3,1,2,1,1,2,3,3,4};



//        Date a = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse("01-06-2022 13:19");
//        Date b = new Date();
//        System.out.println("a is " + a + " and b is " + b);
//        System.out.println(a.before(b));
//        LocalDate localDate = LocalDate.now();
//        System.out.println(localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
//        LocalDate date = LocalDate.parse("2020-01-08");
//        LocalDate date1 = LocalDate.parse("01-06-2022 13:19", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
//        System.out.println("local date is " +date1);

//        String string = "01-06-2022 23:24";
//        Date newDate1 = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(string);
//        System.out.println("searching for date: " + newDate1);
//
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
//        String strDate = sdf.format(date);
//        System.out.println(" ===========" + strDate);

//        Date newDate = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(strDate);
//        System.out.println(newDate.toString());

//        SimpleDateFormat ft =
//                new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

//        LocalDate localDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(strDate));

        FruitBasket basket = new FruitBasket();
        System.out.println(basket.solution(array));
        array = new int[]{1,2,3,2,2};
        System.out.println(basket.betterSolution(array));
    }
}
