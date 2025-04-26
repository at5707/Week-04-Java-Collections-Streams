import java.io.BufferedReader;
import java.io.FileReader;

public class FileReaderExample3 {
    public static void main(String[] args) {
        String filename="data2.txt";
        try {
            BufferedReader reader=new BufferedReader(new FileReader(filename));
            String line;
            while ((line=reader.readLine())!=null) {
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
}