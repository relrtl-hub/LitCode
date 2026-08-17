package com.litcode.engine;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.litcode.model.Problem;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class ProblemStore {

    private final Map<String, Problem> problems;

    public ProblemStore() {
        this.problems = loadProblems();
    }

    private Map<String, Problem> loadProblems() {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("data/problems.json");
            if (is == null) {
                System.err.println("problems.json not found in classpath");
                return new LinkedHashMap<>();
            }
            ObjectMapper mapper = new ObjectMapper();
            List<Problem> list = mapper.readValue(is, new TypeReference<List<Problem>>() {});
            return list.stream()
                    .collect(Collectors.toMap(Problem::getId, p -> p, (a, b) -> a, LinkedHashMap::new));
        } catch (Exception e) {
            e.printStackTrace();
            return new LinkedHashMap<>();
        }
    }

    public Problem get(String id) { return problems.get(id); }
    public List<Problem> getAll() { return new ArrayList<>(problems.values()); }
    public int size() { return problems.size(); }
}
