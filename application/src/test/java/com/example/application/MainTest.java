package com.example.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MainTest {

    @Autowired
    private ScheduledTasks tasks;

    @Test
    public void shouldLoadContext() {
        assertThat(tasks).isNotNull();
    }

}
