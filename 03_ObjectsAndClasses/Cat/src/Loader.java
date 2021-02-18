import java.util.Scanner;

public class Loader
{
    public static void main(String[] args)
    {
        Cat felix = new Cat();
        Cat murka = new Cat();
        System.out.println(" Вес felix: " + felix.getWeight());
        felix.feed(150.0);
        System.out.println(" Вес felix после еды: " + felix.getWeight());
        System.out.println("felix  съел: " + felix.howMuchFeed() + " грамм");
        felix.pee();
        System.out.println(" Вес felix после Pee: " + felix.getWeight());
        System.out.println("Количество существующих кошек: " + Cat.getCount());
        while(!murka.getStatus().equals("Dead")) {

            murka.meow();
        }
        System.out.println("Количество существующих кошек: " + Cat.getCount());
        murka.meow();
        murka.feed(2000.0);
        System.out.println("Количество существующих кошек: " + Cat.getCount());
        Cat vasya = getKitten();
        Cat bars = getKitten();
        Cat puch = getKitten();
        System.out.println("Количество существующих кошек: " + Cat.getCount());
        Cat tom = Cat.copyCat(vasya);
        System.out.println(tom.getName() + "  " +  tom.getWeight());
        System.out.println("Количество существующих кошек: " + Cat.getCount());
        vasya.feed(2000.0);
        System.out.println("Вес tom "+tom.getWeight());





        }
        private static  Cat getKitten()
        {
            return new Cat(1100.0,"Васька");
        }



    }
