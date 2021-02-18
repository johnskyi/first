public class Main {

  public static void main(String[] args) {

  }

  public static String splitTextInToWords(String text) {
    //TODO реализуйте метод
    String newText = "";
    if(text.equals(""))
    {
     newText = newText;
    }
    else {
      text = text.replaceAll("[0-9\\,\\.\\-\\?\\!\\;\\:]", " ");
      String[] textArray = text.split("\\s+");
      for (int i = 0; i < textArray.length; i++) {
        newText += textArray[i] + "\n";
      }
    }
    newText = newText.trim();
    return newText;
  }

}