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
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Boolean item) {
        if(item) {
            computePosition();
        }
        subscription.request(1);
    }

    private void computePosition() {
        switch(Vessel.course) {
            case N -> Navigator.positionY++;
            case E -> Navigator.positionX++;
            case S -> Navigator.positionY--;
            case W -> Navigator.positionX--;
        }
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
