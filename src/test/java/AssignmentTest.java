import org.example.Assignment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AssignmentTest {
    @Test
    public void testCalcAssignmentAvg1() {
        Assignment assignment = new Assignment("Test", 0.3, 100);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(90);
        scores.add(80);
        scores.add(70);
        assignment.setScores(scores);
        assignment.calcAssignmentAvg();
        Assertions.assertEquals(80.0, assignment.getAssignmentAverage(), 0.001);
    }

    @Test
    public void testCalcAssignmentAvg2() {
        Assignment assignment = new Assignment("Test", 0.3, 100);
        assignment.setScores(new ArrayList<>());
        assignment.calcAssignmentAvg();
        Assertions.assertEquals(0.0, assignment.getAssignmentAverage(), 0.001);
    }

    @Test
    public void testCalcAssignmentAvg3() {
        Assignment assignment = new Assignment("Test", 0.3, 100);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(100);
        assignment.setScores(scores);
        assignment.calcAssignmentAvg();
        Assertions.assertEquals(100.0, assignment.getAssignmentAverage(), 0.001);
    }

    @Test
    public void testCalcAssignmentAvg4() {
        Assignment assignment = new Assignment("Test", 0.3, 100);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(0);
        scores.add(0);
        scores.add(0);
        assignment.setScores(scores);
        assignment.calcAssignmentAvg();
        Assertions.assertEquals(0.0, assignment.getAssignmentAverage(), 0.001);
    }
}
