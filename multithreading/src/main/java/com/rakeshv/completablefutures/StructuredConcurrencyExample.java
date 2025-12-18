package com.rakeshv.completablefutures;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.StructuredTaskScope;

/**
 * Demonstrates Structured Concurrency in Java using virtual threads (Java 21+).
 * Structured concurrency helps manage the lifecycle of concurrent tasks, making
 * code easier to reason about and less error-prone.
 *
 * This example shows:
 * 1. Returning as soon as one endpoint throws an error.
 * 2. Returning as soon as one endpoint returns successfully.
 * 3. Waiting for all endpoints to return results.
 */
public class StructuredConcurrencyExample {
    private static final List<String> ENDPOINTS = List.of(
            "https://httpbin.org/delay/2", // Simulates a 2s delay
            "https://httpbin.org/status/500", // Simulates an error
            "https://httpbin.org/get", // Returns immediately
            "https://httpbin.org/delay/1", // Simulates a 1s delay
            "https://httpbin.org/delay/3", // Simulates a 3s delay
            "https://httpbin.org/status/404", // Not found error
            "https://httpbin.org/status/200", // OK
            "https://httpbin.org/uuid", // Returns a UUID
            "https://httpbin.org/ip", // Returns IP info
            "https://httpbin.org/status/418" // I'm a teapot (error)
    );

    private static final HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(5))
            .build();

    // Helper method to call an endpoint
    private static String callEndpoint(String url) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(5))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() >= 400) {
            throw new RuntimeException("Error from endpoint: " + url + ", status: " + response.statusCode());
        }
        return response.body();
    }

    /**
     * Scenario 1: Return as soon as one endpoint throws an error.
     */
    public static void returnOnFirstError() {
        System.out.println("\n--- Scenario 1: Return on first error ---");
        try (var scope = StructuredTaskScope.open(StructuredTaskScope.Joiner.awaitAllSuccessfulOrThrow())) {
            for (String endpoint : ENDPOINTS) {
                scope.fork(() -> callEndpoint(endpoint));
            }
            try {
                scope.join(); // Wait for all or any to fail
                System.out.println("All endpoints succeeded.");
            } catch (Exception e) {
                System.out.println("Returned early due to error: " + e.getMessage());
            }
        }
    }

    /**
     * Scenario 2: Return as soon as one endpoint returns successfully.
     */
    public static void returnOnFirstSuccess() {
        System.out.println("\n--- Scenario 2: Return on first success ---");
        try (var scope = StructuredTaskScope.open(StructuredTaskScope.Joiner.<String>anySuccessfulResultOrThrow())) {
            for (String endpoint : ENDPOINTS) {
                scope.fork(() -> callEndpoint(endpoint));
            }
            try {
                String result = scope.join(); // Wait for any to succeed
                System.out.println("Returned early with result from one endpoint. Length: "
                        + (result != null ? result.length() : 0));
            } catch (Exception e) {
                System.out.println("All endpoints failed: " + e.getMessage());
            }

        }
    }

    /**
     * Scenario 3: Wait for all endpoints to return results.
     */
    public static void waitForAllEndpoints() {
        System.out.println("\n--- Scenario 3: Wait for all endpoints ---");
        try (var scope = StructuredTaskScope.open(StructuredTaskScope.Joiner.<String>awaitAll())) {
            List<StructuredTaskScope.Subtask<String>> subtasks = ENDPOINTS.stream()
                    .map(endpoint -> scope.fork(() -> callEndpoint(endpoint)))
                    .toList();
            scope.join(); // Wait for all
            for (int i = 0; i < subtasks.size(); i++) {
                StructuredTaskScope.Subtask<String> subtask = subtasks.get(i);
                if (subtask.state() == StructuredTaskScope.Subtask.State.SUCCESS) {
                    String result = subtask.get();
                    System.out
                            .println("Endpoint " + ENDPOINTS.get(i) + " returned result of length: " + result.length());
                } else {
                    Throwable ex = subtask.exception();
                    System.out.println("Endpoint " + ENDPOINTS.get(i) + " failed: "
                            + (ex != null ? ex.getMessage() : "Unknown error"));
                }
            }
        } catch (Exception e) {
            System.out.println("Error waiting for all endpoints: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        returnOnFirstError();
        returnOnFirstSuccess();
        waitForAllEndpoints();
    }
}

/**
 * Note: StructuredTaskScope is a preview API in Java 21+ (JEP 453).
 * To run this example, use Java 21+ with --enable-preview flag.
 *
 * Example usage:
 * javac --enable-preview --release 21 StructuredConcurrencyExample.java
 * java --enable-preview StructuredConcurrencyExample
 */