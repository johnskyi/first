import java.time.LocalDate;

public abstract class Client {
    public Client(double bankAccount, double putCommission, double takeCommission)
    {
        getDateCreation();
        putMoney(bankAccount);
       this.putCommission =  putCommission;
       this.takeCommission =  takeCommission;
    }
    protected double bankAccount;
    protected double putCommission;
    protected double takeCommission;
    private LocalDate dateCreation = LocalDate.now();

    private LocalDate datePutMoney = LocalDate.now();
    public LocalDate getDateCreation() {
        return dateCreation;
    }
    public LocalDate getDatePutMoney() {
        return datePutMoney;
    }
    public  void putMoney(double amount)
    {
        amount = amount * ((100 - putCommission) / 100);
        bankAccount += amount;
        getDatePutMoney();
    }
    public boolean takeMoney(double amount)
    {
        amount = amount / ((100 - takeCommission) / 100);

        if(bankAccount >= amount)
    {
        bankAccount -= amount;
        System.out.println("Снятие проведено \n" + "Остаток на счете: " + bankAccount);
        return true;
    }
    else{
        return false;
    }
    }
    protected void putMoney(double amount , double commission)
    {
        amount = amount * ((100 - commission) / 100);
        putMoney(amount);
        getDatePutMoney();

    }
    public   String toString()
    {
         return "Баланс счета: " + bankAccount + "\n"
                + "Дата создания счета: " + getDateCreation() + "\n"
                + "Дата последнего пополнения: " + getDatePutMoney() + "\n";
    }

}
