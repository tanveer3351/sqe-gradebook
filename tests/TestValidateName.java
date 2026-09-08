import gradebook.GradeBook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestValidateName {

    private final GradeBook gradeBook = new GradeBook();

    @ParameterizedTest
    @ValueSource(strings = {"Ali Khan", "Ali-Khan", "Muhammad Ali"})
    void testValidNames(String name) {

        assertDoesNotThrow(
                () -> gradeBook.validateName(name)
        );
    }

    @Test
    void testEmptyName() {

        assertThrows(
                IllegalArgumentException.class,
                () -> gradeBook.validateName("")
        );
    }

    @Test
    void testOverLengthName() {

        String name = "A".repeat(51);

        assertThrows(
                IllegalArgumentException.class,
                () -> gradeBook.validateName(name)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ali123", "Ali@Khan"})
    void testInvalidCharacters(String name) {

        assertThrows(
                IllegalArgumentException.class,
                () -> gradeBook.validateName(name)
        );
    }

    @Test
    void testNullName() {

        assertThrows(
                IllegalArgumentException.class,
                () -> gradeBook.validateName(null)
        );
    }
}