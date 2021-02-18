import java.util.ArrayList;
import java.util.Comparator;

public class Company {

    public double income;
    public ArrayList<Employee> employees = new ArrayList<>();

    public Company() {
        getEmployees();
        getIncome();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void hire(Employee name) {
        name.setCompany(this);
        employees.add(name);
        income += name.getMoneyForCompany();
    }

    public void hireAll(ArrayList<Employee> name) {
        this.employees.addAll(name);
        name.forEach(e -> e.setCompany(this));
    }

    public void fire(int percent) {
        for (int i = 0; i < percent + 1; i++) {
            var removedEmployee = employees.remove(0);
            removedEmployee.setCompany(null);
        }
    }

    public double getIncome() {
        return income;
    }

    public void showList() {
        for (Employee list : employees) {
            System.out.println(list.getMonthSalary());
        }
    }

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        employees.sort(Comparator.comparing(Employee::getMonthSalary));
        for (int i = 0; i <= count; i++) {
            System.out.println(employees.get(i).getMonthSalary());
        }
        return employees;
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        employees.sort(Comparator.comparing(Employee::getMonthSalary));
        for (int i = employees.size() - 1; i >= employees.size() - count; i--) {
            System.out.println(employees.get(i).getMonthSalary());
        }
        return employees;
    }
}




