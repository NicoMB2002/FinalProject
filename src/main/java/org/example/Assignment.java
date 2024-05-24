package org.example;

import lombok.*;

import java.util.ArrayList;
import java.util.Random;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private int maxScore;
    private double assignmentAverage;
    private ArrayList<Integer> scores;
    private int nextId = 3;

    public Assignment(String assignmentName, double weight, int maxScore) {
        this.assignmentId = String.format("A%d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.maxScore = maxScore;
        this.assignmentAverage = 0.0;
        this.scores = new ArrayList<>();
    }

    public void calcAssignmentAvg() {
        if (scores.isEmpty()) {
            assignmentAverage = 0.0;
        } else {
            double total = 0.0;
            for (int score : scores) {
                total += score;
            }
            assignmentAverage = total / scores.size();
        }
    }

    public void generateRandomScore() {
        Random random = new Random();

        int randomRange = random.nextInt(11);
        int score;
        if (randomRange == 0) {
            score = random.nextInt(60);
        } else if (randomRange == 1 || randomRange == 2) {
            score = random.nextInt(60, 70);
        } else if (randomRange == 3 || randomRange == 4) {
            score = random.nextInt(70, 80);
        } else if (randomRange >= 5 && randomRange <= 8) {
            score = random.nextInt(80, 90);
        } else {
            score = random.nextInt(90, 100);
        }
        scores.add(score);
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public void setAssignmentAverage(double assignmentAverage) {
        this.assignmentAverage = assignmentAverage;
    }

    public void setScores(ArrayList<Integer> scores) {
        this.scores = scores;
        calcAssignmentAvg();
    }

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }
}
