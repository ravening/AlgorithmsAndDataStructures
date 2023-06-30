package Futures.handler;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * https://medium.com/@devjoemar2016/asynchronous-saving-with-jdbctemplate-in-spring-boot-using-completablefuture-and-custom-event-ca5e3a2df400
 */
public class AsynWriteWithHandler {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Person person = new Person(1, "John", "Doe");
        ResultHandler<Person> personHandler = new PersonHandler();

        PersonDao personDao = new PersonDao();

        CompletableFuture<Person> output = personDao.saveAsync(person, personHandler);

        try {
            Thread.sleep(7000);
            System.out.println("Back in main");
        } catch (Exception e) {}
        output.get();
    }
}
