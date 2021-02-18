

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        // Найм 180 операторов
        for(int i = 0;i < 181; i++)
        {
            company.hire(new Operator());
        }
        // найм 80 менеджеров
        for(int i = 0;i < 81; i++) {
            company.hire(new Manager());
        }
        //найм 10 топ-менеджеров
        for( int i = 0; i < 11 ; i++) {
            company.hire(new TopManager());
        }
        System.out.println("Прибыль компании: " + company.getIncome());
        company.showList();
        //увольнение 50 % сотрудников
            company.fire(50);
        //Печатаем 15 самых высоких зарплат
        company.getTopSalaryStaff(15);
        // Печатаем список 30 самых низких зарплат
        company.getLowestSalaryStaff(30);

    }
}
