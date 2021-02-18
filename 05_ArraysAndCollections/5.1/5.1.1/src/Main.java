import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        String[] words = {"каждый","охотник","желает","знать","где","сидит","фазан"};
        for(int i = 0; i < words.length / 2;i++)
        {
            String wordsA = words[i];
            words[i] = words[words.length - i -1];
            words[words.length - i -1] = wordsA;
        }
        for(String print:words)
        {
            System.out.println(print);
        }
    }
}

