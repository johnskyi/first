public class Main {

  public static void main(String[] args) {






  }

  public static int calculateSalarySum(String text){
    //TODO: реализуйте метод
    int allSum = 0;
    String salary = text.replaceAll("[^0-9 ]","");
    salary = salary.trim();
    if(salary.equals(""))
    {
      System.out.println(text);
    }
    else {
      String[] sum = salary.split("\\s+");
      int[] intSum = new int[sum.length];
      for (int i = 0; i < sum.length; i++) {
        intSum[i] = Integer.parseInt(sum[i]);
        allSum += intSum[i];
      }

    }
    return allSum;


  }

}