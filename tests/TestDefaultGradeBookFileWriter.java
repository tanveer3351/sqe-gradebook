
import gradebook.DefaultGradeBookFileWriter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class TestDefaultGradeBookFileWriter {

    @TempDir
    Path tempDir;

    @Test
    void testWriteCreatesFileWithExpectedContent() throws IOException {

        DefaultGradeBookFileWriter writer
                = new DefaultGradeBookFileWriter();

        Path outputFile = tempDir.resolve("grades.txt");

        String content = "Ali,001,85.0"
                + System.lineSeparator();

        writer.write(outputFile.toString(), content);

        assertTrue(Files.exists(outputFile));

        assertEquals(content, Files.readString(outputFile));
    }

    @Test
    void testWriteThrowsIOExceptionWhenTargetIsDirectory() {

        DefaultGradeBookFileWriter writer
                = new DefaultGradeBookFileWriter();

        assertThrows(
                IOException.class,
                () -> writer.write(tempDir.toString(), "Test content")
        );
    }

}
