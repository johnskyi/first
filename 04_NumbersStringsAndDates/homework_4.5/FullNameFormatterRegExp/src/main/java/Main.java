import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      boolean result = input.matches("[А-ЯЁа-яё\\-]{1,}\\s+[А-ЯЁа-яё]{1,}\\s+[А-ЯЁа-яё]{1,}");
      if(result)
      {
        String [] textArray = input.split("\\s+");
        System.out.println("Фамилия: " + textArray[0] + "\nИмя: " + textArray[1] + "\nОтчество: " + textArray[2]);
      }
      else
      {
        System.out.println("Введенная строка не является ФИО");
      }
    }
  }

}