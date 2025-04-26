import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class UserInfoSaver {
    public static void main(String[] args) {
        BufferedReader reader=null;
        FileWriter writer=null;
        try {
            reader=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your name: ");
            String name=reader.readLine();
            System.out.print("Enter your age: ");
            String age=reader.readLine();
            System.out.print("Enter your favourite programming language: ");
            String language=reader.readLine();
            writer=new FileWriter("user_info.txt");
            writer.write("Name: "+name+"\n");
            writer.write("Age: "+age+"\n");
            writer.write("Favorite Programming Language: "+language+"\n");
            System.out.println("Information saved to user_info.txt");
        } catch (Exception e) {
            System.err.println("Error occurred: "+e.getMessage());
        } finally {
            try {
                if (reader!=null) {
                    reader.close();
                }
                if (writer!=null) {
                    writer.close();
                }
            } catch (Exception e) {
                System.err.println("Error closing resources: "+e.getMessage());
            }
        }
    }
}