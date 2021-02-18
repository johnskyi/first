public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    //TODO: напишите ваш код, результат вывести в консоль
    String vasyaMoney = text.substring(text.indexOf("5") , text.indexOf(" руб") );
   String petyaMoney =  text.substring(text.indexOf("7") , text.indexOf(" рубля"));
   String mashaMoney = text.substring(text.lastIndexOf("3") , text. lastIndexOf(" руб"));
   int totalMoney = Integer.parseInt(vasyaMoney) + Integer.parseInt(petyaMoney) + Integer.parseInt(mashaMoney);
   System.out.println(totalMoney);

  }

}