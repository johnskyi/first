import java.util.Scanner;

public class Main {
  public static  final int MAX_CONTAINER = 12;
  public static final int MAX_BOXES = 27;


    public static void main(String[] args) {
        int carCount = 0;
        int containerCount = 0;

//        System.out.println("Введите количество ящиков");
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();
        if(Integer.parseInt(boxes) == 0)
        {
            carCount = 0;
            containerCount =0;
            System.out.println("Необходимо:");
            System.out.println("грузовиков - " + carCount + " шт.");
            System.out.println("контейнеров - "+ containerCount + " шт.");
        }
        else
            {
                for(int i = 1; i <= Integer.parseInt(boxes); i++) {

                        if ((i % MAX_BOXES) == 1) {

                            containerCount += 1;

                            if (containerCount % MAX_CONTAINER == 1) {
                                carCount += 1;

                                System.out.println("Грузовик: " + carCount);
                   }
                            System.out.println("\tКонтейнер: " + containerCount);
                        }
                    System.out.println("\t\tЯщик: " + i);
                }
                System.out.println("Необходимо:");
                System.out.println("грузовиков - " + carCount + " шт.");
                System.out.println("контейнеров - " + containerCount + " шт.");
            }


        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }

}
