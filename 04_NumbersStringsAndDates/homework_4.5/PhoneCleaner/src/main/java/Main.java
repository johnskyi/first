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
      String cleanInput = input.replaceAll("[^0-9]","");
      if(!cleanInput.matches("7{1}\\d{10}"))
      {
        if(cleanInput.matches("8{1}\\d{10}"))
        {
          cleanInput = cleanInput.replaceAll("8{1}","7");
          cleanInput = cleanInput.replaceAll("(\\d{1})(\\d{3})(\\d{3})(\\d{2})(\\d{2})", "+$1 ($2) $3 $4-$5");
          System.out.println(cleanInput);
        }
        if(cleanInput.matches("\\d{10}"))
        {
         cleanInput = '7' + cleanInput;
          cleanInput = cleanInput.replaceAll("(\\d{1})(\\d{3})(\\d{3})(\\d{2})(\\d{2})", "+$1 ($2) $3 $4-$5");
          System.out.println(cleanInput);
      }
        if(cleanInput.matches("\\d{7}"))
        {
          System.out.println("Неверный формат номера");
        }
        if(cleanInput.matches("\\d{12,}"))
        {
          System.out.println("Неверный формат номера");
        }
        if(cleanInput.matches("9{1}\\d{10}"))
        {
          System.out.println("Неверный формат номера");
        }
      }
      else
      {
        cleanInput = cleanInput.replaceAll("(\\d{1})(\\d{3})(\\d{3})(\\d{2})(\\d{2})", "+$1 ($2) $3 $4-$5");
        System.out.println(cleanInput);
      }
    }
  }

}
