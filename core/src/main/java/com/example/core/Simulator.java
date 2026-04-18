package com.example.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.Flow;

@Component
public class Simulator implements Flow.Subscriber<Boolean> {

    private static final Logger log = LoggerFactory.getLogger(Simulator.class);

    Flow.Subscription subscription = null;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        log.info("com.example.core.Simulator.onSubscribe");
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Boolean item) {
        log.info("com.example.core.Simulator.onNext");
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("com.example.core.Simulator.onError");
    }

    @Override
    public void onComplete() {
        log.error("com.example.core.Simulator.onComplete");
    }
}
