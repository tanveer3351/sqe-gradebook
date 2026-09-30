package gradebook;

import java.util.ArrayList;
import java.util.List;

public class Roster {

    private List<Student> students;

    public Roster() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public double class_average() {

    if (students.isEmpty()) {
        return 0;
    }

    GradeBook gradeBook = new GradeBook();

    double total = 0;

    for (Student student : students) {
        total += gradeBook.avgScores(student);
    }

    return total / students.size();
    }
}