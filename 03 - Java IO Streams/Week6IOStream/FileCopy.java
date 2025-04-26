import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {
    public static void main(String[] args) {
        String sourcePath="source.txt";
        String destinationPath="destination.txt";
        File sourceFile=new File(sourcePath);
        File destinationFile=new File(destinationPath);
        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist.");
            return;
        }
        try (FileInputStream fis=new FileInputStream(sourceFile);
             FileOutputStream fos=new FileOutputStream(destinationFile)){
                byte[] buffer=new byte[1024];
                int bytesRead;
                while ((bytesRead=fis.read(buffer))!=-1) {
                    fos.write(buffer,0,bytesRead);
                }
                System.out.println("File copied successfully to "+destinationPath);
            
        } catch (Exception e) {
            System.err.println("Error occurred during file operation: "+e.getMessage());
        }
    }
}