import gradebook.Roster;
import gradebook.Student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestClassAverage {

    private Roster roster;

    @BeforeEach
    void setUp() {
        // @BeforeEach provides a fresh roster before every test.
        roster = new Roster();
    }

    @Test
    void testClassAverageEmptyRoster() {
        assertEquals(0, roster.class_average());
    }

    @Test
void testClassAverageSingleStudent() {

    Student student = new Student("Ali", "001");

    student.addScore(80);
    student.addScore(90);

    roster.addStudent(student);

    assertEquals(85.0, roster.class_average());
    }

    @Test
void testClassAverageMultipleStudents() {

    Student student1 = new Student("Ali", "001");
    student1.addScore(80);
    student1.addScore(90);

    Student student2 = new Student("Ahmed", "002");
    student2.addScore(70);
    student2.addScore(80);

    Student student3 = new Student("Sara", "003");
    student3.addScore(90);
    student3.addScore(100);

    roster.addStudent(student1);
    roster.addStudent(student2);
    roster.addStudent(student3);

    assertEquals(85.0, roster.class_average());
    }
}