public class Entrepreneur extends Client{
    public Entrepreneur(double bankAccount) {
        super(bankAccount,1.0,0);
    }
    protected double putMoreCommission = 0.5;

    @Override
    public void putMoney(double amount) {
        getDatePutMoney();
        if(amount <= 1000)
        {
            super.putMoney(amount);
        }
        else
        {
            super.putMoney(amount,0.5);
        }

    }
    @Override
    public String toString() {
        return super.toString()
                + "Условия пополнения: комиссия  " + putCommission+ "% (сумма пополнения меньше 1000)" + "\n"
                + "Условия пополнения: комиссия  " + putMoreCommission + "% (сумма пополнения больше 1000)" + "\n"
                + "Условия снятия: комиссия  " + takeCommission + "%";
    }
}
