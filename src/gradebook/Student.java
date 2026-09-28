package gradebook;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String rollNo;
    private List<Double> scores;

    public Student(String name, String rollNo) {
        this.name = name;
        this.rollNo = rollNo;
        this.scores = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public List<Double> getScores() {
        return scores;
    }

    /*
     * Adds a score directly to the student.
     * Used mainly for creating test data.
     */
    public void addScore(double score) {

        if (score < 0 || score > 100) {
            throw new IllegalArgumentException(
                    "Score must be between 0 and 100"
            );
        }

        scores.add(score);
    }

    public void clearScores() {
        scores.clear();
    }
}