public class Manager implements Employee {
    private double fixSalary = 30000;
    private double moneyForCompany;
    private double salary;
    private Company company;

    public Manager() {
        getMonthSalary();
    }

    @Override
    public double getMonthSalary() {
        moneyForCompany = Math.round(115000 + (25000 * Math.random()));
        salary = Math.round(fixSalary + (moneyForCompany * 0.95));
        return salary;
    }

    public double getMoneyForCompany() {
        return moneyForCompany;
    }

    @Override
    public void setCompany( Company company) {
        this.company = company;
    }
}
