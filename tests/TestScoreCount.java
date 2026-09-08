import gradebook.GradeBook;
import gradebook.Student;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestScoreCount {

    @ParameterizedTest
    @ValueSource(ints = {0, 8})
    void testInvalidScoreCount(int scoreCount) {

        GradeBook gradeBook = new GradeBook();
        Student student = new Student("Ali Khan", "S001");

        for (int i = 0; i < scoreCount; i++) {
            student.addScore(50);
        }

        assertThrows(
                IllegalArgumentException.class,
                () -> gradeBook.validateScoreCount(student)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {3})
    void testValidScoreCount(int scoreCount) {

        GradeBook gradeBook = new GradeBook();
        Student student = new Student("Ali Khan", "S002");

        for (int i = 0; i < scoreCount; i++) {
            student.addScore(50);
        }

        assertDoesNotThrow(
                () -> gradeBook.validateScoreCount(student)
        );
    }
}