import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        //TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
        // кто пришёл в году, указанном в переменной year
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.set(year, 00, 01);
        cal2.set(year + 1, 00, 01);
        Date date1 = cal1.getTime();
        Date date2 = cal2.getTime();
        Stream<Employee> stream = staff.stream();
        return stream.filter(employee -> employee.getWorkStart().after(date1))
                .filter(employee -> employee.getWorkStart().before(date2))
                .max(Comparator.comparing(Employee::getSalary))
                .get();

    }
}