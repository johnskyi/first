import lombok.AllArgsConstructor;
import lombok.Data;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;

@Data
@AllArgsConstructor
public class ImageResizer implements Runnable
{
    private File[] files;

    private int newWidth;

    private String dstFolder;

    private long start;


    @Override
    public void run() {
        try
        {
            for(File file : files)
            {
                BufferedImage image = ImageIO.read(file);
                if(image == null) {
                    continue;
                }

                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth)
                );

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(resize(image,newWidth,newHeight), "jpg", newFile);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Finished: " + (System.currentTimeMillis() - start) + "ms");
    }
    public static  BufferedImage resize(BufferedImage image, int targetWidth, int targetHeight)
    {

    BufferedImage newImage = Scalr.resize(image, targetWidth,targetHeight);
    return newImage;

    }

}
