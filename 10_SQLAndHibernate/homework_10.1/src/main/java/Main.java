import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "rootroot";
        String pass = "test";
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT  DISTINCT pl.course_name, " +
                    "COUNT(pl.subscription_date) /MAX(MONTH(pl.subscription_date)) AS month " +
                    "FROM PurchaseList pl  GROUP BY pl.course_name;");
            while (resultSet.next())
            {
                String courseName = resultSet.getString("course_name");
                String subscriptionDate = resultSet.getString("month");
                System.out.print(courseName +"\t");
                System.out.println(subscriptionDate);
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
