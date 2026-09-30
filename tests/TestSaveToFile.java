import gradebook.GradeBook;
import gradebook.GradeBookFileWriter;
import gradebook.GradeBookIOError;
import gradebook.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class TestSaveToFile {
    private GradeBook gradeBook;
    private GradeBookFileWriter mockWriter;
    @BeforeEach
    void setUp() {
        // Create a Mockito mock instead of using a real file writer.
        mockWriter = mock(GradeBookFileWriter.class);
        // Inject the mock into GradeBook.
        gradeBook = new GradeBook(mockWriter);
    }
    @Test
    void testSaveToFileWritesExpectedContent() throws IOException {
        Student student = new Student("Ali", "001");
        student.addScore(80);
        student.addScore(90);
        gradeBook.addStudent(student);
        gradeBook.save_to_file("grades.txt");
        String expectedContent =
                "Ali,001,85.0" + System.lineSeparator();
        verify(mockWriter).write("grades.txt", expectedContent);
    }
    @Test
    void testSaveToFileHandlesIOException() throws IOException {
        doThrow(new IOException("Disk error"))
                .when(mockWriter)
                .write(anyString(), anyString());
        GradeBookIOError exception = assertThrows(
                GradeBookIOError.class,
                () -> gradeBook.save_to_file("grades.txt")
        );
        assertTrue(exception.getMessage().contains("Failed to save GradeBook"));
        assertInstanceOf(IOException.class, exception.getCause());
    }
}