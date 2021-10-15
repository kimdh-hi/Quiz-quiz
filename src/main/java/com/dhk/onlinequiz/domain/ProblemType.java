package com.dhk.onlinequiz.domain;

public enum ProblemType {

    OBJ("객관식"), SBJ("주관식");

    private String description;

    ProblemType(String description) {
        this.description = description;
    }
}
