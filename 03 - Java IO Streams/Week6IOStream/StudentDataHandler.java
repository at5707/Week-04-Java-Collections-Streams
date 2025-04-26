import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class StudentDataHandler {
    private static final String FILE_NAME="students.dat";
    public static void main(String[] args) {
        int[] rollNumbers={101,102,103};
        String[] names={"Alice","Bob","Charlie"};
        double[] gpas={3.9,3.5,3.8};
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            for (int i = 0; i < rollNumbers.length; i++) {
                dos.writeInt(rollNumbers[i]);
                dos.writeUTF(names[i]);
                dos.writeDouble(gpas[i]);
            }
            System.out.println("Student data written to file successfully.");
        } catch (Exception e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("\nReading student data from file:");
            while (dis.available()>0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (Exception e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}