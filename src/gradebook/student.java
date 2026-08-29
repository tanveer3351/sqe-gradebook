package gradebook;

import java.util.ArrayList;
import java.util.List;

public class student {

    private String Name;
    private String Id_number;
    private List<Double> scores;


    public void sumScore(double score) {
    if (score < 0) {
        throw new IllegalArgumentException("Score cannot be negative");
    }

    scores.add(score);
    }   

    public Student(String name, String rollNo) {
        this.name = name;
        this.rollNo = rollNo;
        this.s = new ArrayList<>();
    }
}