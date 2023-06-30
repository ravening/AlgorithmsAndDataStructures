package Futures.handler;

public class PersonHandler implements ResultHandler<Person> {

    @Override
    public void onSuccess(Person result) {
        System.out.println("Person saved successfully: " + result);
    }

    @Override
    public void onError(Throwable throwable) {
        ResultHandler.super.onError(throwable);
    }
}
