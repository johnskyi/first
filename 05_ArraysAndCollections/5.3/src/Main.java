import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<String> emails = new TreeSet<>();
        System.out.println("Введите команду в формате" +
                " \n LIST - выводит список электронных адресов " +
                "\n ADD <электронный адрес> - добавлет электронный адес в список");
        while(true)
        {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] cleanInput = input.split("\\s+");
        if(cleanInput[0].equals("LIST"))
        {   for(String emailList: emails)
        {
            System.out.println(emailList);
        }
            continue;
        }
        if(cleanInput[0].equals("ADD"))
        {
            if(cleanInput[1].matches("[a-z0-9\\-\\_]{1,}[@]{1,1}[a-z0-9\\-\\_]{1,}\\.[a-z]{1,}"))
            {
                emails.add(cleanInput[1]);
                System.out.println("Электронный адрес добавлен в список");
                continue;
            }
            else
            {
                System.out.println("Неверно введен электронный адрес");
                continue;
            }
        }
        else
            {
                System.out.println("Неверно введена команда");
                continue;
            }
        }

    }
}
