package gradebook;

import java.util.ArrayList;
import java.util.List;

public class GradeBook {

    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {

        for (Student s : students) {
            if (s.getRollNo().equals(student.getRollNo())) {
                throw new IllegalArgumentException(
                    "Duplicate roll number: " + student.getRollNo()
                );
            }
        }

        students.add(student);
    }

    public double sumScores(Student student) {
        double sum = 0;

        for (double score : student.getScores()) {
            sum += score;
        }

        return sum;
    }

    public double avgScores(Student student) {

        if (student.getScores().isEmpty()) {
            return 0;
        }

        return sumScores(student) / student.getScores().size();
    }
}