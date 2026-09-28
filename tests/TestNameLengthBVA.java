import gradebook.GradeBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestNameLengthBVA {

    private final GradeBook gradeBook = new GradeBook();

    // Creates a valid name containing only letters
    // of the specified length.
    private String createName(int length) {
        return "A".repeat(length);
    }

    // TC-NAME-01: Name length = 0
    // Expected: Reject
    @Test
    void testNameLengthZero() {
        String name = createName(0);

        assertThrows(IllegalArgumentException.class, () -> {
            gradeBook.validateName(name);
        });
    }

    // TC-NAME-02: Name length = 1
    // Expected: Accept
    @Test
    void testNameLengthOne() {
        String name = createName(1);

        assertDoesNotThrow(() -> {
            gradeBook.validateName(name);
        });
    }

    // TC-NAME-03: Name length = 49
    // Expected: Accept
    @Test
    void testNameLengthFortyNine() {
        String name = createName(49);

        assertDoesNotThrow(() -> {
            gradeBook.validateName(name);
        });
    }

    // TC-NAME-04: Name length = 50
    // Expected: Accept
    @Test
    void testNameLengthFifty() {
        String name = createName(50);

        assertDoesNotThrow(() -> {
            gradeBook.validateName(name);
        });
    }

    // TC-NAME-05: Name length = 51
    // Expected: Reject
    @Test
    void testNameLengthFiftyOne() {
        String name = createName(51);

        assertThrows(IllegalArgumentException.class, () -> {
            gradeBook.validateName(name);
        });
    }
}
