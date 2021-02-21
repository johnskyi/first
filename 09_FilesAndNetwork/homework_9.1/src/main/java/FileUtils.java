import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        long sizeAllFiles =0;

        File folder = new File(path);
        File[] files = folder.listFiles();
        try {
            for (File file : files) {
                if (file.isDirectory()) {
                   sizeAllFiles += calculateFolderSize(file.getPath());
                    continue;
                }
                sizeAllFiles += file.length();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sizeAllFiles;
    }
}
