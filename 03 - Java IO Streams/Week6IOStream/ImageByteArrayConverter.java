import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ImageByteArrayConverter {
    public static void main(String[] args) {
        String originalImagePath="original.jpg";
        String outputImagePath="copied.jpg";
        try {
            byte[] imageBytes=imageToByteArray(originalImagePath);
            byteArrayToImage(imageBytes,originalImagePath);
            long originalSize=new File(originalImagePath).length();
            long copiedSize=new File(outputImagePath).length();
            System.out.println("Original size: " + originalSize + " bytes");
            System.out.println("Copied size  : " + copiedSize + " bytes");
            if (originalSize==copiedSize) {
                System.out.println("Verification passed: Files are identical in size.");
            } else {
                System.out.println("Verification failed: File sizes differ.");
            }
        } catch (Exception e) {
            System.err.println("IO Error: "+e.getMessage());
        }
    }
    private static byte[] imageToByteArray(String filePath) throws IOException {
        try (InputStream inputStream = new FileInputStream(filePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            byte[] buffer=new byte[1024];
            int bytesRead;
            while ((bytesRead=inputStream.read(buffer))!=-1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
    }
}
private static void byteArrayToImage(byte[] imageBytes,String filePath) throws IOException {
    try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            OutputStream outputStream = new FileOutputStream(filePath)) {
                byte[] buffer=new byte[1024];
                int bytesRead;
                while ((bytesRead=bais.read(buffer))!=-1) {
                    outputStream.write(buffer,0,bytesRead);
                }
        }
    }
}