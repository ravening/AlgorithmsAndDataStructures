package com.rakeshv.completablefutures;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class HttpClientExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException, URISyntaxException {
        ExecutorService service = Executors.newFixedThreadPool(5);

        HttpClient client = HttpClient.newBuilder()
                .executor(service)
                .version(HttpClient.Version.HTTP_1_1).build();

        List<URI> links = Arrays.asList(
                new URI("https://www.amazon.com"),
                new URI("https://www.google.com"),
                new URI("https://www.facebook.com"),
                new URI("https://www.netflix.com"),
                new URI("https://www.twitter.com")
        );

        List<CompletableFuture<String>> result = links.stream()
                .map(url -> {
                    return client.sendAsync(HttpRequest.newBuilder()
                            .GET()
                            .uri(url).build(), HttpResponse.BodyHandlers.ofString())
                            .thenApplyAsync(HttpResponse::body);
                })
                .collect(Collectors.toList());

        for (CompletableFuture<String> completableFuture : result) {
            System.out.println(completableFuture.get(5, TimeUnit.SECONDS));
        }

        service.awaitTermination(6, TimeUnit.SECONDS);
    }
}
