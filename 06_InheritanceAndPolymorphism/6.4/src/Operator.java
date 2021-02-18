public class Operator  implements Employee{
    private double salary = 25000;
    private Company company;
    @Override
    public double getMonthSalary() {
        return salary;
    }
    public double getMoneyForCompany() {
        return 0;
    }

    @Override
    public void setCompany( Company company) {
        this.company = company;
    }
}
