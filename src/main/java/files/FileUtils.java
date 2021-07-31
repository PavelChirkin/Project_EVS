package files;

import java.io.File;
import java.io.IOException;


public class FileUtils {
    public static File createFileIfNotExist(String name) {
        File file = new File(name);
        if(!file.exists()) {
            try {
                file.createNewFile();
            }
            catch(IOException e) {
                System.out.println("Cannot create file");
                return null;
            }
        }

        return file;
    }
}
