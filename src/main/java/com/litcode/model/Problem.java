package com.litcode.model;

import java.util.List;
import java.util.Map;

public class Problem {

    private String id;
    private String name;
    private Integer number;
    private String difficulty;
    private String language;
    private String source;
    private String category;
    private String type;
    private String backendSkill;
    private List<String> tags;
    private Map<String, Object> schema;
    private String description;
    private List<String> examples;
    private List<String> constraints;
    private String solutionCode;
    private String solution2Code;
    private String solution2Explanation;
    private String solution2TimeComplexity;
    private String solution2SpaceComplexity;
    private String explanation;
    private String timeComplexity;
    private String spaceComplexity;
    private String exampleWalkthrough;

    public Problem() {}

    public Problem(String id, String name, int number, String difficulty, String description,
                   List<String> examples, List<String> constraints,
                   String solutionCode, String explanation,
                   String timeComplexity, String spaceComplexity, String exampleWalkthrough) {
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
        this.exampleWalkthrough = exampleWalkthrough;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public Integer getNumber() { return number; }
    public String getDifficulty() { return difficulty; }
    public String getLanguage() { return language; }
    public String getSource() { return source; }
    public String getCategory() { return category; }
    public String getType() { return type; }
    public String getBackendSkill() { return backendSkill; }
    public List<String> getTags() { return tags; }
    public Map<String, Object> getSchema() { return schema; }
    public String getDescription() { return description; }
    public List<String> getExamples() { return examples; }
    public List<String> getConstraints() { return constraints; }
    public String getSolutionCode() { return solutionCode; }
    public String getSolution2Code() { return solution2Code; }
    public String getSolution2Explanation() { return solution2Explanation; }
    public String getSolution2TimeComplexity() { return solution2TimeComplexity; }
    public String getSolution2SpaceComplexity() { return solution2SpaceComplexity; }
    public String getExplanation() { return explanation; }
    public String getTimeComplexity() { return timeComplexity; }
    public String getSpaceComplexity() { return spaceComplexity; }
    public String getExampleWalkthrough() { return exampleWalkthrough; }
}
