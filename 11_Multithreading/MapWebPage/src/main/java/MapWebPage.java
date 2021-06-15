import lombok.Data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.RecursiveAction;


@Data
public class MapWebPage extends RecursiveAction {

    public static void parse(String url) {

        try {
            FileWriter file = new FileWriter("src/main/resources/links.txt");
            Document doc = Jsoup.connect(url).maxBodySize(0).get();
            Elements linkElements = doc.select("a");
            linkElements.forEach(el -> {
                if (el.absUrl("href").matches("^(https://lenta.ru/)[a-zA-Z0-9./]{1,}")) {
                    try {
                        file.write(el.absUrl("href") + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void compute() {
    }
}
