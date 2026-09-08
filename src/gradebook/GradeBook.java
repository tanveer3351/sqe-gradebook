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

        double average = sumScores(student) / (double) student.getScores().size();

        return Math.round(average * 100.0) / 100.0;
    }

    public String letterGrade(double score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }

        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
