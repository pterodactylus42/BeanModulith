package com.example.application;

import com.example.core.Simulator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.SubmissionPublisher;

@Component
public class ScheduledTasks extends SubmissionPublisher<Boolean> {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final int MILLISECONDS_PER_FRAME = 1000;

    public ScheduledTasks() {
        this.subscribe(new Simulator());
    }

    @Scheduled(fixedRate = MILLISECONDS_PER_FRAME)
    public void compute() {
        // offsets for position
        offer(Boolean.TRUE, (subscriber, aBoolean) -> {
            subscriber.onError(new RuntimeException("exception"));
            return true;
        });
    }
}