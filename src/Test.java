import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        List<Schedule> schedules = new ArrayList<>();
        schedules.add(new Schedule(1, 10, "Alice"));
        schedules.add(new Schedule(5, 7, "Bob"));
        schedules.add(new Schedule(6, 12, "Carla"));
        schedules.add(new Schedule(15, 17, "David"));

        // <1,5,alice> <5,7, Alice,bob> <7,10,alice>
        // last.end = 6
        //
        Collections.sort(schedules,
                Comparator.comparingInt((Schedule s) -> s.start).thenComparingInt(s -> s.end));

        schedules.forEach(System.out::println);
    }
}

class Schedule {
    int start;
    int end;
    String name;

    public Schedule(int start, int end, String name) {
        this.start = start;
        this.end = end;
        this.name = name;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "start=" + start +
                ", end=" + end +
                ", name='" + name + '\'' +
                '}';
    }
}
