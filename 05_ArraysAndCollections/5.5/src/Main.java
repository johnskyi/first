import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> carNumbers = new ArrayList<>();
        String[] letters = {"С","М","Т","В","А","Р","О","Н","Е","У"};
        int[] numbers = {111,222,333,444,555,666,777,888,999};
        System.out.print("Генерируем список автомобильных номеров......");
        for(int i = 1;i < 198;i++)
        {
            for(int j = 0; j < numbers.length;j++)
            {
                for(int f = 0;f < letters.length;f++)
                {
                    for(int a = 0;a < letters.length;a++)
                    {
                        for(int b = 0;b < letters.length;b++)
                        {
                            carNumbers.add((letters[f] + numbers[j] + letters[b]) + letters[a] + i);
                        }
                    }
                }
            }

        }
        System.out.println("\nГенерация автомобильных номеров завершена. Количество записей в списке: " + carNumbers.size());
        Collections.sort(carNumbers);
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(carNumbers);
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.addAll(carNumbers);
        System.out.println("Введите номер который хотите найти в формате  — пример, A111BC197, Y777HC66,");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String inputCarNumber = scanner.nextLine();
            System.out.print("Поиск прямым перебором: ");
            long startTime = System.nanoTime();
            if(carNumbers.contains(inputCarNumber))
            {
                System.out.print("номер найден,  поиск занял " + (System.nanoTime() - startTime) +" нс\n");
            }
            else
            {
                System.out.print("номер не найден\n");
            }
            System.out.print("Бинарный поиск: ");
            startTime = System.nanoTime();
            if(Collections.binarySearch(carNumbers,inputCarNumber) >= 0)
            {
                System.out.print("номер найден,  поиск занял " + (System.nanoTime() - startTime) +" нс\n");
            }
            else
            {
                System.out.print("номер не найден\n");
            }
            System.out.print("Поиск в HashSet: ");
            startTime = System.nanoTime();
            if(hashSet.contains(inputCarNumber))
            {
                System.out.print("номер найден,  поиск занял " + (System.nanoTime() - startTime) +" нс\n");
            }
            else
            {
                System.out.print("номер не найден\n");
            }
            System.out.print("Поиск в TreeSet: ");
            startTime = System.nanoTime();
            if(treeSet.contains(inputCarNumber))
            {
                System.out.print("номер найден,  поиск занял " + (System.nanoTime() - startTime) +" нс\n");
            }
            else
            {
                System.out.print("номер не найден\n");
            }
            continue;
        }
    }
}
