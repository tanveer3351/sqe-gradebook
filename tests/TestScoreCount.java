import gradebook.GradeBook;
import gradebook.Student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestScoreCount {

    private GradeBook gradeBook;
    private Student student;

    @BeforeEach
    void setUp() {
        // @BeforeEach runs before every test, providing fresh test data.
        gradeBook = new GradeBook();
        student = new Student("Ali Khan", "S001");
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 7})
    void testInvalidScoreCount(int scoreCount) {

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

        for (int i = 0; i < scoreCount; i++) {
            student.addScore(50);
        }

        assertDoesNotThrow(
                () -> gradeBook.validateScoreCount(student)
        );
    }
}