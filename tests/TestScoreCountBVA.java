import gradebook.GradeBook;
import gradebook.Student;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestScoreCountBVA {

    private final GradeBook gradeBook = new GradeBook();

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 6})
    void testValidScoreCountBVA(int scoreCount) {

        Student student = new Student("Ali Khan", "BVA001");

        for (int i = 0; i < scoreCount; i++) {
            student.addScore(50);
        }

        assertDoesNotThrow(
                () -> gradeBook.validateScoreCount(student)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 7})
    void testInvalidScoreCountBVA(int scoreCount) {

        Student student = new Student("Ali Khan", "BVA002");

        for (int i = 0; i < scoreCount; i++) {
            student.addScore(50);
        }

        assertThrows(
                IllegalArgumentException.class,
                () -> gradeBook.validateScoreCount(student)
        );
    }
}