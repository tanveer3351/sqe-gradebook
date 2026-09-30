package gradebook;

import java.util.ArrayList;
import java.util.List;

public class GradeBook {

    private List<Student> students;
    private GradeBookFileWriter fileWriter;

    public GradeBook() {
    students = new ArrayList<>();
    fileWriter = new DefaultGradeBookFileWriter();
    }
    public GradeBook(GradeBookFileWriter fileWriter) {
    students = new ArrayList<>();
    this.fileWriter = fileWriter;
    }

    public void save_to_file(String filename) {

    StringBuilder content = new StringBuilder();

    for (Student student : students) {
        content.append(student.getName())
               .append(",")
               .append(student.getRollNo())
               .append(",")
               .append(avgScores(student))
               .append(System.lineSeparator());
    }

    try {
        fileWriter.write(filename, content.toString());
    } catch (java.io.IOException e) {
        throw new GradeBookIOError(
                "Failed to save GradeBook to file: " + filename, e
        );
    }
    }

    /*
     * Returns all registered students.
     */
    public List<Student> getStudents() {
        return students;
    }

    /*
     * Adds a student to the GradeBook.
     * Duplicate roll numbers are not allowed.
     */
    public void addStudent(Student student) {

        if (student == null) {
            throw new IllegalArgumentException(
                    "Student cannot be null"
            );
        }

        for (Student s : students) {

            if (s.getRollNo().equals(student.getRollNo())) {
                throw new IllegalArgumentException(
                        "Duplicate roll number: " + student.getRollNo()
                );
            }
        }

        students.add(student);
    }

    /*
     * Finds a student using roll number.
     */
    public Student findStudent(String rollNo) {

        for (Student student : students) {

            if (student.getRollNo().equals(rollNo)) {
                return student;
            }
        }

        return null;
    }

    /*
     * Adds a score to a registered student.
     */
    public void addScore(Student student, double score) {

        if (student == null) {
            throw new IllegalArgumentException(
                    "Student cannot be null"
            );
        }

        /*
         * Check whether the student is registered
         * in this GradeBook.
         */
        Student registeredStudent = findStudent(student.getRollNo());

        if (registeredStudent == null) {
            throw new IllegalArgumentException(
                    "Student is not registered in the GradeBook"
            );
        }

        validateScore(score);

        /*
         * Maximum 6 scores are allowed.
         */
        if (registeredStudent.getScores().size() >= 6) {
            throw new IllegalArgumentException(
                    "Student cannot have more than 6 scores"
            );
        }

        registeredStudent.addScore(score);
    }

    /*
     * Validates an individual score.
     */
    public void validateScore(double score) {

        if (score < 0 || score > 100) {
            throw new IllegalArgumentException(
                    "Score must be between 0 and 100"
            );
        }
    }

    /*
     * Calculates total score.
     */
    public double sumScores(Student student) {

        double sum = 0;

        for (double score : student.getScores()) {
            sum += score;
        }

        return sum;
    }

    /*
     * Calculates average score.
     * Average is rounded to 2 decimal places.
     */
    public double avgScores(Student student) {

        if (student.getScores().isEmpty()) {
            return 0;
        }

        double average =
                sumScores(student) / student.getScores().size();

        return Math.round(average * 100.0) / 100.0;
    }

    /*
     * Validates the number of scores.
     *
     * Valid range: 1–6
     */
    public void validateScoreCount(Student student) {

        int count = student.getScores().size();

        if (count < 1 || count > 6) {
            throw new IllegalArgumentException(
                    "Student must have between 1 and 6 scores"
            );
        }
    }

    /*
     * Validates student name.
     */
    public void validateName(String name) {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(
                    "Name cannot be empty"
            );
        }

        if (name.length() > 50) {
            throw new IllegalArgumentException(
                    "Name cannot exceed 50 characters"
            );
        }

        if (!name.matches("[A-Za-z -]+")) {
            throw new IllegalArgumentException(
                    "Name can contain only letters, spaces, and hyphens"
            );
        }
    }

    /*
     * Determines letter grade.
     */
    public String letterGrade(double score) {

        if (score < 0 || score > 100) {
            throw new IllegalArgumentException(
                    "Score must be between 0 and 100"
            );
        }

        if (score >= 90) {
            return "A";
        }

        if (score >= 80) {
            return "B";
        }

        if (score >= 70) {
            return "C";
        }

        if (score >= 60) {
            return "D";
        }

        return "F";
    }
}