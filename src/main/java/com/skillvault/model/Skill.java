package com.skillvault.model;

public class Skill {
    private int id;
    private String name;
    private String category;
    private int difficulty;
    private int masteryLevel;
    public Skill(){}
    @Override
    public String toString() {
        return "Skill ID: " + id +
                ", Name: " + name +
                ", Category: " + category +
                ", Difficulty: " + difficulty +
                ", Mastery Level: " + masteryLevel;
    }

    public Skill(int id, String name, String category, int difficulty, int masteryLevel) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.difficulty = difficulty;
        this.masteryLevel = masteryLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getMasteryLevel() {
        return masteryLevel;
    }

    public void setMasteryLevel(int masteryLevel) {
        this.masteryLevel = masteryLevel;
    }
}
