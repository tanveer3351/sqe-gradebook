import gradebook.GradeBook;
import gradebook.Student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TestAddScoreParameterized {

    private GradeBook gradeBook;
    private Student student;

    @BeforeEach
    void setUp() {
        gradeBook = new GradeBook();
        student = new Student("Ali Khan", "S001");

        gradeBook.addStudent(student);
    }

    static Stream<Arguments> addScoreCases() {

        return Stream.of(

            // Valid score at lower boundary
            Arguments.of(
                "valid score - 0",
                0.0,
                false,
                false,
                false
            ),

            // Valid score at upper boundary
            Arguments.of(
                "valid score - 100",
                100.0,
                false,
                false,
                false
            ),

            // Invalid score below 0
            Arguments.of(
                "invalid score - below 0",
                -1.0,
                true,
                false,
                false
            ),

            // Invalid score above 100
            Arguments.of(
                "invalid score - above 100",
                101.0,
                true,
                false,
                false
            ),

            // Student is not registered
            Arguments.of(
                "unregistered student",
                50.0,
                true,
                true,
                false
            ),

            // More than 6 scores
            Arguments.of(
                "more than 6 scores",
                50.0,
                true,
                false,
                true
            )
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("addScoreCases")
    void testAddScoreEdgeCases(
            String testName,
            double score,
            boolean shouldThrow,
            boolean unregistered,
            boolean maximumScores
    ) {

        final Student testStudent;

        if (unregistered) {
            testStudent = new Student("Unregistered", "S999");
        } else {
            testStudent = student;
        }

        if (maximumScores) {
            for (int i = 0; i < 6; i++) {
                student.addScore(50);
            }
        }

        if (shouldThrow) {

            assertThrows(
                IllegalArgumentException.class,
                () -> gradeBook.addScore(testStudent, score)
            );

        } else {

            assertDoesNotThrow(
                () -> gradeBook.addScore(testStudent, score)
            );
        }
    }
}