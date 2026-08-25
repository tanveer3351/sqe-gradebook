package gradebook;

import java.util.ArrayList;
import java.util.List;

public class student {

    private String name;
    private String rollNo;
    private List<Double> s;


    public void sumScore(double s) {

    s.add(s);
    }   

    public Student(String name, String rollNo) {
        this.name = name;
        this.rollNo = rollNo;
        this.s = new ArrayList<>();
    }
}