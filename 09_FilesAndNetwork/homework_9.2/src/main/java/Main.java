import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Введите путь до папки, которую необходимо копировать: ");
        Scanner scanner = new Scanner(System.in);
        String pathFromCopy = scanner.nextLine().trim();
        System.out.println("Введите путь до папки,в которую нужно скопировать: ");
        Scanner scanner1 = new Scanner(System.in);
        String pathToCopy = scanner1.nextLine().trim();
        ///home/evgeniy/lesson
        FileUtils.copyFolder(pathFromCopy,pathToCopy);
        System.out.println("Копирование завершено!");
    }
}
