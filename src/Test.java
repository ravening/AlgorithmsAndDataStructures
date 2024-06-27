import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<Person, Integer> map = new HashMap<>();

        for (var i = 0; i < 10000; i++) {
            map.put(new Person("john"), 1);
        }

        System.out.println(map.size());
    }
}

class Person {
    String name;


    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
