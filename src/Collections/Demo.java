package Collections;

import java.util.LinkedHashSet;
import java.util.SequencedCollection;

public class Demo {
    public static void main(String[] args) {
        SequencedCollection<String> list = new LinkedHashSet<>();

        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");
        list.addLast("E");

        SequencedCollection<String> reverse = list.reversed();
        reverse.remove("B");
        System.out.println(reverse);
        System.out.println(list);
        list.removeLast();
        System.out.println(reverse);
        System.out.println(list);

        Status status = Status.PENDING;
        printStatus(status);
    }

    public static void printStatus(Status status) {
        switch (status) {
            case PENDING -> System.out.println("Pending");
            case APPROVED -> System.out.println("Approved");
            case REJECTED -> System.out.println("Rejected");
        }
    }

}

enum Status {
    PENDING,
    APPROVED,
    REJECTED,
    CANCELLED
    ;

}
