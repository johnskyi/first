import java.time.LocalDate;

public class CardAccount extends BankAccount
{
    private LocalDate dateOfCreation;
    private LocalDate dateOfPutMoney;
    private static final  double COMMISSION_FOR_WITHDRAWAL = 0.99;
    public CardAccount(double accountAmount) {
        super(accountAmount);
        dateOfCreation = LocalDate.now();
    }
    public boolean takeMoney(double amount)
    {
        amount = amount / COMMISSION_FOR_WITHDRAWAL;
        super.takeMoney(amount);
        return true;
    }
    public String toString() {

        super.toString();
        accountInfo+= "Комиссия за снятие: " + (100 - (COMMISSION_FOR_WITHDRAWAL * 100)) + "%" +  "\n";
        return accountInfo;
    }
    public void putMoney(double amount)
    {
        super.putMoney(amount);
        dateOfPutMoney = LocalDate.now();
    }
}

