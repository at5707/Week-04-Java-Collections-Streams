package file;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class FileProcessor {
	// Method to write content to a file
    public void writeToFile(String filename, String content) throws IOException {
        Files.write(Paths.get(filename), content.getBytes());
    }

    // Method to read content from a file
    public String readFromFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }

    // Inner test class to keep the test code in the same file
    public static class FileProcessorTest {

        FileProcessor fileProcessor = new FileProcessor();

        @Test
        public void testWriteAndReadFile() throws IOException {
            String filename = "testfile.txt";
            String content = "Hello, World!";

            // Write content to file
            fileProcessor.writeToFile(filename, content);

            // Check if the file exists
            assertTrue(Files.exists(Path.of(filename)));

            // Check if the content is correctly written and read
            String readContent = fileProcessor.readFromFile(filename);
            assertEquals(content, readContent);

            // Cleanup: delete the test file
            Files.deleteIfExists(Path.of(filename));
        }

        @Test
        public void testReadFromNonExistentFile() {
            String filename = "nonexistentfile.txt";

            // Check IOException when trying to read a non-existent file
            assertThrows(IOException.class, () -> {
                fileProcessor.readFromFile(filename);
            });
        }
    }
}
