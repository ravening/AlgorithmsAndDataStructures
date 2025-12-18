package com.rakeshv.completablefutures;

import com.rakeshv.models.Email;
import com.rakeshv.models.User;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class AsyncExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService starter = Executors.newSingleThreadExecutor();
        Supplier<List<Long>> userIdSupplier = () -> {
            return Arrays.asList(1L, 2L, 3L);
        };

        Function<List<Long>, CompletableFuture<List<User>>> fetchUsers = ids -> {
            sleep(150);
            Supplier<List<User>> userSupplier = () -> {
                return ids.stream().map(User::new).collect(Collectors.toList());
            };
            System.out.println("Slept for 150");
            return CompletableFuture.supplyAsync(userSupplier, executorService1);
        };

        Function<List<Long>, CompletableFuture<List<User>>> fetchUsers1 = ids -> {
            sleep(5000);
            Supplier<List<User>> userSupplier = () -> {
                return ids.stream().map(User::new).collect(Collectors.toList());
            };
            System.out.println("Slept for 5000");
            return CompletableFuture.supplyAsync(userSupplier, executorService1);
        };

        Function<List<Long>, CompletableFuture<List<Email>>> fetchEmails = ids -> {
            sleep(150);
            Supplier<List<Email>> emailSupplier = () -> {
                return ids.stream().map(Email::new).collect(Collectors.toList());
            };

            System.out.println("returning emails");
            return CompletableFuture.supplyAsync(emailSupplier, executorService1);
        };

        Consumer<List<User>> displayUser = users -> {
            users.forEach(System.out::println);
        };

        CompletableFuture<Void> start = new CompletableFuture<>();
        CompletableFuture<List<Long>> completableFuture = start.thenApply(nil -> userIdSupplier.get());
        CompletableFuture<List<User>> userFuture = completableFuture.thenComposeAsync(fetchUsers);
        CompletableFuture<List<Email>> emailFuture = completableFuture.thenComposeAsync(fetchEmails);

        userFuture.thenAcceptBothAsync(
                emailFuture,
                (users, emails) -> {
                    System.out.println("User size is " + users.size() + " and email size is " + emails.size());
        });

        start.completeAsync(() -> null, starter);
        CompletableFuture<List<User>> users1 = completableFuture.thenComposeAsync(fetchUsers);
        CompletableFuture<List<User>> users2 = completableFuture.thenComposeAsync(fetchUsers1);

        users1.acceptEither(users2, displayUser);

        CompletableFuture.supplyAsync(userIdSupplier)
                .thenComposeAsync(fetchUsers)
                .thenAcceptAsync(displayUser, executorService);

        try {
            Thread.sleep(6000);
            executorService.shutdown();
            executorService1.shutdown();
            starter.shutdown();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {}
    }
}
