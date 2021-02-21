import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите путь до папки: ");
       Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine().trim();
       ///home/evgeniy/lesson
        long sizeAllFiles = FileUtils.calculateFolderSize(path);
        System.out.println("Размер папки " + path + " cоставляет " + sizeAllFiles / 1000 + " Кб");
    }
}
