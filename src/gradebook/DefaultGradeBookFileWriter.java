package gradebook;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class DefaultGradeBookFileWriter implements GradeBookFileWriter {
    @Override
    public void write(String filename, String content) throws IOException {
        Files.writeString(Path.of(filename), content);
    }}