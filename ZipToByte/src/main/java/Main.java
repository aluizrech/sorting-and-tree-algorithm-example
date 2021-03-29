import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {

    public static void main(String[] args) throws IOException {
        String origem = "C:\\Zip\\Examplo.zip";
        String destino = "C:\\Zip\\";
        File file = new File(origem);
        ByteArrayInputStream bis = new ByteArrayInputStream(FileUtils.readFileToByteArray(file));
        ZipInputStream zipStream = new ZipInputStream(bis);
        ZipEntry ze;
        byte buff[] = new byte[16384];
        int readBytes;

        while((ze = zipStream.getNextEntry()) != null) {
            String fileName = destino + ze.getName();
            if(ze.isDirectory()) {
                Files.createDirectories(Paths.get(fileName));
                continue;
            }
            zipStream.readAllBytes();
            FileOutputStream outFile = new FileOutputStream(fileName);
            while((readBytes = zipStream.read(buff)) != -1) {
                outFile.write(buff, 0, readBytes);
            }
            outFile.close();
        }

    }


}
