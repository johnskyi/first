import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> toDoList = new ArrayList<>();
        toDoList.add("Сходить на тренировку");
        toDoList.add("Сделать домашнее задание");
        toDoList.add("Убраться дома");
        toDoList.add("Приготовить поесть");
        System.out.println("Выберите действие и введите одну из комманд: \n ADD <номер> <содержание дела> \n ADD <содержание дела>\n EDIT <номер> <содержание дела> \n DELETE <номер дела> \n LIST");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] cleanInput = input.split("\\s+");
            //Команда LIST
            if (cleanInput[0].equals("LIST")) {
                System.out.println("Список дел:");
                for (int i = 0; i < toDoList.size(); i++) {
                    System.out.println(i + " - " + toDoList.get(i));
                }
                continue;
            }
            //Команда ADD
            if (cleanInput[0].equals("ADD")) {
                if (cleanInput[1].matches("[0-9]{1,}")){
                    if(Integer.parseInt(cleanInput[1]) > (toDoList.size() - 1))
                    {
                        System.out.println("Дело с таким номером в списке отсуствует");
                        continue;
                    }
                    //действие с добавлением дела на определенную позицию
                    String affairs = "";
                    for(int i = 2;i < cleanInput.length;i++)
                    {
                        affairs += cleanInput[i] + " ";
                    }
                    toDoList.add(Integer.parseInt(cleanInput[1]),affairs);
                    System.out.println("Новое дело добавлено");
                }
                if (cleanInput[1].matches("[А-ЯЁа-яё ]{1,}")) {
                    //добавить действие с добавлением дела в конец списка
                    String affairs = "";
                    for(int i = 1;i < cleanInput.length;i++)
                    {
                        affairs += cleanInput[i] + " ";
                    }
                    toDoList.add(affairs);
                    System.out.println("Новое дело добавлено");
                }
                continue;
            }
            //Команда EDIT
            if (cleanInput[0].equals("EDIT")) {
                if(Integer.parseInt(cleanInput[1]) > (toDoList.size() - 1))
                {
                    System.out.println("Дело с таким номером в списке отсуствует");
                    continue;
                }
                //добавить действие по команде EDIT
                toDoList.remove(Integer.parseInt(cleanInput[1]));
                String affairs = "";
                for(int i = 2;i < cleanInput.length;i++)
                {
                    affairs += cleanInput[i] + " ";
                }
                toDoList.add(Integer.parseInt(cleanInput[1]),affairs);
                System.out.println("Дело исправлено");
                continue;
            }
            //Команда DELETE
            if (cleanInput[0].equals("DELETE")) {
                if(Integer.parseInt(cleanInput[1]) > (toDoList.size() - 1))
                {
                    System.out.println("Дело с таким номером в списке отсуствует");
                    continue;
                }
                //добавить действие по команде DELETE
                toDoList.remove(Integer.parseInt(cleanInput[1]));
                System.out.println("Дело удалено");
                continue;
            } else {
                System.out.println("Введенная команда не верна!");
            }
        }


    }
}
