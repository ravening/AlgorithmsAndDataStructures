package Futures.handler;

import java.util.concurrent.CompletableFuture;

public class PersonDao {

    private Person savePerson(Person person) {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {}

        System.out.println("Saving person to database " + person);

        return person;
    }

    public CompletableFuture<Person> saveAsync(Person person, ResultHandler<Person> resultHandler) {
        return CompletableFuture.supplyAsync(() -> savePerson(person))
                .thenApply(savedPerson -> {
                    resultHandler.onSuccess(savedPerson);
                    return savedPerson;
                })
                .exceptionally(throwable -> {
                    resultHandler.onError(throwable);
                    return null;
                });
    }
}
