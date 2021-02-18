import java.time.LocalDate;

public class BankAccount {


    private double accountAmount;
    private LocalDate dateOfCreation;
    private LocalDate dateOfPutMoney;
    public String accountInfo;
    public BankAccount(double accountAmount) {
        dateOfCreation = LocalDate.now();
        putMoney(accountAmount);
    }
    public double getAccountAmount() {
        return accountAmount;
    }
    public boolean takeMoney(double amount)
    {
        if(amount > accountAmount)
        {
            System.out.println("Запрашиваемая сумма больше остатка на счете");
            return false;
        }
        else {
            accountAmount -= amount;
            return true;
        }
    }
    public void putMoney(double amount)
    {
        accountAmount += amount;
        dateOfPutMoney = LocalDate.now();
    }
    public String toString()
    {
        accountInfo = "Остаток на счете: " + getAccountAmount() + "\n"
                + "Дата создания счета: " + dateOfCreation + "\n"
                + "Дата последнего пополнения счета: " + dateOfPutMoney + "\n";
        return accountInfo;
    }
    public boolean sendMoney(BankAccount account, double amount)
    {
        if(takeMoney(amount)) {
            account.putMoney(amount);
            System.out.println("Перевод выполнен");
            return true;
        }
        else
            {
                System.out.println("Перевод не выполнен");
                return false;
            }
    }

}
