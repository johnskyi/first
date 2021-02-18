import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите желаемый размер креста");
        Scanner scanner = new Scanner(System.in);
        String size = scanner.nextLine();
        System.out.println("Введите маркер для рисунка");
        Scanner scanner2 = new Scanner(System.in);
        String pictures = scanner.nextLine();
        String[][] array = new String[Integer.parseInt(size)][Integer.parseInt(size)];
        for(int i = 0; i < array.length;i++)
        {
            for(int j = 0; j < array[i].length;j++)
            {
                if(i == j)
                {
                    array[i][j] = pictures;
                }
                if((i + j) == (Integer.parseInt(size) - 1))
                {
                    array[i][j] = pictures;
                }
                else if(i != j)
                {
                    array[i][j] = " ";
                }
            }
        }

        for(int i = 0; i < array.length;i++)
        {
            for(int j = 0; j < array[i].length; j++)
            {
                System.out.print(array[i][j]);
            }
            System.out.print("\n");
        }
    }
    }

