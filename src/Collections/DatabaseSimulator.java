package Collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DatabaseSimulator {

    Map<String, String> database;
    Deque<Map<String, String>> transactionStack;

    public DatabaseSimulator() {
        this.database = new HashMap<>();
        this.transactionStack = new ArrayDeque<>();
    }

    public void begin() {
        transactionStack.push(new HashMap<>());
    }

    public String get(String key) {
        if (transactionStack.isEmpty()) {
            return database.get(key);
        }

        for (Iterator<Map<String, String>> it = transactionStack.descendingIterator(); it.hasNext(); ) {
            Map<String, String> map = it.next();
            if (map.containsKey(key)) {
                return map.get(key);
            }
        }
        return database.get(key);
    }

    public void set(String key, String value) throws RuntimeException {
        if (transactionStack.isEmpty()) {
            throw new RuntimeException("No transaction in progress");
        }

        transactionStack.getLast().put(key, value);
    }

    public int count() {
        return database.size();
    }

    public void clear() {
        database.clear();
    }

    public void commit() throws RuntimeException {
        if (transactionStack.isEmpty()) {
            throw new RuntimeException("No transaction in progress");
        }

        Map<String, String> map = new HashMap<>();

        for (Map<String, String> current : transactionStack) {
            map.putAll(current);
        }

        database.putAll(map);
        transactionStack.clear();
    }

    public void rollback() throws RuntimeException {
        if (transactionStack.isEmpty()) {
            throw new RuntimeException("No transaction in progress");
        }

        transactionStack.pop();
    }

    public static void main(String[] args) {
        DatabaseSimulator db = new DatabaseSimulator();
        db.begin();
        System.out.println(db.get("a"));
        db.set("a", "Hello A");
        System.out.println(db.get("a")); // hello A
        db.set("b", "Hello B");
        System.out.println(db.count()); // 0
        db.commit();
        System.out.println(db.get("a")); // Hello A
        System.out.println(db.get("b")); // Hello B
        System.out.println(db.count()); // 2
        db.clear();
        System.out.println("===================");

        System.out.println(db.get("b")); // null
        System.out.println(db.count()); // 0
        try {
            db.set("b", "Hello B"); // No transaction in progress
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            db.commit(); // No transaction in progress
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            db.rollback(); // No transaction in progress
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        db.clear();

        System.out.println("===================");

        db.begin();
        db.set("a", "Hello");
        db.begin();
        db.set("a", "World");
        System.out.println(db.get("a")); // World
        db.commit();
        System.out.println(db.get("a")); // World
        System.out.println(db.count()); // 1

    }
}
