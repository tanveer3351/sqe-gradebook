package gradebook;

import java.util.ArrayList;
import java.util.List;

public class student {

    private String name;
    private String roll_no;
    private List<Double> score;


    public void sumScore(double score) {
    if (score < 0) {
        throw new IllegalArgumentException("Score cannot be negative");
    }

    score.add(score);
    }   

    public Student(String name, String rollNo) {
        this.name = name;
        this.rollNo = rollNo;
        this.s = new ArrayList<>();
    }
}