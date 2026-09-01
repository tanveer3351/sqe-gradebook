package gradebook;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String Id_number;
    private List<Double> scores;

    public Student(String name, String rollNo) {
        this.name = name;
        this.Id_number = rollNo;
        this.scores = new ArrayList<>();
    }

    public void addScore(double score) {
    if (score < 0) {
        throw new IllegalArgumentException("Scores cannot be negative");
    }

        scores.add(score);
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return Id_number;
    }

    public List<Double> getScores() {
        return scores;
    }
}