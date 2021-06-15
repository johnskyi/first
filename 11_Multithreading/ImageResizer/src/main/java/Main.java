import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main
{
    private static int newWidth = 300;
    public static void main(String[] args)
    {
        String srcFolder = "src/main/java/resourses/images";
        String dstFolder = "src/main/java/resourses/imageResize";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();
        int coresCount =  files.length / Runtime.getRuntime().availableProcessors(); // Делим  на количество ядер процессора

        for(int i = 0; i < Runtime.getRuntime().availableProcessors(); i++)
        {
            File[] file = new File[coresCount];
            System.arraycopy(files,i * coresCount,file,0,file.length);
            new Thread(new ImageResizer(file, newWidth, dstFolder, start)).start();
        }

    }
}
