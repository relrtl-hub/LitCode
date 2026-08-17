package com.litcode.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import com.litcode.engine.ProblemStore;

import java.util.Map;

public class WebServer {

    private final ProblemStore store;
    private final Javalin app;

    public WebServer(ProblemStore store, int port) {
        this.store = store;
        this.app = Javalin.create(config -> {
            config.staticFiles.add("static", Location.CLASSPATH);
        });
        setupRoutes();
    }

    private void setupRoutes() {
        app.get("/", ctx -> ctx.redirect("/index.html"));

        app.get("/api/problems", ctx -> {
            ctx.json(store.getAll().stream().map(p -> Map.of(
                "id", p.getId(),
                "name", p.getName(),
                "number", p.getNumber(),
                "difficulty", p.getDifficulty()
            )).toList());
        });

        app.get("/api/problems/{id}", ctx -> {
            var problem = store.get(ctx.pathParam("id"));
            if (problem == null) ctx.status(404).json(Map.of("error", "Not found"));
            else ctx.json(problem);
        });
    }

    public void start() {
        app.start(7070);
        System.out.println("LitCode server running at http://localhost:7070");
        System.out.println("Loaded " + store.size() + " problems");
    }

    public void stop() {
        app.stop();
    }
}
