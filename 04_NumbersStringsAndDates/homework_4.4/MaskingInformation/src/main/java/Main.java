public class Main {

    public static void main(String[] args) {


    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '<' && text.charAt(i + 1) == '<')
            {
                text = text;
                break;
            }
            if (text.charAt(i) == '<' | text.charAt(i) == '>') {
                String subText = text.substring(text.indexOf('<'), text.indexOf('>') + 1);
                text = text.replace(subText,placeholder);

            }
            else {text = text;}
        }



        return text;
    }

}