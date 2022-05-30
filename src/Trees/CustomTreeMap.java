package Trees;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CustomTreeMap {
    public static void main(String[] args) throws ParseException {

        Map<String, PriorityQueue<String>> map = new TreeMap<String, PriorityQueue<String>>();

        String date = "Tue May 24 21:21:54 CEST 2022";
//        DateFormat dateFormat = new SimpleDateFormat(
//                "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
//        dateFormat.parse(date);
//        System.out.println(dateFormat.format(new Date()));
        ZonedDateTime zdt = ZonedDateTime.parse(date, dateFormat);
        System.out.println(zdt.toInstant().toEpochMilli());
//        DateFormat df = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss.SSS zzz", Locale.US);
//        DateTimeFormatter f = DateTimeFormatter.ofPattern( "EEE MMM dd yyyy HH:mm:ss zzz" , Locale.US  );
//        ZonedDateTime zdt = ZonedDateTime.parse( date , f  );
//        System.out.println(zdt.toString());
//        Date date1 = df.parse(date);
//        long epoch = date1.getTime();
//        System.out.println("epoch is " + epoch);
        map.putIfAbsent("user", new PriorityQueue<>());
        map.get("user").add("s");
        map.get("user").add("d");
        map.get("user").add("a");
        map.putIfAbsent("suser", new PriorityQueue<>());
        map.get("suser").add("t");
        map.get("suser").add("a");
        map.get("suser").add("m");

        for (Map.Entry<String, PriorityQueue<String>> entry : map.entrySet()) {
            System.out.println("Key is " + entry.getKey());
            System.out.println("Valeus are " + (entry.getValue()));
        }
    }
}
