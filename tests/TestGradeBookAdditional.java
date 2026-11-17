
import gradebook.GradeBook;
import gradebook.Student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestGradeBookAdditional {

    private GradeBook gradeBook;
    private Student student;

    @BeforeEach
    void setUp() {
        gradeBook = new GradeBook();
        student = new Student("Ali Khan", "S001");
    }

    @Test
    void testGetStudentsInitiallyEmpty() {
        assertTrue(gradeBook.getStudents().isEmpty());
    }

    @Test
    void testAddStudentSuccessfully() {
        gradeBook.addStudent(student);

        assertEquals(1, gradeBook.getStudents().size());
        assertSame(student, gradeBook.getStudents().get(0));
    }

    @Test
    void testAddNullStudentThrowsException() {
        assertThrows(
            IllegalArgumentException.class,
            () -> gradeBook.addStudent(null)
        );
    }

    @Test
    void testAddDuplicateRollNumberThrowsException() {
        gradeBook.addStudent(student);

        Student duplicate = new Student("Ahmed", "S001");

        assertThrows(
            IllegalArgumentException.class,
            () -> gradeBook.addStudent(duplicate)
        );
    }

    @Test
    void testFindStudentSuccessfully() {
        gradeBook.addStudent(student);

        assertSame(student, gradeBook.findStudent("S001"));
    }

    @Test
    void testFindStudentNotFound() {
        assertNull(gradeBook.findStudent("S999"));
    }

    @Test
    void testAverageWithNoScores() {
        assertEquals(0.0, gradeBook.avgScores(student));
    }

    @Test
    void testAverageWithScores() {
        student.addScore(80);
        student.addScore(90);
        student.addScore(85);

        assertEquals(85.0, gradeBook.avgScores(student));
    }

    @Test
    void testAverageRoundsToTwoDecimalPlaces() {
        student.addScore(80);
        student.addScore(81);
        student.addScore(82);

        assertEquals(81.0, gradeBook.avgScores(student));
    }

    @Test
    void testSumScores() {
        student.addScore(80);
        student.addScore(90);
        student.addScore(70);

        assertEquals(240.0, gradeBook.sumScores(student));
    }

    @Test
    void testValidateScoreAcceptsBoundaryValues() {
        assertDoesNotThrow(() -> gradeBook.validateScore(0));
        assertDoesNotThrow(() -> gradeBook.validateScore(100));
    }

    @Test
    void testValidateScoreRejectsInvalidValues() {
        assertThrows(
            IllegalArgumentException.class,
            () -> gradeBook.validateScore(-1)
        );

        assertThrows(
            IllegalArgumentException.class,
            () -> gradeBook.validateScore(101)
        );
    }

    @Test
    void testAddScoreRejectsNullStudent() {
        assertThrows(
            IllegalArgumentException.class,
            () -> gradeBook.addScore(null, 80)
        );
    }
}
