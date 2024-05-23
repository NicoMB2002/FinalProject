package org.example;

import lombok.*;

import java.util.ArrayList;

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
        this.assignmentId = assignmentId;
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
}
