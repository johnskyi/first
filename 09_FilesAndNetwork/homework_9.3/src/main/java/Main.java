import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Movements movements = new Movements(Movements.LIST_FLOAT_FILE);
        movements.getMovements().forEach(System.out::println);
        System.out.println("Сумма расходов: " + movements.getExpenseSum());
        System.out.println("Сумма доходов: " + movements.getIncomeSum());
        System.out.println("Сумма расходов по организациям: ");
        movements.getDescriptionByCompany();

    }
}
