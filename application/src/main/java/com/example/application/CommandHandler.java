package com.example.application;

import com.example.core.Vessel;
import com.example.shared.Direction;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CommandHandler {
    private void handleCommand(final String command) {
        final String input = command.toUpperCase();
        final String[] parts = input.split(",");
        if (parts.length != 2) {
            System.err.println("Usage: [Direction,Speed]");
        } else {
            try {
                final Direction direction = Direction.valueOf(parts[0]);
                final int speed = Integer.valueOf(parts[1]);
                System.out.println("setting direction " + direction + " and speed " + speed);
                Vessel.course = direction;
                Vessel.speed = speed;
            } catch (final IllegalArgumentException f) {
                System.err.println("Bad input. Direction can be 'N/E/S/W', speed can be any integer number.");
            }
        }
    }

    @EventListener
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        final Thread consoleThread = new Thread(() -> {
            try {
                Thread.sleep(500L);
            } catch (final InterruptedException e) {
                // nichts machen
            }
            final Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Give direction and speed: [N/E/S/W,any integer number] or 'status' for current information or 'exit' to quit...");
                final String input = scanner.nextLine().trim();
                if("status".equalsIgnoreCase(input)) {
                    System.out.println("Vessel speed " + Vessel.speed + " course " + Vessel.course);
                } else if ("exit".equalsIgnoreCase(input)) {
                    System.out.println("exit.");
                    System.exit(0);
                } else {
                    this.handleCommand(input);
                }
            }
        });

        consoleThread.setDaemon(true);
        consoleThread.start();
    }

}
