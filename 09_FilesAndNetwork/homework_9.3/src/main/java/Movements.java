import lombok.*;
import org.checkerframework.checker.units.qual.C;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Movements {
    public static final String LIST_FILE = "src/test/resources/movementList.csv";
    public static final String LIST_FLOAT_FILE = "src/test/resources/movementListFloat.csv";
    public static final String LIST_INTEGER_FILE = "src/test/resources/movementListInteger.csv";
    @Getter
    List<Entry> movements = new ArrayList<>();

    public Movements(String pathMovementsCsv) {
        movements.addAll(Entry.parserMovements(pathMovementsCsv));
    }


    public double getExpenseSum() {
        return getMovements().stream()
                .map(Entry::getConsumption)
                .reduce((s1, s2) -> s1 + s2)
                .get();

    }

    public double getIncomeSum() {
        return getMovements().stream()
                .map(Entry::getComing)
                .reduce((s1, s2) -> s1 + s2)
                .get();
    }

    public void getDescriptionByCompany() {
       Map<String,Double>map = getMovements().stream()
               .collect(Collectors.groupingBy(Entry::getDescription,
                       Collectors.summingDouble(Entry::getConsumption)));
       map.forEach((k,v) -> System.out.println(k + "-----------" + v));
    }
}
