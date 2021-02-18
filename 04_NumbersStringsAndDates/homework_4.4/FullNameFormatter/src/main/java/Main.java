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
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
      int count = 0;
      boolean language = true;
      for(int i = 0; i < input.length();i++) //1040 - 1103 пробел 32 тире 45
      {
        if(((int)input.charAt(i) <= 1103 && (int)input.charAt(i) >= 1040) | (int)input.charAt(i) == 32 | (int)input.charAt(i) == 45)
        {
          language = true;
          continue;
        }
        else
        {
          language = false;
          break;
        }
      }
      for(int i = 0; i < input.length(); i++)
      {
        if(input.charAt(i) == ' ')
        {
          count++;
        }

      }
      if(count == 2 && language)
      {

        String surname = input.substring(0,input.indexOf(" "));
        surname = surname.trim();
        String name =input.substring(input.indexOf(" "), input.lastIndexOf(" "));
        name = name.trim();
        String patronymic = input.substring(input.lastIndexOf(" "));
        patronymic = patronymic.trim();
        System.out.println("Фамилия: " + surname + "\nИмя: " + name + "\nОтчество: " + patronymic);

      }
      else
      {
        System.out.println("Введенная строка не является ФИО");
      }






    }
  }

}