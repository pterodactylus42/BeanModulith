package com.example.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final int MILLISECONDS_PER_FRAME = 1000;

    @Scheduled(fixedRate = MILLISECONDS_PER_FRAME)
    public void compute() {
        // offsets for position
//        log.info("Speed: {}", Vessel.speed);
//        log.info("Speed unit: {}", Vessel.speedUnit());
//        log.info("Course: {}", Vessel.course);
//        log.info("Course unit: {}", Vessel.courseUnit());
//        log.info("-----------------------------");
    }
}