import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamExample {
    public static void main(String[] args) {
        try {
            PipedOutputStream outputStream = new PipedOutputStream();
            PipedInputStream inputStream = new PipedInputStream(outputStream);
            Thread writer = new Thread(() -> {
                try (BufferedWriter writerStream = new BufferedWriter(new OutputStreamWriter(outputStream))) {
                    String[] messages = {
                        "Hello from writer thread.",
                        "Sending some data through the pipe.",
                        "This is the last message."
                    };
                    for (String msg : messages) {
                        writerStream.write(msg);
                        writerStream.newLine();
                        writerStream.flush();
                        Thread.sleep(1000);
                    }
        } catch (IOException | InterruptedException e) {
            System.err.println("Writer error: "+e.getMessage());
        }
    });
    Thread reader = new Thread(() -> {
        try (BufferedReader readerStream = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = readerStream.readLine()) != null) {
                System.out.println("Reader received: " + line);
            }
        } catch (IOException e) {
            System.err.println("Reader error: " + e.getMessage());
        }
    });
    reader.start();
    writer.start();
    writer.join();
    reader.join();
    } catch (IOException | InterruptedException e) {
        System.err.println("Main thread error: "+e.getMessage());
    }
    }
}
