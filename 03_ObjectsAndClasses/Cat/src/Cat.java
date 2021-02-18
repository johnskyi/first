
public class Cat
{
    public static final int EYES_COUNT = 2;
    public static final double MIN_WEIGHT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;
    private double originWeight;
    private double weight;
    private double minWeight;
    private double maxWeight;
    private double grams;
    public static int count = 0;
    public  boolean life;
    public boolean isAlive;
    private  ColorCat  catColor;
    private String name;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = MIN_WEIGHT;
        maxWeight = MAX_WEIGHT;
        count += 1;
        isAlive = true;
    }
    public Cat(Double weight, String name)
    {   this();
        this.weight = weight;
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void setName()
    {this.name = name;}
    public void setWeight()
    {this.weight = weight;}
    public static Cat copyCat(Cat cat)
    {
        return new Cat(cat.getWeight(),cat.getName());
    }




    public  void setCatColor(ColorCat type)
    {
    this.catColor = type;
    }
    public ColorCat getCatColor()
    {
        return catColor;
    }
    public  Boolean checkLife()
    {
        life = weight > minWeight && weight < maxWeight;
        return life;
    }

    public void meow()
    { if(isAlive) {

        weight = weight - 1;
        System.out.println("Meow");
        if(!checkLife())
        {
            isAlive = false;
            count-=1;
            System.out.println("Кошка умерла");
        }
    }

         else {
             System.out.println("Кошка мертва");}
        }




    public void feed(Double amount)
    {
        if(isAlive){

            weight = weight + amount;
            grams += amount;
            if(!checkLife())
            {
                isAlive = false;
                count-=1;
                System.out.println("Кошка умерла");
            }
        }

        else {
            System.out.println("Кошка мертва");
        }



        }


    public void drink(Double amount)
    {
        if(isAlive){

            weight = weight + amount;
            if(!checkLife())
            {
                isAlive = false;
                count-=1;
                System.out.println("Кошка умерла");
            }
        }
        else {
            System.out.println("Кошка мертва");
        }


    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
    public void pee()
    {
        if(isAlive){

            weight = weight - 50;
            System.out.println("Pee Pee");
            if(!checkLife())
            {
                isAlive = false;
                count-=1;
                System.out.println("Кошка умерла");
            }
        }
        else {
            System.out.println("Кошка мертва");
        }


    }
    public Double howMuchFeed()
    {
        return grams;
    }
    public static int getCount(){ return count;}
}