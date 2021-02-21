import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;


public class Main {
    public static final String WEB_SITE = "https://lenta.ru/";
    public static final String DIRECTORY_PATH = "src/main/resources/images/";

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect(WEB_SITE).get();
            Elements img = doc.getElementsByTag("img");
            img.forEach(element -> {
                String src = element.absUrl("src");
                try {
                    getImage(src);
                } catch (IOException e) {
                    e.getMessage();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void getImage(String src) throws IOException{
        int indexName = src.lastIndexOf("/");
        if (indexName == src.length()) {
            src = src.substring(1, indexName);
            indexName = src.lastIndexOf("/");
        }
        String name = src.substring(indexName + 1, src.length());
        URL url = new URL(src);
        BufferedImage img = ImageIO.read(url);
        File file = new File(DIRECTORY_PATH  + name);
        ImageIO.write(img, "jpg", file);
        System.out.println(name);
    }

}
