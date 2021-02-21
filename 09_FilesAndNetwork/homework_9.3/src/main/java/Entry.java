import lombok.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Entry {
    private String account, numberAccount,
            currency, date, reference, description;
    private double coming, consumption;

    public static List<Entry> parserMovements(String path) {
        List<Entry> entryList = new ArrayList<>();
        String[] fragments = new String[7];
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                if (line.equals("Тип счёта,Номер счета,Валюта,Дата операции,Референс проводки,Описание операции,Приход,Расход")) {
                    continue;
                }
                fragments = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", 8);
                String[] array = fragments[5].split("\\s{3,}");
                fragments[5] = array[1];
                fragments[6] = fragments[6].replace('"', ' ').replace(',', '.');
                fragments[7] = fragments[7].replace('"', ' ').replace(',', '.');
                entryList.add(Entry.builder()
                        .account(fragments[0])
                        .numberAccount(fragments[1])
                        .currency(fragments[2])
                        .date(fragments[3])
                        .reference(fragments[4])
                        .description(fragments[5])
                        .coming(Double.parseDouble(fragments[6]))
                        .consumption(Double.parseDouble(fragments[7]))
                        .build());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return entryList;
    }
}

