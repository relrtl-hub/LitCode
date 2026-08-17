package com.litcode.model;

import java.util.List;

public class Problem {

    private String id;
    private String name;
    private int number;
    private String difficulty;
    private String description;
    private List<String> examples;
    private List<String> constraints;
    private String solutionCode;
    private String explanation;
    private String timeComplexity;
    private String spaceComplexity;

    public Problem() {}

    public Problem(String id, String name, int number, String difficulty, String description,
                   List<String> examples, List<String> constraints,
                   String solutionCode, String explanation,
                   String timeComplexity, String spaceComplexity) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.difficulty = difficulty;
        this.description = description;
        this.examples = examples;
        this.constraints = constraints;
        this.solutionCode = solutionCode;
        this.explanation = explanation;
        this.timeComplexity = timeComplexity;
        this.spaceComplexity = spaceComplexity;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getNumber() { return number; }
    public String getDifficulty() { return difficulty; }
    public String getDescription() { return description; }
    public List<String> getExamples() { return examples; }
    public List<String> getConstraints() { return constraints; }
    public String getSolutionCode() { return solutionCode; }
    public String getExplanation() { return explanation; }
    public String getTimeComplexity() { return timeComplexity; }
    public String getSpaceComplexity() { return spaceComplexity; }
}
