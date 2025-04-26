import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyComparison {
    private static final int BUFFER_SIZE=4096;
    public static void main(String[] args) {
        String sourceFile="largefile.txt";
        String destUnbuffered="dest_unbuffered.txt";
        String destBuffered="dest_buffered.txt";
        long unbufferedTime=copyUsingUnbufferedStreams(sourceFile,destUnbuffered);
        System.out.println("Unbuffered copy time: " + unbufferedTime + " ns");
        long bufferedTime = copyUsingBufferedStreams(sourceFile, destBuffered);
        System.out.println("Buffered copy time:   " + bufferedTime + " ns");
        System.out.printf("Buffered is %.2fx faster than Unbuffered.%n",
                (double) unbufferedTime / bufferedTime);
    }
    public static long copyUsingUnbufferedStreams(String source,String dest) {
        long startTime=System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)){
            byte[] buffer=new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead=fis.read(buffer))!=-1) {
                fos.write(buffer,0,bytesRead);
            }
        } catch (Exception e) {
            System.err.println("Error (unbuffered): "+e.getMessage());
    }
    return System.nanoTime()-startTime;
}
public static long copyUsingBufferedStreams(String source, String dest) {
        long startTime = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.err.println("Error (buffered): " + e.getMessage());
        }

        return System.nanoTime() - startTime;
    }
}
