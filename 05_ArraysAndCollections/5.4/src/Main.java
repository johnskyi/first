import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        TreeMap<String,String> phoneBook = new TreeMap();
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            System.out.println("Введите имя, номер телефона или LIST");
            String input = scanner.nextLine();
            //Команда LIST
            if(input.equals("LIST"))
            {
                for(String key: phoneBook.keySet())
                {
                    System.out.println(key + " <----> " + phoneBook.get(key));
                }
            }
            //Если ввели имя
            if(input.matches("[А-ЯЁа-яё\\-\\s*]{1,}"))
            {
                //Если имя уже есть в базе
                if(phoneBook.containsKey(input))
                {
                    System.out.println(input + " <----> " + phoneBook.get(input));
                }
                //Если новое имя
                else
                {
                    System.out.println("Введите номер телефона");
                    String numberPhone = scanner.nextLine();
                    phoneBook.put(input,cleanNumberPhone(numberPhone));
                    System.out.println("Номер сохранен");

                }
            }
            //Если ввели номер
            if(input.matches("[0-9\\(\\)\\-\\s*\\+]{1,}"))
            {
                //Если номер есть в базе
                if(phoneBook.containsValue(cleanNumberPhone(input)))
                {
                    searchKeyFromValue(phoneBook,cleanNumberPhone(input));
                }
                //Если номера нет в базе
                else
                {
                    System.out.println("Введите имя");
                    String name = scanner.nextLine();
                    phoneBook.put(name,cleanNumberPhone(input));
                    System.out.println("Номер сохранен");
                }
            }
        }
    }
    public static void searchKeyFromValue(TreeMap<String,String>map,String input)
    {
        for(String key: map.keySet())
        {
            if(map.get(key).equals(input)) {
                System.out.println(key + " <----> " + map.get(key));
                continue;
            }
        }
    }
    public static String cleanNumberPhone(String numberPhone)
    {
        String cleanNumber = numberPhone.replaceAll("[^0-9]", "");
         cleanNumber = cleanNumber.replaceAll("(\\d{1})(\\d{3})(\\d{3})(\\d{2})(\\d{2})", "+7 ($2) $3 $4-$5");
        return cleanNumber;
    }

}
