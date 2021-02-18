import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {

        int day = 05;
        int month = 11;
        int year = 1989;

        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {
//        DateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy - EEEE");
//        Date date = new Date();
//        String birthdayList = "";
//        Calendar calendar = new GregorianCalendar(year, month - 1, day);
//        if(!(calendar.getTime().getTime() > date.getTime())) //Здесь условия проверки ввода даты позже текущей
//        {
//            birthdayList = "0" + " - " + dateformat.format(calendar.getTime()) + "\n";
//            for (int i = 1; i <= (2020 - year); i++) {
//                calendar.add(Calendar.YEAR, 1);
//                if (calendar.getTime().getTime() > date.getTime())//проверка, чтобы не выводило дату позже текущей
//                {
//                    break;
//                }
//                birthdayList += i + " - " + dateformat.format(calendar.getTime()) + "\n";
//            }
//        }
        String birthdayList = "";
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        DateTimeFormatter printFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy - EEEE");
        if(today.isAfter(birthday)) {
            birthdayList = "0" + " - " + printFormat.format(birthday) + "\n";
            int i = 1;
            while (today.isAfter(birthday)) {
                birthday = birthday.plusYears(1);
                if (today.isBefore(birthday)) {
                    break;
                }
                birthdayList += i + " - " + printFormat.format(birthday) + "\n";
                i++;

            }
        }
        else if(today.equals(birthday))
        {
            birthdayList = "0" + " - " + printFormat.format(birthday) + "\n";
        }
        return birthdayList;
    }
}
