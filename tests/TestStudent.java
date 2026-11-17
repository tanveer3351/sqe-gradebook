
import gradebook.Student;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestStudent {

    @Test
    void testSetName() {
        Student student = new Student("Ali", "001");

        student.setName("Ahmed");

        assertEquals("Ahmed", student.getName());
    }

    @Test
    void testSetRollNo() {
        Student student = new Student("Ali", "001");

        student.setRollNo("002");

        assertEquals("002", student.getRollNo());
    }

    @Test
    void testGetScores() {
        Student student = new Student("Ali", "001");

        student.addScore(85);
        student.addScore(90);

        assertEquals(List.of(85.0, 90.0), student.getScores());
    }

    @Test
    void testClearScores() {
        Student student = new Student("Ali", "001");

        student.addScore(85);
        student.addScore(90);

        student.clearScores();

        assertTrue(student.getScores().isEmpty());
    }

    @Test
    void testAddScoreRejectsInvalidValues() {
        Student student = new Student("Ali", "001");

        assertThrows(
            IllegalArgumentException.class,
            () -> student.addScore(-1)
        );

        assertThrows(
            IllegalArgumentException.class,
            () -> student.addScore(101)
        );
    }
}
