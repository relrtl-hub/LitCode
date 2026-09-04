package com.litcode.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import com.litcode.engine.ProblemStore;

import java.util.LinkedHashMap;
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
            ctx.json(store.getAll().stream().map(p -> {
                Map<String, Object> summary = new LinkedHashMap<>();
                summary.put("id", p.getId());
                summary.put("name", p.getName());
                summary.put("number", p.getNumber());
                summary.put("difficulty", p.getDifficulty());
                summary.put("language", p.getLanguage());
                summary.put("source", p.getSource());
                summary.put("category", p.getCategory());
                summary.put("type", p.getType());
                summary.put("backendSkill", p.getBackendSkill());
                summary.put("tags", p.getTags());
                return summary;
            }).toList());
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
