package gradebook;
import java.io.IOException;
public interface GradeBookFileWriter {
    void write(String filename, String content) throws IOException;
}