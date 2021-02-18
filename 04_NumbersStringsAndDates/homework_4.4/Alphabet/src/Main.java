public class Main {
    public static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for( int i = 0; i < alphabet.length(); i++) {
            System.out.println(alphabet.charAt(i) + "\t" + (int) alphabet.charAt(i));
        }
    }
}

