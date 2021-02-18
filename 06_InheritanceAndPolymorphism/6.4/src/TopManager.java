public class TopManager implements Employee{
    private double fixSalary = 300000;
    private double salary;
    private Company company;
    @Override
    public double getMonthSalary()
    {
        if(company.getIncome() > 10000000)
        {
            fixSalary += fixSalary * 1.5;
        }
        salary = fixSalary;
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
