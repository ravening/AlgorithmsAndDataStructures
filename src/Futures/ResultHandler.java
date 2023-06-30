package Futures.handler;

import java.util.function.Consumer;

public interface ResultHandler<T> extends Consumer<T> {

    void onSuccess(T result);

    default void onError(Throwable throwable) {
        System.err.println("Unable to save person : " + throwable.getMessage());
    }

    @Override
    default void accept(T result) {
        onSuccess(result);
    }
}
