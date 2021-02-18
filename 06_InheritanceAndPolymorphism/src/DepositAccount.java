import java.time.LocalDate;

public class DepositAccount extends BankAccount
{
    private LocalDate dateOfCreation;
    private LocalDate dateOfPutMoney;
    private LocalDate putAllowedTime;
    public DepositAccount(double accountAmount){
        super(accountAmount);
        dateOfCreation = LocalDate.now();
    }

    public boolean takeMoney(double amount)
    { if(putAllowedTime.isBefore(LocalDate.now()))
    {
       super.takeMoney(amount);
       return true;
    }
    else
    {
        System.out.println("После последнего внесения прошло меньше месяца");
        return false;
    }
    }
    public void putMoney(double amount)
    {
        super.putMoney(amount);
        dateOfPutMoney = LocalDate.now();
       putAllowedTime = dateOfPutMoney.plusMonths(1);
    }
}
