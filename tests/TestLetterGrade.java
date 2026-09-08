import gradebook.GradeBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLetterGrade {

    private final GradeBook gradeBook = new GradeBook();

    @Test
    void testLetterGradeValidClasses() {
        assertEquals("F", gradeBook.letterGrade(45));
        assertEquals("D", gradeBook.letterGrade(65));
        assertEquals("C", gradeBook.letterGrade(75));
        assertEquals("B", gradeBook.letterGrade(85));
        assertEquals("A", gradeBook.letterGrade(95));
    }

    @Test
    void testLetterGradeInvalidLowClass() {
        assertThrows(
                IllegalArgumentException.class,
                () -> gradeBook.letterGrade(-10)
        );
    }

    @Test
    void testLetterGradeInvalidHighClass() {
        assertThrows(
                IllegalArgumentException.class,
                () -> gradeBook.letterGrade(150)
        );
    }
}