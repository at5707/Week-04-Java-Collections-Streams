import java.io.BufferedReader;
import java.io.FileReader;

public class ErrorLogReader {
    public static void main(String[] args) {
        String filePath="largefile.txt";
        try (BufferedReader reader=new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line=reader.readLine())!=null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading file: "+e.getMessage());
        }
    }
}