import com.google.common.io.Files;

import java.io.File;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        // TODO: write code copy content of sourceDirectory to destinationDirectory
        File folderFrom = new File(sourceDirectory);
        File folderTo = new File(destinationDirectory);
        File[]files = folderFrom.listFiles();
        try {
            for(File f : files)
            {
             if(f.isDirectory())
             {
                 File f1 = new File(destinationDirectory + File.separator +f.getName());
                 f1.mkdir();
                 copyFolder(f.getPath(),destinationDirectory + File.separator +f.getName());
                continue;
             }
             Files.copy(f,new File(destinationDirectory + File.separator + f.getName()));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
