package com.litcode;

import com.litcode.engine.ProblemStore;
import com.litcode.server.WebServer;

public class Application {

    public static void main(String[] args) {
        ProblemStore store = new ProblemStore();
        WebServer server = new WebServer(store, 7070);
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down...");
            server.stop();
        }));
    }
}
