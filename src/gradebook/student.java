package gradebook;

import java.util.ArrayList;
import java.util.List;

public class student {

    private String Name;
    private String Id_number;
    private List<Double> scores;

    public student(String name, String rollNo) {
        this.name = name;
        this.rollNo = rollNo;
        this.s = new ArrayList<>();
    }
    public void addScore(double score) {
    if (score < 0) {
        throw new IllegalArgumentException("Score cannot be negative");
    }

    scores.add(score);
    }   

     public String getName() {
        return name;
    }

    public List<Integer> getScores() {
        return scores;
    }
    
}
