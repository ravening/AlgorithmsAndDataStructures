public class Test {
    public static void main(String[] args) {
        Interval interval = new Interval(1, 2, "test");
        System.out.println(interval.name);
    }
}

class Interval {
    int start;
    int end;
    String name;

    public Interval(int start, int end, String name) {
        this.start = start;
        this.end = end;
        this.name = name;
    }
}
