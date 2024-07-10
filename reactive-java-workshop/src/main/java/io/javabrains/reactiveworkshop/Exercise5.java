package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFLux() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumbersFlux().subscribe(
                n -> System.out.println(n),
                err -> System.out.println("ERROR!!! : " + err.getMessage()),
                () -> System.out.println("Flux Emit Completed")
        );

        // Subscribe to a flux using an implementation of BaseSubscriber
//        ReactiveSources.userMono().subscribe(
//                u -> System.out.println(u),
//                err -> System.out.println("ERROR!!! : " + err.getMessage()),
//                () -> System.out.println("Mono Emit Completed")
//        );
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {
    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribe happened");
        request(1); // We are saying the publisher to send 1 item at a time
    }

    public void hookOnNext(T value) {
        System.out.println(value.toString() + " received");
        request(1); // when the next is sent, we proccess and again instruct the publisher to send 1 item
    }

    @Override
    protected void hookOnComplete() {
        System.out.println("MySubscription Completed");
    }
}